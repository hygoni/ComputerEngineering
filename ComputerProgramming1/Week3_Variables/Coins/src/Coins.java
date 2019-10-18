import java.util.Scanner;
//nextInt() 메소드를 호출하기 위해 Scanner 클래스를 임포트한다.
public class Coins {

	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in); //Scanner() 생성자를 통해서 인스턴스를 생성한다.
		int coin500, coin100, coin10, coin50, sum;
		System.out.print("500원 동전의 개수를 입려하시오 : ");
		coin500 = input.nextInt(); //500원 동전 개수 입력
		System.out.print("100원 동전의 개수를 입려하시오 : ");
		coin100 = input.nextInt(); //100원 동전 개수 입력
		System.out.print("50원 동전의 개수를 입려하시오 : ");
		coin50 = input.nextInt(); //50원 동전 개수 입력
		System.out.print("10원 동전의 개수를 입려하시오 : ");
		coin10 = input.nextInt(); //10원 동전 개수 입력
		
		sum = 500*coin500 + 100*coin100 + 50 * coin50 + 10*coin10; //(동전의 개수) * (동전의 가치)를 모두 더해 sum 변수에 저장한다. 
		System.out.println("저금통의 총 금액은 " + sum + "입니다."); //저금동의 총 금액(sum)을 출력한다.
		input.close();
	}
	
}
