package 가위바위보;

public class Referee {
	private void givePoint(Player p1, Player p2, int winner) {
		if(winner == 1) {
			p1.win();
			p2.lose();
		} else if(winner == 2) {
			p2.win();
			p1.lose();
		} else {
			p1.draw();
			p2.draw();
		}
	}

	private boolean isFirstPlayerWin(String hand1, String hand2) {
		if(hand1.equals("가위") && hand2.equals("보")) {
			return true;
		} else if(hand1.equals("바위") && hand2.equals("가위")) {
			return true;
		} else if(hand1.equals("보") && hand2.equals("바위")) {
			return true;
		} else {
			return false;
		}
	}

	private String getPlayerPoints(Player p1, Player p2) {
		return String.format("(%s/ %s)", p1.toString(), p2.toString());
	}

	public String getWinner(Player p1, Player p2) {
		boolean didFirstWin = isFirstPlayerWin(p1.getHand(), p2.getHand());
		String msg = null;

		if(didFirstWin) {
			givePoint(p1, p2, 1);
			msg = p1.getName() + "이(가) 이겼습니다.";
		} else {
			if(p1.getHand().equals(p2.getHand())){
				givePoint(p1, p2, 0);
				msg = "비겼습니다.";
			} else {
				givePoint(p1, p2, 2);
				msg = p2.getName() + "이(가) 이겼습니다.";
			}
		}
		return msg  + getPlayerPoints(p1, p2);
	}
}
