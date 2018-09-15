package core;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {
	Card card1 = new Card("C10");
	Card card2 = new Card("SJ");
	Card card3 = new Card("H5");
	
	public void testNumOfCardInTheList(){
		Player p = new Player();
		assertEquals(0, p.getMyCardList().size());
		p.addPlayerCard(card1);
		assertEquals(1, p.getMyCardList().size());
		p.addPlayerCard(card2);
		assertEquals(2, p.getMyCardList().size());	
	}
	
	public void testPlayerCardScore(){
		Player p = new Player();
		assertEquals(0, p.getScore());
		p.addPlayerCard(card1);
		assertEquals(10, p.getScore());
		p.addPlayerCard(card3);
		assertEquals(15, p.getScore());	
	}
}
