package core;

import junit.framework.TestCase;

public class CardTest extends TestCase{
	
	public void testTheScoreOfJQKCards(){
		Card jack = new Card("DJ");
		Card queen = new Card("HQ");
		Card king = new Card("SK");
		assertEquals(10, jack.getScore());
		assertEquals(10, queen.getScore());
		assertEquals(10, king.getScore());
	}
	
	public void testTheScoreOfNumCards(){
		Card card1 = new Card("C2");
		Card card2 = new Card("C10");
		assertEquals(2, card1.getScore());
		assertEquals(10, card2.getScore());
	}

}
