package core;

import junit.framework.TestCase;

public class PokerTest extends TestCase{
	
	public void testNumberOfCardsInTotal(){
		Poker p = new Poker();
		p.initPoker();
		assertEquals(52,p.getPoker().size());
	}
	
	public void testNumberOfCardsWhenRemoveOneCard(){
		Poker p = new Poker();
		p.initPoker();
		p.removePoker();
		assertEquals(51,p.getPoker().size());
		p.removePoker();
		assertEquals(50,p.getPoker().size());
	}
	
}
