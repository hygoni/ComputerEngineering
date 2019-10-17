import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Player player = new Player();
		CardDeck deck = new CardDeck();
		System.out.println("--- [BlackJack] ---");
		System.out.println("게임을 시작합니다.");
		System.out.println("플레이어가 카드 2장을 뽑습니다.");
		deck.shuffle();
		player.hit(deck.popCard());
		player.hit(deck.popCard());
		System.out.println("<현재 카드 상태>");
		System.out.println(String.format("Player : %s / Score : %d", player.getHandStatus(), player.getScore()));
		
		while(true) {
			if(player.isBust()) {
				System.out.println("Bust!!");
				break;
			} else if(player.isBlackJack()) {
				System.out.println("BlackJack!!");
				break;
			}
			
			System.out.println();
			System.out.println("카드를 더 받으시겠습니까?(y/n)");
			String hit = input.nextLine();
			if(hit.equalsIgnoreCase("y")) {
				player.hit(deck.popCard());
				System.out.println("<현재 카드 상태>");
				System.out.println(String.format("Player : %s / Score : %d", player.getHandStatus(), player.getScore()));
			} else {
				break;
			}
		}
		
		
		input.close();
	}
}
