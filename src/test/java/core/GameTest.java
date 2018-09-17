package core;

import junit.framework.TestCase;

public class GameTest extends TestCase{
	
	public void testPlayerCanSplitTheSameCard(){
		Game g = new Game();
		Card c1 = new Card("DK");
		Card c2 = new Card("HK");
		Card c3 = new Card("SJ");
		assertTrue(g.playerCanSplit(c1, c2));
		assertTrue(!g.playerCanSplit(c1, c3));
	}
	
	public void testDealerCanSplitTheSameCard(){
		Game g = new Game();
		Computer c = new Computer();
		Card c1 = new Card("DK");
		Card c2 = new Card("HK");
		Card c3 = new Card("S3");
		Card c4 = new Card("C3");
		c.addComputerCard(c1);
		c.addComputerCard(c2);
		assertTrue(!g.dealerCanSplit(c1, c2, c.getScore()));
		
		Computer cp = new Computer();
		cp.addComputerCard(c3);
		cp.addComputerCard(c4);
		assertTrue(g.dealerCanSplit(c4, c3, cp.getScore()));
	}
}
