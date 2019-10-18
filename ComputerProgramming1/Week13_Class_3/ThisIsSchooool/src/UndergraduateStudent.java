
public class UndergraduateStudent extends Student {

	String clubName;
	
	//생성자
	public UndergraduateStudent(String name, int studentNumber, String department, byte grade, String clubName) {
		super(name, studentNumber, department, grade);
		this.clubName = clubName;
	}
	//Getters & Setters
	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	
	@Override //Student 클래스의 toString 메서드를 재정의해 super 클래스에서 print 메서드를 호출할 때 정보를 추가적으로 호출하도록 함.
	public String toString() {
		return super.toString() + String.format("\n[동아리] : %s", clubName);
	}

}
