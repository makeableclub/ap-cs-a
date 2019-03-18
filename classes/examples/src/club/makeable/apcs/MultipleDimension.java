package club.makeable.apcs;

public class MultipleDimension {
	
	static int[][] matrix1;
	static String[] games = { "chess", "go", "tic-tac-toe" };
	static int[] intArray = {1, 2, 3, 4, 5, 6, 7};
	
	private void initialize2Darray() {
		int[] arr = {1, 2, 3};

		
		int[][] temp = 
			{
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
			};
		matrix1 = temp;
	}
	
	
	private int[][] generate2Dprimitive() {
		// 5 - row, 8 - column 
		int[][] data = new int[5][8];
		
		int[] temp = data[1];
		
		for (int r=0; r < data.length; r++) {
			for (int c=0; c < data[r].length; c++) {
				data[r][c] = genInt(1,100);			}
		}
		return data;
	}
	
	
	private void reverseMatrix(int[][] matrix) {
		for (int r=0; r < matrix.length/2; r++) {
			int[] temp = matrix[r];
			matrix[r] = matrix[matrix.length-1-r];
			matrix[matrix.length-1-r] = temp;

			reverseArray(matrix[r]);
		}
		// the middle row needs to be reverse too
		if (matrix.length%2 == 1) {
			reverseArray(matrix[matrix.length/2]);
		}
		
		printData(matrix);
	}
	
	
	// pass reference
	private void reverseArray(int[] arr) {
		for (int i=0; i < arr.length/2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
	}
	
	
	// print out the content of 2D array --> rewrite this in "for-each" loop
	private void printData(int[][] data) {
		for (int r=0; r < data.length; r++) {
			for (int c=0; c < data[r].length; c++) {
				System.out.print(  " " + data[r][c] + " ");			
			}
			System.out.println();
		}		
	}
	
	private void printArray(String[] strs) {
		for(String str : strs) {
			System.out.print(str + " ");
		}
		System.out.println();
	}
	private void printArray(int[] ints) {
		for(int num : ints) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	// generate a random integer [min, max], inclusively
	private int genInt(int min, int max) {
		return min + (int)(Math.random()* (max+1 - min));
	}

	
	
	public static void main(String[] args) {
		MultipleDimension tester = new MultipleDimension();
		tester.initialize2Darray();
		tester.printData(matrix1);
		
		tester.printData(tester.generate2Dprimitive());
		
		tester.reverseMatrix(matrix1);

		tester.printArray(games);
		
		tester.printArray(intArray);
		
		tester.reverseArray(intArray);
		
		tester.printArray(intArray);

	}

}
