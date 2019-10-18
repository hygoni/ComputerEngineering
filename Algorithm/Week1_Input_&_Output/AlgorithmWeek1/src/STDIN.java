import java.util.Scanner;

public class STDIN {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println(input.nextLine()); //한 라인을 통째로 입력받아 출력
		input.close(); //자원 반환
	}
}
