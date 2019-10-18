
public class GraduateStudent extends Student {
	
	String labName;
	int supportMoney;
	
	//생성자
	public GraduateStudent(String name, int studentNumber, String department, byte grade, String labName, int supportMoney) {
		super(name, studentNumber, department, grade);
		this.labName = labName;
		this.supportMoney = supportMoney;
	}
	
	//Getters & Setters
	public String getLabName() {
		return labName;
	}
	public void setLabName(String labName) {
		this.labName = labName;
	}
	public int getSupportMoney() {
		return supportMoney;
	}
	public void setSupportMoney(int supportMoney) {
		this.supportMoney = supportMoney;
	}
	@Override //super 클래스의 toString 메서드를 재정의해 super 클래스에서 print 메서드를 호출할 때 정보를 추가적으로 호출하도록 함.
	public String toString() {
		return super.toString() + String.format("\n[연구실] : %s\n"
				+ "[지원금] : %d", labName, supportMoney);
	}

	

}
