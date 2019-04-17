package club.makeable.apcs;

public class SearchTester {
	private static int[] randomData;
	private static int[] sortedData;
	
	public void linearSearch(int[] data, int target) {
		System.out.println("Linear searching for " + target + " in range of " + data[0] + " and " + data[data.length-1]);

		for(int i=0; i < data.length; i++) {
			if( target == data[i]) {
				System.out.println("found target at: " + i);
				return;
			}
			else if(target < data[i]) {
				System.out.println("Stopped at index: " + i);
				return;
			}
		}

		System.out.println("Not found ");
		
	}
	
	public void binarySearch(int[] data, int target) {
		System.out.println("Binary searching for " + target + " in range of " + data[0] + " and " + data[data.length-1]);
		
		recursiveBinSearch(0, data.length, target);
		// iterativeBinSearch(0, data.length, target);
	}
	
	private void recursiveBinSearch(int low, int high, int target) {
		if(low > high) {
			System.out.println(target + " is not found");
			return;
		}
		
		int mid = (int)((low+high) / 2);
		
//		if( mid > 0 && mid < sortedData.length) 
//		{
			System.out.println("current index : data = " + mid + " : " + sortedData[mid]);			
			if( sortedData[mid] == target ) {
				System.out.println(target + " is found at index=" + mid);
				return;
			}
			else if( target < sortedData[mid]) {
				recursiveBinSearch(low, mid-1, target);
			}
			else if( target > sortedData[mid]) {
				recursiveBinSearch(mid+1, high, target);
			}
//		}
//		else {
//			System.out.println("Index out of range, not found");
//		}
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
	
	/*
	 * generate an array of integer data
	 * @param size	The array size 
	 */
	public int[] genSortedData(int size) {
		int[] data = new int[size];
		data[0] = (int)(Math.random()*100 + 1);
		
		for(int i=1; i<size; i++) {
			data[i] = data[i-1] + (int)(Math.random()*100 + 1);
		}
		return data;
	}
	
	
	public static void main(String[] args) {
		SearchTester tester = new SearchTester();
		
		// randomData = tester.genData(20);
		sortedData = tester.genSortedData(32);

		// int target = (int) (Math.random()*3000);
		int target = sortedData[31] - 10;
		// tester.linearSearch(sortedData, target);
		tester.binarySearch(sortedData, target);
		
	}

}
