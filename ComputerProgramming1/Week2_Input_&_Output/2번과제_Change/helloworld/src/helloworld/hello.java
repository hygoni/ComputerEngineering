package helloworld;
import java.util.Scanner;

public class hello {
	
	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);
		System.out.print("받은 돈 : ");
		double money = input.nextInt();
			
		
		System.out.print("상품의 총액 : ");	
		double price_sum = input.nextInt();
		
		double tax = price_sum * 0.1;
		double changes = money-price_sum;
		
		System.out.println("부가세 : " + tax);
		System.out.println("잔돈 : " + changes);
		

	}

}
