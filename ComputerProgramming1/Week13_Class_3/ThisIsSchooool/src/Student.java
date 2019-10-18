public class Student {
	
	private String name;

	private int studentNumber;
	private byte grade;
	private String department;
	
	//생성자
	public Student(String name, int studentNumber, String department,byte grade){
		this.studentNumber = studentNumber;
		this.grade = grade;
		this.name = name;
		this.department = department;
	}
	
	//Getters & Setters
	public int getStudentNumber() {
		return studentNumber;
	}
	public byte getGrade() {
		return grade;
	}
	public String getDepartment() {
		return department;
	}
	public String getName() {
		return name;
	}
	public void setGrade(byte grade) {
		this.grade = grade;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override //Object 클래스의 toString 메서드 재정의
	public String toString(){
		return String.format("[학번] : %d\n"
				+ "[학과] : %s\n"
				+ "[학년] : %d학년", studentNumber, department, grade);
	}
	public void print() { //toString으로 반환된 문자열을 출력
		System.out.println(this.toString());
	}
	
}
