package club.makeable.apcs;
import java.util.*;

public class StandardClass {

	private void testObjectMethods() {
		System.out.println("=== test object methods ===");
		Object obj1 = new Object();

		// toString()
		String obj1Str = obj1.toString();
		System.out.println( obj1Str );

		int obj1Hash = obj1.hashCode();
		System.out.println( obj1Hash );

		Account acct1 = new BankAccount("name", "pass");
		Account acct2 = new BankAccount("name", "pass");
		Account acct3 = acct1;

		System.out.println( acct1.toString() );
		System.out.println( acct2.toString() );

		// equals
		System.out.println( "acct1==acct2: " + (acct1 == acct2) );
		System.out.println( "acct1 equals acct2: " + acct1.equals(acct2) );

		System.out.println( "acct1==acct3: " + (acct1 == acct3) );
		System.out.println( "acct1 equals acct3: " + acct1.equals(acct3) );
		System.out.println( "acct1 equals null: " + acct1.equals(null) );

		Student s1 = new Student("Emily", "Las Lomas", 10);
		Student s2 = new Student("Emily", "Las Lomas", 10);

		System.out.println( "student1==student2: " + (s1 == s2) );
		System.out.println( "student1 equals student2: " + s1.equals(s2) );		// override equals()


	}

	private void testStringMethods() {
		System.out.println("=== test string methods ===");

		String s1 = "abc";		// string literals. special case for String to be initialized just like primitive type
		String s2 = new String("abc");

		String s3 = "abc"; 
		String s4 = "dc"; 
		String s5 = "a" + "bc";
		// String s6 = 3+ 4;    // String.valueOf(3 + 4);

		System.out.println( "s1==s2: " + (s1 == s2) );
		System.out.println( "s1 equals s2: " + s1.equals(s2) );

		System.out.println( "s1==s3: " + (s1 == s3) );
		System.out.println( "s1==s5: " + (s1 == s5) );
		// string literals having the same value, share the same memory address!!

		System.out.println( "s1 compareTo s2: " + s1.compareTo(s2) );
		System.out.println( "s3 compareTo s4: " + s3.compareTo(s4) );

		System.out.println( "ABC compareTo ABCD: " + "ABC".compareTo("ABCD") );
		System.out.println( "abc compareTo ABC: " + "abc".compareTo("ABC") );
		System.out.println( "ABC compareTo 12345: " + "ABC".compareTo("12345") );

		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int length = alphabet.length(); // alphabet[0]: index (0, length-1)
		System.out.println("alphabet: length() = " + length );
		System.out.println("substring(0): " + alphabet.substring(0));
		System.out.println("substring(length): " + alphabet.substring(length));
		// System.out.println("substring(length+1): " + alphabet.substring(length+1)); // try +/-1
		// System.out.println("substring(-1): " + alphabet.substring(-1));
		System.out.println("substring(20, length): " + alphabet.substring(20, length));

		System.out.println("substring(1,3): " + alphabet.substring(1,3));
		// System.out.println("substring(5,3): " + alphabet.substring(5,3));
		System.out.println("substring(6,6): " + alphabet.substring(6,6));

		System.out.println("indexOf(\"fgh\"): " + alphabet.indexOf("fgh"));
		System.out.println("indexOf(\"fee\"): " + alphabet.indexOf("fee"));
		
		System.out.println("\"fghfghfgh\".indexOf(\"fgh\"): " + "fghfghfgh".indexOf("fgh"));
		
	}

	private void testWrapperClasses() {
		System.out.println("=== test wrapper classes ===");

		// Integer
		
		// Double
		
		// Boolean
		
		// List<Integer> intList = new ArrayList<Integer>();
		// int[] intArray = new int[10];
		
	}
	
	private void testMathClass() {
		System.out.println("=== test Math class ===");

		// Math:  all static methods (taking values through parameters)
		/*
		static int abs(int x)
		static double abs(double x)
		static double pow(double base, double exp)
		static double sqrt(double x)
		static double random()  // 0.0 <= result < 1.0
		*/
		System.out.println("Math.abs(-3): " + Math.abs(-3));
		System.out.println("Math.abs(3.0): " + Math.abs(3.0));
		System.out.println("Math.pow(5.0, 3.2): " + Math.pow(5.0, 3.2));
		System.out.println("Math.sqrt(5.0): " + Math.sqrt(5.0));
		
		// generate a random int between [20,50)
		int result = (int)(Math.random()*(50-20)) + 20;
		System.out.println("random(20,50): " + result);
		
	}
	
	private void testArrayList() {
		System.out.println("=== test List interface, ArrayList class ===");

		// Student[] studentArray = new Student[10];
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("name1", "school1", 5));
		studentList.add(new Student("name2", "school2", 6));
		studentList.add(2, new Student("name3", "school3", 6));
		
		System.out.println("List content 1: " + studentList);
		
		System.out.println(studentList.size());
		System.out.println(studentList.get(1));
		
		studentList.set(1, new Student("name4", "school4", 8));
		System.out.println("List content 2: " + studentList);

		studentList.remove(2);
		System.out.println("List content 3: " + studentList);

		Student[] stype = new Student[0];
		Student[] students = (Student[]) studentList.toArray();
		Student[] students2 = studentList.toArray(stype);
		
		
		/*
			boolean add(E obj);
			void add(int index, E element);
			int size();
			E get(int index);
			E set(int index, E element);
			E remove(int index);
			
			Loop, IndexOutofBounds
		 */
		
		
	}

	public static void main(String[] args) {
		StandardClass std = new StandardClass();

//		std.testObjectMethods();
//		std.testStringMethods();
//		std.testWrapperClasses();
//		std.testMathClass();
		std.testArrayList();
	}

}
