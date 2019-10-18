package helloworld;
import java.util.Scanner;

public class hello {
	
	public static void main(String args[]) {
		
		final double ONE_MILE = 1.609;
		
		Scanner input = new Scanner(System.in);
		System.out.print("마일을 입력하시오 : ");
		double miles = input.nextDouble();
		double kilometers = miles * ONE_MILE;
		
		System.out.println(miles + "마일은 " + kilometers + " 킬로미터 입니다.");
		
		input.close();
	}

}


