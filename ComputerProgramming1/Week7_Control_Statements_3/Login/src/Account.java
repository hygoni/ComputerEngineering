import java.util.Scanner;

public class Account {
	//아이디, 비밀번호를 저장하는 속성
	private String identity;
	private String password;
	
	public void register(Scanner input) {
		System.out.println("<계정생성>");
		System.out.print("아이디를 입력하시오 : "); //아이디 입력
		this.identity = input.next();
		System.out.print("비밀번호를 입력하시오 : "); //비밀번호 입력
		this.password = input.next();
	}
	
	public void login(Scanner input) {
		System.out.println("<로그인>");
		System.out.print("ID :");
		String identity_ = input.next(); //아이디 입력
		System.out.print("PW:");
		String password_ = input.next(); //비밀번호 입력
		
		if( (this.password.equals(password_)) && (this.identity.equals(identity_)) ) { //아이디, 비밀번호가 모두 동일하다면
			System.out.println("로그인에 성공하였습니다."); //로그인 성공
		} else {
			System.out.println("로그인에 실패하였습니다."); //로그인 실패
		}
		
	}
	
}
