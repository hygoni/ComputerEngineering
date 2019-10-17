package 가위바위보;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int in = 0;
		
		Player user = new Player("User");
		Player rival = new Player("Rival");
		Referee referee = new Referee();
		
		System.out.print(user.getName() + "의 선택(0: 가위, 1:바위, 2: 보): ");
		in = input.nextInt();
		user.setHand(in);
		System.out.print(rival.getName() + "의 선택(0: 가위, 1:바위, 2: 보): ");
		in = input.nextInt();
		rival.setHand(in);
		
		System.out.println(referee.getWinner(user, rival));
		
		input.close();
	}
}
