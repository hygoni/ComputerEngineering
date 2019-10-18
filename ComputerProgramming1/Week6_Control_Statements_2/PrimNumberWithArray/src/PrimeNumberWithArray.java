
public class PrimeNumberWithArray {
	public static void main(String[] args) {
		
		int numOfPrimeNumbers = 0;
		
		for(int i = 2; i <= 99; i++) { //소수의 개수 세기
			int numOfDivisors = 0;
			for(int j = 1; j <= i; j++) {
				if(i % j == 0) {
					numOfDivisors++;
				} //end of if
			}// end of for
			
			if(numOfDivisors == 2)
				numOfPrimeNumbers++;
		} //end of for
		
		int[] primeNumbers = new int[numOfPrimeNumbers]; //소수를 저장할 배열 선언
		
		int index = 0;
		int primeNumber = 0; 
		/*for문 안의 i 변수의 scope 문제로 primeNumber 변수를 따로 선언,
		 * 소수일 경우 primeNumber에 i를 저장하며, 그렇지 않으면 0을 저장함*/
		
		for(int i = 2; i <= 99; i++) {
			System.out.printf("%d의 약수 : ", i);
			int numOfDivisors = 0; //약수의 개수
			
			for(int j = 1; j <= i; j++) {
				if(i % j == 0) { //j가 i의 약수라면
					numOfDivisors++;
					System.out.printf("%d ", j); //약수 출력
				} //end of if
				
				if(numOfDivisors > 2) { //1과 자신 외에도 약수가 있다면
					primeNumber = 0; //소수가 아님
				} else {
					primeNumber = i; //반복문이 끝날 때까지 numOfDivisors가 2이하라면 i는 소수이며 그 값은 primeNumber에 저장됨.
				}
				
			}// end of for
			
			if(primeNumber != 0) {
				System.out.println("소수입니다");
				primeNumbers[index++] = primeNumber; //배열에 소수 저장
			}
			else
				System.out.println("");
		} //end of for
		
		//99이하의 소수 출력
		System.out.print("99이하의 소수 : ");
		for(int i = 0; i < primeNumbers.length; i++) {
			System.out.printf("%d ", primeNumbers[i]);
		}
		
	} //end of main function
} //end of class
