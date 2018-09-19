package core;

import junit.framework.TestCase;

public class ComputerTest extends TestCase {
	Card card1 = new Card("C10");
	Card card2 = new Card("SJ");
	Card card3 = new Card("H5");
	Card card4 = new Card("DA");
	Card card5 = new Card("HA");
	Card card6 = new Card("H3");
	Card card7 = new Card("H6");
	Card card8 = new Card("D2");
	
	public void testNumOfCardInTheList(){
		Computer c = new Computer();
		assertEquals(0, c.getComputerCardsList().size());
		c.addComputerCard(card1);
		assertEquals(1, c.getComputerCardsList().size());
		c.addComputerCard(card2);
		assertEquals(2, c.getComputerCardsList().size());	
	}
	
	public void testComputerCardScore(){
		Computer c = new Computer();
		assertEquals(0, c.getScore());
		c.addComputerCard(card1);
		assertEquals(10, c.getScore());
		c.addComputerCard(card3);
		assertEquals(15, c.getScore());	
	}
	
	public void testScoreIncludingAce(){
		Computer c = new Computer();
		c.addComputerCard(card3);
		c.addComputerCard(card4);
		assertEquals(16, c.getScore());
		
		Computer c2 = new Computer();
		c2.addComputerCard(card1);
		c2.addComputerCard(card2);
		c2.addComputerCard(card5);
		assertEquals(21, c2.getScore());
		
		Computer c3 = new Computer();
		c3.addComputerCard(card1);
		c3.addComputerCard(card6);
		c3.addComputerCard(card4);
		assertEquals(14, c3.getScore());
		
	}
	
	public void testDealerShouldHit(){
		Computer c = new Computer();
		c.addComputerCard(card6);
		c.addComputerCard(card3);
		assertTrue(c.hitOrNot());
	}
	
	public void testDealerHitForSoft17(){
		Computer c = new Computer();
		c.addComputerCard(card4);
		c.addComputerCard(card7);
		assertTrue(c.hitOrNot());
	}
	
	public void testDealerCanHitRepeatly(){
		Computer c = new Computer();
		c.addComputerCard(card5);
		c.addComputerCard(card6);
		assertTrue(c.hitOrNot());
		c.addComputerCard(card8);
		assertTrue(c.hitOrNot());
		c.addComputerCard(card3);
	}	
	
	public void testDealerShouldStand(){
		Computer c = new Computer();
		c.addComputerCard(card1);
		c.addComputerCard(card2);
		assertTrue(!c.hitOrNot());
	}
	
}
