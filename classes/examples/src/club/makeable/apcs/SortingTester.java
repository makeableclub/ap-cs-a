package club.makeable.apcs;

public class SortingTester {
	private static boolean isDebugMode = true;
	private static int[] dataArray;
	
	/**
	 * algorithm of selection sort:  
	 * going through all unsorted elements one by one, and in each iteration: 
	 * main cost is to scan and find the "smallest" in unsorted portion, i.e. linear time: O(n), 
	 * add the "smallest" to the tail of sorted portion is constant time: O(1)
	 * 
	 * the steps:
	 * 1. maintain a sorted portion on left, and unsorted on right;
	 * 2. pick an element, and go through the unsorted portion to pick out smallest one in that iteration
	 * 3. add the picked out element to the end of sorted portion
	 * 4. repeat 2-3 until all the unsorted elements having been processed
	 */
	public void selectionSort() {
		// repeatedly going through all unsorted data
		for(int i=0; i<dataArray.length; i++) 
		{
			//step 2: try to pick out the smallest in this iteration, initialize it with first element
			int min = dataArray[i];
			int minIndex = i;
			
			for(int j=i+1; j<dataArray.length; j++ ) 
			{
				// if found a smaller one, get its value and its index as the "smallest" one
				if( dataArray[j] < min) 
				{
					min = dataArray[j];
					minIndex = j;
				}
			}
			//step 3: swap the position between current element "dataSet[i]" and "smallest" one in this iteration 
			int temp = dataArray[i];
			dataArray[i] = min;
			dataArray[minIndex] = temp;
		}
	}
	
	/**
	 * algorithm of insertion sort:
	 * going through all unsorted elements one by one, and in each iteration: 
	 * pick the first element in unsorted portion, which is linear time: O(1), 
	 * main cost is to add the proper slot in sorted portion, which linear time: O(n)
	 *
	 * the steps:
	 * 1. maintain a sorted portion on left, and unsorted on right;
	 * 2. pick first element from the unsorted portion;
	 * 3. compare that element with elements in sorted portion, starting from tail end, until it is smaller/equal to an element in the sorted list
	 * 4. repeat 2-3 until all the unsorted elements having been processed
	 */
	public void insertionSort() {
		// try to process all unsorted elements, starting from 2nd element
		for(int i=1; i<dataArray.length; i++) {
			// step 2:  current value and index: i
			int currentValue = dataArray[i];

			/// step 3
			for(int j=i-1; j>=0; j--) 
			{
				// if currentValue is larger than/equal to the element at slot j, break out and we are done
				if( currentValue >= dataArray[j]) {
					break;
				}
				else {
					// swap slot element with currentValue
					dataArray[j+1] = dataArray[j];
					dataArray[j] = currentValue;
				}
			}
		}
	}
	
	/**
	 * algorithm of merge sort:
	 * recursively splitting a large array into two halves, 
	 * and then sort each of the two halves and merge them in a sorted manner.
	 * 
	 * The split is done according to the array index position
	 */
	public void mergeSort() {
		// sort the enture dataSet, from 0 to dataSet.length-1
		this.mSort(0, dataArray.length-1);
	}
	
	// private helper method to do the actual recursive calls
	// to sort the portion of elements dataSet[left...right]
	//
	private void mSort(int left, int right) {
		// recursion ending condition
		if (left >= right) {
			return;
		}

		// get middle point, and positionally split into smaller problems
		int mid = (left + right)/2;
		
		// sort the two halves
		mSort(left, mid);
		mSort(mid+1, right);
		
		// as soon as we have two halves done at one particular level, need to merge them at that level
		merge(left, mid, right);
	}
	
