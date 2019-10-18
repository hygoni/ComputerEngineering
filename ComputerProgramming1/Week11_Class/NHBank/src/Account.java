public class Account {
	
	String name;
	int balance;
	
	/**
	 * 기능 : 객체를 생성하고 멤버변수를 초기화함
	 * @param name
	 * @param balance
	 */
	public Account(String name, int balance){
		this.name = name;
		this.balance = balance;
	}
	
	/**
	 * 기능 : 입금 (잔액 += 입금할 양)
	 * @param amount
	 */
	public void deposit(int amount) {
		this.balance += amount;
	}
	
	
	/**
	 * 기능 : 출금 (출금할 양이 현재 잔액보다 많은 경우, 잔액 -= 출금할 양)
	 * @param amount
	 */
	public void withdraw(int amount) {
		if(this.balance < amount) {
			System.out.println("[ERR] 출금 실패 (사유 : 잔액부족)");
			return;
		}
		this.balance -= amount;
	}
	
	/**
	 * 기능 : 이체할 돈의 양이 현재 잔액보다 많은 경우 target의 계좌에 amount만큼 입금하고 this의 계좌에 amount만큼 출금함 
	 * @param target (instanceof Account)
	 * @param amount
	 */
	public void send(Account target, int amount) {
		if(this.balance < amount) {
			System.out.println("[ERR] 이체 실패 (사유 : 잔액부족)");
			return;
		} else if(target == null) {
			System.out.println("[ERR] 이체 실패 (사유 : 유효하지 않은 이체대상)");
			return;
		}
		
		this.withdraw(amount);
		target.deposit(amount);
		
	}
	
	/**
	 * 기능 : this의 name, balance를 출력함
	 */
	public void print() {
		System.out.printf("[이름] : %s, 잔금 : %d\n", this.name, this.balance);
	}

}
