import java.util.Scanner;

public class Login {
	
	public static void main(String[] args) {
		Account acct = new Account(); //Account형 인스턴스 acct를 생성
		Scanner input = new Scanner(System.in);
		
		acct.register(input); //register 메서드 호출
		acct.login(input); //login 메서드 호출
		
		input.close(); //input 반환
		
	}
	
}
