package helloworld;
import java.util.Scanner;

public class hello {
	
	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);
		System.out.print("화씨온도를 입력하세요 : ");
		double F = input.nextDouble();
		double C = (5.0/9.0) * (F-32);
		System.out.println("섭씨온도는 " + C + " 입니다.");
 
	}

}
