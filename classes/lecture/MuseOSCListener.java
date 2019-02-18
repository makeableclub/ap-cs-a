package com.oracle.appslab.musespherodriver;

import java.util.Date;
import java.util.List;

import android.util.Log;

import com.illposed.osc.OSCListener;
import com.illposed.osc.OSCMessage;

/**
 *
 */
public class MuseOSCListener implements OSCListener {
	private static final String TAG = "Muse-Sphero-Driver";

	private boolean messageReceived = false;
	private Date receivedTimestamp = null;

	private long lastReceivedTime = 0;
	private boolean dataStalled = false;

	// default ACC data is 50 message/second (20ms). Let's sample it to 100 ms read
	private int sampleRate = 5;
	private int counter=0;
    private int counter; // 0


	private float[] accRead = new float[3];
	private float   eegRead = 200f;

	private MainActivity caller;
	private boolean monitorFlag = true;

	public void setMessageReceivedNotification(MainActivity notified) {

		messageReceived = false;
		caller = notified;

		// create a new Thread to monitor data freshness
		Thread monitor = new Thread(new DataMonitorThread());
		monitorFlag = true;
		monitor.start();
	}

	public Date getReceivedTimestamp() {
		return receivedTimestamp;
	}

	public boolean isMessageReceived() {
		return messageReceived;
	}

	public boolean isDataStalled() {
		return dataStalled;
	}

	public float[] getACCReading() {
		return accRead;
	}

	public float getEEGReading() {
		return eegRead;
	}

	/**
	 * Read ACC data and drive Sphero
	 */
	@Override
	public void acceptMessage(Date time, OSCMessage message) {
		if( counter++ < sampleRate ) {
			// Log.d(TAG, "skip OSC data sample, with sampleRate=" + sampleRate);
			return;
		}
		else {
			counter = 0;
		}

		// "receivedTimestamp" does not seem to work, use "lastReceivedTime" instead
		receivedTimestamp = time;
		long now = (new Date()).getTime();
		lastReceivedTime = now;

		// Log.d(TAG, "got OSC message: " + message.getAddress());
		if( message.getAddress().contains("acc") ) {
			List<Object> args = message.getArguments();
			for(int i=0; i<3; i++) {
				accRead[i] = (Float) args.get(i);
			}
		}

		if( message.getAddress().contains("eeg") ) {
			List<Object> args = message.getArguments();
			// average over the 4 channels
			float tmp = 0.0f;
			for(int i=0; i<4; i++) {
				tmp = tmp + (Float)args.get(i);
			}
			eegRead = tmp / 4.0f;
		}

		// for debug
		/*
		String strArg = "";
		for( Object arg : args ) {
			strArg = strArg + arg + " | ";
		}
		Log.d(TAG, strArg);
		*/

		if ( messageReceived == false ) {
			// we are just getting message now.... notify for the first time
			caller.onOSCMessageReceived();
			messageReceived = true;
		}
	}

	public void stopMonitor() {
		monitorFlag = false;
	}

	class DataMonitorThread implements Runnable {
		@Override
		public void run() {
			while( monitorFlag ) {
				long now = (new Date()).getTime();
				if( now - lastReceivedTime > 3500 ) {
					dataStalled = true;
					// Log.d(TAG, "No incoming Muse data");
				}
				else {
					dataStalled = false;
				}

				try {
					Thread.sleep(2000);
				}
				catch(Exception e) {};
			}
		}
	}
}
