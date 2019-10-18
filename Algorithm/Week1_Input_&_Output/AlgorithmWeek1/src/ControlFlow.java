import java.util.Scanner;

public class ControlFlow {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		String msg = (num % 2 == 0) ? "Hello, Contest!" : "Hello, Algorithm!"; //num이 홀수, 짝수냐에 따라서 메시지를 다르게 설정
		num = (num % 2 == 0) ? num : num+1; //num이 홀수라면 num += 1
		
		for(int i = 0; i < num; i++) { //num의 크기만큼 메시지 출력
			System.out.println(msg);
		}
		input.close();
	}
}
