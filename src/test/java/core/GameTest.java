package core;

import java.io.File;
import java.io.FileNotFoundException;

import junit.framework.TestCase;

public class GameTest extends TestCase{

	public void testPlayerCanHit() throws FileNotFoundException {
		Game g = new Game(new File("./src/test/resources/playerCanHit.txt"));
		g.play(false);
		assertEquals(4,g.p.getMyCardList().size());			//Player Hit to get more than initial number of cards.
	}
	
	public void testPlayerCanRepeatlyHit() throws FileNotFoundException {
		Game g = new Game(new File("./src/test/resources/playerCanRepeatlyHit.txt"));
		g.play(false);
		assertEquals(4,g.p.getMyCardList().size());			//Player Hit to get more than initial number of cards.
	}

	public void testPlayerCanStand() throws FileNotFoundException {
		Game g = new Game(new File("./src/test/resources/playerCanStand.txt"));
		g.play(false);
		assertEquals(2,g.p.getMyCardList().size());			//Player get only 2 cards.
	}
	
	public void testPlayerBurst() throws FileNotFoundException {
		Game g = new Game(new File("./src/test/resources/playerBurst.txt"));
		g.play(false);
		assertTrue(g.p.getScore()>21);			
	}
	
	public void testDealerBurst() throws FileNotFoundException {
		Game g = new Game(new File("./src/test/resources/dealerBurst.txt"));
		g.play(false);
		assertTrue(g.c.getScore()>21);			
	}
	
	public void testDealerBlackJack() throws FileNotFoundException {
		Game g = new Game(new File("./src/test/resources/dealerBlackJack.txt"));
		g.play(false);
		assertEquals(21,g.c.getScore());			
	}
	
	public void testPlayerBlackJack() throws FileNotFoundException {
		Game g = new Game(new File("./src/test/resources/playerBlackJack.txt"));
		g.play(false);
		assertEquals(21,g.p.getScore());			
	}
	
	
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
