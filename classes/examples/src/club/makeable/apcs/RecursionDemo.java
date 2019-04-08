package club.makeable.apcs;

public class RecursionDemo {

	public static void main(String[] args) {
		
		int seriesCount = 6;
//		factorial(seriesCount);
// 		fibonacci(seriesCount);
		boolean isIt = isPalindrome("Ax Santa lived as a Devil at NASA");
		System.out.println("Is it palindrome: " + isIt);
	}
	
	// N! = N * (N-1)! = N * (N-1) * (N-1-1)! ... = N * (N-1) * (N-2) * .... * 2  *1
	public static int factorial(int num) {
		int next = 0;
		
		if( num <= 1 ) {
			return 1;
		}
		
		System.out.println( "+++ " + num + "  next=" + next);

		next = num * factorial(num-1);
		
		System.out.println( "--- " + num + "  next=" + next);
		
		return next;
	}

	// Fib(n) = Fib(n-1) + Fib(n-2)
	public static int fibonacci(int num) {
		int next = 0;
		
		if( num <= 2 ) {
			return 1;
		}
		
		System.out.println( "+++ " + num + "  next=" + next);

		next = fibonacci(num-1) + fibonacci(num-2) ;
		
		System.out.println( "--- " + num + "  next=" + next);
		return next;
	}
	
	// abcba
	public static boolean isPalindrome(String str)
	{
		System.out.println("Original string: " + str);

		String sanitizedStr = str.replace(" ", "");
		sanitizedStr = sanitizedStr.toLowerCase();
		System.out.println("Clean version: " + sanitizedStr);
		System.out.println();
		
		return isPalindrome(sanitizedStr, 0, sanitizedStr.length());
	}
	
	private static boolean isPalindrome(String str, int start, int end) 
	{	
		// would this cause problem?
		// System.out.println("Processing: " + str.substring(start, end));
		
		if( start >= end ) {
			return true;	
		}
		else 
		{
			System.out.println("Processing: " + str.substring(start, end));

			String first = str.substring(start, start+1);
			String last = str.substring(end-1, end);
			
			if( first.equals(last))  {
				return isPalindrome(str, start+1, end-1);
			}
			else {
				return false;
			}
		}
	}
}
