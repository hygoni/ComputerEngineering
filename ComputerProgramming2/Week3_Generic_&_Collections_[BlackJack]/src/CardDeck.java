import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
	private final String suits[] = {"Spade", "Heart", "Diamond", "Clob"};
	private final String ranks[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "Q", "J"};
	private ArrayList<Card> deck;
	
	//카드 52장인 덱을 생성
	public CardDeck() {
		deck = new ArrayList<Card>();
		for(int i = 0; i < suits.length; i++) {
			for(int j = 0; j < ranks.length; j++) {
				Card card = new Card(suits[i], ranks[j]);
				deck.add(card);
			}
		}
	}
	
	//제일 앞에 있는 카드를 뽑는다.
	public Card popCard() {
		return deck.remove(0);
	}
	
	//덱의 크기 반환
	public int getSize() {
		return deck.size();
	}
	
	//덱을 섞는다.
	public void shuffle() {
		Collections.shuffle(deck);
	}
}
