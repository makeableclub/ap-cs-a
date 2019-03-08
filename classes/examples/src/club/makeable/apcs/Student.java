package club.makeable.apcs;

public class Student {
	private String name;
	private String school;
	private int grade;  // 10, 11, 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	/**
	 * Constructor
	 * @param n
	 * @param school
	 * @param grade
	 */
	public Student(String n, String school, int grade) {
		this.name = n;
		this.school = school;
		this.grade = grade;
	}

	public String toString() {
		String student = "Name=" + this.name;
		student += " School=" + this.school;
		student += " Grade=" + this.grade;
		
		return student;
	}
}
