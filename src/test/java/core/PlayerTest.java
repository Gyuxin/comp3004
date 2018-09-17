package core;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {
	Card card1 = new Card("C10");
	Card card2 = new Card("SJ");
	Card card3 = new Card("H5");
	Card card4 = new Card("DA");
	Card card5 = new Card("HA");
	Card card6 = new Card("H3");
	Card card7 = new Card("H9");
	Card card8 = new Card("H8");
	Card card9 = new Card("H7");
	
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
	
	public void testScoreIncludingAce(){
		Player p = new Player();
		p.addPlayerCard(card5);
		p.addPlayerCard(card4);
		assertEquals(12, p.getScore());
		
		Player p2 = new Player();
		p2.addPlayerCard(card1);
		p2.addPlayerCard(card5);
		p2.addPlayerCard(card2);
		assertEquals(21, p2.getScore());
		
		Player p3 = new Player();
		p3.addPlayerCard(card1);
		p3.addPlayerCard(card6);
		p3.addPlayerCard(card4);
		assertEquals(14, p3.getScore());
		
		Player p4 = new Player();
		p4.addPlayerCard(card7);
		p4.addPlayerCard(card8);
		p4.addPlayerCard(card4);
		p4.addPlayerCard(card9);
		assertEquals(25, p4.getScore());
		
	}
}
