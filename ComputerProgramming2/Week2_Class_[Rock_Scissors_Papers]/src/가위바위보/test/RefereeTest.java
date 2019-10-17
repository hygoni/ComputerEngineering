package 가위바위보.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import 가위바위보.Player;
import 가위바위보.Referee;

class RefereeTest {

	@Test
	void testgetWinner1() {
		Player user = new Player("User");
		Player rival = new Player("Rival");
		Referee referee = new Referee();
		
		user.setHand(0);
		rival.setHand(1);

		assertEquals(referee.getWinner(user, rival) , "Rival이(가) 이겼습니다.(User: -1/ Rival: 2)");		
	}
	
	@Test
	void testgetWinner2() {
		Player user = new Player("User");
		Player rival = new Player("Rival");
		Referee referee = new Referee();
		
		user.setHand(1);
		rival.setHand(0);
		
		assertEquals(referee.getWinner(user, rival) , "User이(가) 이겼습니다.(User: 2/ Rival: -1)");		
	}
	
	@Test
	void testgetWinner3() {
		Player user = new Player("User");
		Player rival = new Player("Rival");
		Referee referee = new Referee();
		
		user.setHand(1);
		rival.setHand(1);
		
		assertEquals(referee.getWinner(user, rival) , "비겼습니다.(User: 1/ Rival: 1)");		
	}
	
	

}