	// merge two sub-halves of an array portion (the portion between "left" and "right" in the dataSet)
	// first portion:  dataSet[left...mid]
	// second portion: dataSet[mid+1...right]
	// this is one drawback:  we have to create temporary arrays for the two halves
	private void merge(int left, int mid, int right) {
		// the size of two sub-halves
		int n1 = mid - left + 1;
		int n2 = right - mid;
		
		// temporary array to hold the two-halves
		int[] leftArr = new int[n1];
		int[] rightArr = new int[n2];
		
		// copy data into temporary array for the two halves
		for (int i=0; i<n1; i++) {
			leftArr[i] = dataArray[left+i];
		}
		for (int j=0; j<n2; j++) {
			rightArr[j] = dataArray[mid+1+j];
		}

		// DEBUG:
		if( isDebugMode) {
			System.out.println("left - right");
			this.printArray(leftArr);
			this.printArray(rightArr);
		}

		// merge the two temporary arrays for the two halves
		//
		// initial index of the two temp array
		int i=0;
		int j=0;
		
		// initial index for merged array
		int k = left;
		
		while(i<n1 && j<n2) {
			// both arrays still have data to process
			if (leftArr[i] <= rightArr[j]) {
				// take leftArr[i]
				dataArray[k] = leftArr[i];
				i++;
			}
			else {
				// take rightArr[j]
				dataArray[k] = rightArr[j];
				j++;
			}
			// increment k
			k++;
		}
		
		// to this point, either leftArr or rightArr has reached to the end
		// no need to merge, just copy whatever remaining in the other temp array
		//
		// copy them if anything remaining in leftArr:
		while( i<n1 ) {
			dataArray[k] = leftArr[i];
			i++;
			k++;
		}
		// or copy them if anything remaining in rightArr:
		while( j<n2 ) {
			dataArray[k] = rightArr[j];
			j++;
			k++;
		}
		
		if (isDebugMode)
			System.out.println("left...right merged\n");
	}
	
	/**
	 * algorithm of quick sort:
	 * divide and conquer, using a pivot element to divide data array into smaller sub-array
	 * we call divide-by-pivot as partition, in the value space (vs position index)
	 */
	public void quickSort() {
		// the range of data to be processed, starting with entire data set
		// valid index range: 0, length-1
		this.qSort(0, dataArray.length-1);
	}
	
	/**
	 * recursive quick sort
	 * 1. partition the range into two portions, using pivot element values
	 * 2. recursively call with left and right range
	 * 
	 * @param left
	 * @param right
	 */
	private void qSort(int left, int right) {
		// base ending condition
		if (left >= right) {
			return;
		}
		
		// first we need to partition the array based one a pivot value
		// so that all element value that is smaller than pivot is on side, 
		// and larger one on another size, and the pivot element is at its proper slot
		int pi = partition(left, right);
		if (isDebugMode) 
			this.printArray(dataArray);
		
		// recursively sort elements before, and after the pivot element
		if (isDebugMode) 
			System.out.println("left portion");
		qSort(left, pi-1);

		if (isDebugMode) 
			System.out.println("right portion");
		qSort(pi+1, right);
	}
	
	/**
	 * partition the dataArray elements range from left...right, so that pivot element is in the right spot
	 * with one side having smaller elements, and the other side having larger elements
	 * 
	 * @param left
	 * @param right
	 * @return the position of pivot element
	 */
	private int partition(int left, int right) {
		// we can randomly pick an element as pivot element
		// here I just use the right-most element 
		int pivot = dataArray[right];
		
		int i = left-1; // i - the index in the smaller range, increments only when a element is placed in that portion
		int j = left;	// j - as the walking index for the whole range, minus right-most pivot element
		
		for (j=left; j<right; j++) 
		{
			if (dataArray[j] <= pivot) 
			{
				i++;
				
				// swap data at i and j:
				// data[j] is smaller than pivot for sure based on above condition
				// data[i] is larger than pivot (notice i++ above, which means the elment behind i), 
				// if had it been smaller, it should be under i already, 
				// assuming we have processed that element already (where j is ahead of i)
				int temp = dataArray[i];
				dataArray[i] = dataArray[j];
				dataArray[j] = temp;
			}
		}
		
        // finally, put pivot to the right spot:
		// swap dataArray[i+1] and dataArray[high] (or pivot) 
        int temp = dataArray[i+1]; 
        dataArray[i+1] = dataArray[right]; 
        dataArray[right] = temp; 

        // and this is the index for the pivot element
        return i+1; 
	}
	
	
	
	public void printArray(int[] data) {
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i] + "  " );
		}
		System.out.println();
	}
	
	/*
	 * generate an array of integer data
	 * @param size	The array size 
	 */
	public int[] genData(int size) {
		int[] data = new int[size];
		
		for(int i=0; i<size; i++) {
			data[i] = (int)(Math.random()*100 + 1);
		}
		return data;
	}

	// main program to drive the testing of different sorting algorithms
	//
	public static void main(String[] args) {
		SortingTester tester = new SortingTester();
		
		// produce a random array of data
		dataArray = tester.genData(20);
		
		// print out the unsorted data array
		tester.printArray(dataArray);
		
		long start = System.nanoTime();
		// --------------------------
		// tester.selectionSort();
		// tester.insertionSort();
		// tester.mergeSort();
		tester.quickSort();
		// --------------------------
		long duration = System.nanoTime() - start;
		if (isDebugMode) 
			System.out.println("Time taken: " + duration);
		
		// print out the sorted data array
		tester.printArray(dataArray);		
	}

}
