package club.makeable.apcs;

import java.util.ArrayList;

public class TestParameter {
    public void changeValues(int integer, String string, Student student, ArrayList<Student> students) {
        // double it
        integer = integer * 2;
        string = string + " Well, actually it is not.";
        student.setSchool("North Gate");
        student = new Student("Bella", "Las Lomas", 11);
        students.add(student);
    }

    public static void main(String args[]) {
        int int1 = 103;
        String str1 = "This is a short string.";
        Student student1 = new Student("Allan", "Las Lomas", 10);
        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList.add(student1);

        TestParameter tester = new TestParameter();

        System.out.println("before changeValues() call: ");
        System.out.println( int1 );
        System.out.println( str1 );
        System.out.println( student1.toString() );
        System.out.println( studentList );

        tester.changeValues(int1, str1, student1, studentList);

        System.out.println("after changeValues() call: ");
        System.out.println( int1 );
        System.out.println( str1 );
        System.out.println( student1.toString() );
        System.out.println( studentList );
    }
}
