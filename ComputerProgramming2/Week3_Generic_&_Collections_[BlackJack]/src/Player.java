import java.util.ArrayList;
import java.util.Iterator;

public class Player {
	private ArrayList<Card> hand;

	public Player() {
		hand = new ArrayList<Card>();
	}

	public ArrayList<Card> getHand(){
		return hand;
	}

	public void hit(Card card) {
		hand.add(card);
	}

	public int getScore() {
		int sum = 0;
		Iterator<Card> iter = hand.iterator();
		while(iter.hasNext()) {
			String rank = iter.next().getRank();
			int score = 0;
			if(rank.equals("A")) {
				score = (sum > 10) ? 1 : 10;
			} else if(rank.equals("J") || rank.equals("Q") || rank.equals("K")) {
				score = 10;
			} else {
				score = Integer.parseInt(rank);
			}
			sum += score;
		}
		return sum;
	}

	public String getHandStatus() {
		StringBuilder sb = new StringBuilder();
		Iterator<Card> iter = hand.iterator();
		sb.append("{ ");
		while(iter.hasNext()) {
			sb.append(iter.next()).append(" ");
		}
		sb.append("}");
		return sb.toString();
	}

	public boolean isBust() {
		return (getScore() > 21);
	}

	public boolean isBlackJack() {
		return (getScore() == 21);
	}

}
