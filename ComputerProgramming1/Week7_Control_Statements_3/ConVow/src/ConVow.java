import java.util.Scanner;


public class ConVow {

	public static void main(String[] args) {
		
		StringConVow scv = new StringConVow(); //StringConVow 타입 인스턴스 scv 생성
		Scanner input = new Scanner(System.in);
		String text;
		
		System.out.print("문자열을 입력하시오 : ");
		text = input.next(); //문자열을 입력받는다
		scv.NumOfConVow(text); //NumOfConVow 메서드(자음, 모음 개수 확인하는) 호출
		
		input.close();
	}
	
}
