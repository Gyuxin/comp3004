package core;

import java.util.Scanner;
import java.io.*;

public class Game {

  Poker pk = new Poker();
  public Player p = new Player();
  public Computer c = new Computer();
  Scanner sc = new Scanner(System.in);
  private File file;
  private boolean consoleInput = false;
  
  
  public Game() {
	  this.file = new File("./src/test/resources/playerBurst.txt");
  }
  
  
  public Game(File file) {
	  this.file = file;
  }
  
  
  /*Start a new game*/
  public void play(boolean consoleInput) throws FileNotFoundException {
	     System.out.println("----------- A new game begin ----------");
		 this.consoleInput = consoleInput; 
		 try{
		     initGames();
		     computeScore();
		 } catch(IllegalArgumentException ex){
			 System.out.println(ex.getMessage());
		 }
		    }
	

  /*
   * Player's turn 
   * Ask Player hit or stand recursively
   * */
  public void playerTurn(Player p){
	  	System.out.println("\n----------- It's your turn ----------");
	     while(true){
	         if(p.getScore()>21) { //burst
	        	 break;
	         } else {
	             System.out.println("\nHit(H) or Stand(S)?");
	             char input;
	             if(sc.hasNext()) {
	            	 input = sc.next().charAt(0);
	             } else {
	            	 throw new IllegalArgumentException("ERROR: no next card available ");
	             }
	             System.out.println(input+"\n");
	             if (input == 'H' || input == 'h'){
	            	 if(consoleInput){
	            		 p.addPlayerCard(pk.getOneCard());
	            	 } else {
	            		 if(sc.hasNext()){
		            		 Card temp = pk.getOneCardFromFileInput(sc.next());
		            		 p.addPlayerCard(temp);
	            		 }
	            	 }
	             } else if (input == 'S' || input == 's') {
	            	 break;
	             } else {
	            	 throw new IllegalArgumentException("ERROR: Invalid input " + input);
	             }
	         }
	     }
	     System.out.println("\nEnd of Your Turn! \n"+p.toString());
  }
  
  
  /*
   * Dealer (Computer) determine hit or stand
   * */
 public void dealerTurn(Computer c){
     System.out.println("\n------------It's dealer's turn---------- ");
     System.out.println(c.toString()+"\n");
     while(true){
    	 if(c.getScore()>21) { 
    		 break;
    	 } else {
        	 boolean computerHit = c.hitOrNot();
    		 if (computerHit) {
            	 if(consoleInput){
            		 c.addComputerCard(pk.getOneCard());
            	 } else {
            		 if(sc.hasNext()){
	            		 Card temp = pk.getOneCardFromFileInput(sc.next());		//automatically add a new card to hand card
	            		 c.addComputerCard(temp);
	            	  } else {
	            			 throw new IllegalArgumentException("ERROR: No Next Card Available!" );
	            		 }
            	 }
    		 } else {
    			 break;
    		 }
    	 }
     }
     System.out.println("\nEnd of Dealer's Turn! \n"+c.toString());
 }


   /*
   initial a game with two cards for dealer and player.
   Display the first card of computer's cards
   */
  public void initGames() throws FileNotFoundException {
	  
	  pk.initPoker();
	  Card c1,c2,c3,c4;
	  if(!consoleInput){	
		  sc = new Scanner(file);
		  c1 = pk.getOneCardFromFileInput(sc.next());
		  c2 = pk.getOneCardFromFileInput(sc.next());
		  c3 = pk.getOneCardFromFileInput(sc.next());
		  c4 = pk.getOneCardFromFileInput(sc.next());  
	  } else {
		  c1 = pk.getOneCard(); //initialize four cards
		  c2 = pk.getOneCard();
		  c3 = pk.getOneCard();
		  c4 = pk.getOneCard();
	  }

	     p.addPlayerCard(c1);
	     p.addPlayerCard(c2);

	     Card tempCard = c3;
	     c.addComputerCard(tempCard);
	     System.out.println("Computer card: "+tempCard.toString());
	     c.addComputerCard(c4);
	     
	     if(!blackJack(p.getScore()) && !blackJack(c.getScore())){
			  if(playerCanSplit(c1,c2)){
				  splitGames(true,c1,c2);
			  }
			  else if(dealerCanSplit(c3,c4,c.getScore())){
				  splitGames(false,c3,c4);
			  }
			  else {
			     playerTurn(p);
			     dealerTurn(c);
			  }
	    }
	  } 
  
  //Determine blackjack for dealer and user
  public boolean blackJack(int i){
	  if(i==21){
		  return true;
	  } 
	  return false;
  }
  
  
  // Determine can player split the card or not.
  public boolean playerCanSplit(Card c1, Card c2){
	  if(c1.toString().substring(1).equals(c2.toString().substring(1))){
			  System.out.println("\nSPLIT(D) or Not(N)?\n");
			  char input = sc.next().charAt(0);
			  System.out.println(input+"\n");
			  if(input == 'd' || input == 'D'){
				  return true;
			  } else if(input == 'n' || input == 'N' ) {
				  return false;
			  } else {
				  throw new IllegalArgumentException("ERROR: Invalid input " + input);
			  }
	  }
	  return false;
  }
  
  // Determine can Computer split the card or not.
  public boolean dealerCanSplit(Card c1, Card c2, int s){
	  if(c1.toString().substring(1).equals(c2.toString().substring(1))){
		  if(s<=17){
			  return true;
		  }
  }
  return false;
  }
  
  
  // Split the card for dealer or player. 
  public void splitGames(boolean playerOrDealer,Card c1, Card c2){
	  if(playerOrDealer){
			
		  Player p1 = new Player();
		  p1.addPlayerCard(c1);
		  if(!this.consoleInput){	  
			  Card temp = pk.getOneCardFromFileInput(sc.next());		//automatically add a new card to hand card
				  p1.addPlayerCard(temp);
		  } else {
			  p1.addPlayerCard(pk.getOneCard());	
		  }
		  playerTurn(p1);
		
		  Player p2 = new Player();
		  p2.addPlayerCard(c2);
		  if(!this.consoleInput){
			  Card temp = pk.getOneCardFromFileInput(sc.next());		//automatically add a new card to hand card
				  p2.addPlayerCard(temp);
		  } else {
			  p2.addPlayerCard(pk.getOneCard());
		  }
		  playerTurn(p2);
		  dealerTurn(c);
		  
		  if(p1.getScore()>p2.getScore() && p1.getScore() <= 21){
			  p = p1;
		  } else {
			  p = p2;
		  }
			  
	  } else {
		  
		  System.out.println("\nDealer Split the card ...\n");
		  playerTurn(p);
		  
		  Computer cp1 = new Computer();
		  cp1.addComputerCard(c1);
		  dealerTurn(cp1);
		  
		  Computer cp2 = new Computer();
		  cp2.addComputerCard(c2);
		  dealerTurn(cp2);		
		  
		  if(cp1.getScore()>cp2.getScore() && cp1.getScore() <= 21){
			  c = cp1;
		  } else {
			  c = cp2;
		  }
	  }
  }

  
   public void computeScore(){
	   
     if((c.getScore() >= p.getScore() && c.getScore() <=21) || p.getScore() > 21 ){
       System.out.println("\n=========== Computer Win! ===========\n");
     } else {
     System.out.println("\n========== You Win! =========\n");
   }
     System.out.println(c.toString()+"\n"+c.scoreToString());
     System.out.println(p.toString()+"\n"+p.scoreToString());
     
     
   }

}
