
public class School {
	public static void main(String[] args) {
		
		Student[] students = new Student[3]; //student type의 배열 선언
		
		students[0] = new UndergraduateStudent("학부생 형곤", 201902722, "컴퓨터융합학부", (byte) 1, "SPG-AnA-PAI");
		students[1] = new GraduateStudent("대학원생 형곤", 201902722, "컴퓨터융합학부", (byte) 1, "a Lab", 100000000);
		students[2] = new Student("고등학생 형곤", 2019, "No department", (byte) 3);
		
		//각각의 객체에 대해 print함수 호출
		for(Student s : students) {
			System.out.printf("클래스 명 : %s\n", s.getClass().getName());
			s.print();
			System.out.println();
		}
	}
}
