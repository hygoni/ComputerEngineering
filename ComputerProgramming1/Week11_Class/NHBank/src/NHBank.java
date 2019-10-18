
public class NHBank {
	public static void main(String[] args) {
		int accountSize = 10;
		//객체의 참조변수 배열 선언
		Account[] accounts = new Account[accountSize];
		
		//객체를 생성하고 그 주솟값으로 각각의 참조변수를 초기화
		for(int i = 0; i < accountSize; i++) {
			accounts[i] = new Account("user"+i, 100000);
		}
		
		//송금
		accounts[2].send(accounts[4], 30000);
		accounts[6].send(accounts[4], 40000);
		accounts[8].send(accounts[6], 100000);
		
		//출력
		for(int i = 0; i < accountSize; i++) {
			accounts[i].print();
		}
	}
}
