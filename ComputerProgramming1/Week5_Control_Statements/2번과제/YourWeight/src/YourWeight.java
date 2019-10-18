import java.util.Scanner;

public class YourWeight {
	
	public static void main(String args[]) {
		int height, weight;
		double stdWeight;
		Scanner input = new Scanner(System.in);
		for(int i=0; i<4; i++) { //5번 반복
			System.out.print("키를 입력하세요 : ");
			height = input.nextInt();
			System.out.print("체중을 입력하세요 : ");
			weight = input.nextInt();
			stdWeight = (height-100) * 0.9; //표준체중
			
			if(stdWeight * 1.1 < weight) { //표준체중 + 10%보다 몸무게가 큰 경우
				System.out.println("당신은 과체중입니다");
			} else if (stdWeight * 0.9 > weight) { //표준체중 - 10% 보다 몸무게가 작은 경우
				System.out.println("당신은 저체중입니다");
			} else { // 표준체중 - 10% <= 몸무게 <= 표준체중 + 10%인 경우
				System.out.println("당신은 표준체중입니다");
			}
			System.out.println("");
		}
		
		input.close();
	}

}
