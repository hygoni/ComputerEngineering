import java.util.Scanner;

public class ControlFlow {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		String msg = (num % 2 == 0) ? "Hello, Contest!" : "Hello, Algorithm!"; //num�� Ȧ��, ¦���Ŀ� ���� �޽����� �ٸ��� ����
		num = (num % 2 == 0) ? num : num+1; //num�� Ȧ����� num += 1
		
		for(int i = 0; i < num; i++) { //num�� ũ�⸸ŭ �޽��� ���
			System.out.println(msg);
		}
		input.close();
	}
}
