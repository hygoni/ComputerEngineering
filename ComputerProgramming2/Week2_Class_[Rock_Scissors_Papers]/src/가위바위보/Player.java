package 가위바위보;

public class Player {
	private String[] HANDS = {"가위", "바위", "보"};
	private int hand;
	private String name;
	private int point = 0;
	
	public Player(String name) {
		this.name = name;
	}
	
	public void setHand(int hand) {
		this.hand = hand;
	}
	
	public String getHand() {
		return HANDS[hand];
	}
	
	public void win() {
		point += 2;
	}
	
	public void lose() {
		point--;
	}
	
	public void draw() {
		point++;
	}
	
	public int getPoint() {
		return point;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name + ": " + point;
	}
}
