package core;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private int computerScore = 0;
    private ArrayList<Card> computerCardsList = new ArrayList<Card>();
    private boolean ace = false;

    public int getScore(){
      return this.computerScore;
    }

    public List<Card> getComputerCardsList(){
      return computerCardsList;
    }

    public void addComputerCard(Card c){
      includeAce(c);
      computerCardsList.add(c);
      this.computerScore += c.getScore();
      if(ace){
          if(this.computerScore>21){
            this.computerScore = this.computerScore - 10;
            ace = false;
          }
      }
      System.out.println("Dealer gets a new card ...");
    }
// Determine if Dealer/Computer should hit or not
    public boolean hitOrNot(){
      if(this.computerScore <= 16){
    	  System.out.println("Dealer HIT.");
    	  return true;
      } else if(this.computerScore == 17 && this.ace ){
          System.out.println("Dealer HIT.");
          return true;
      } else {
          System.out.println("Dealer STAND.");
          return false;
      }
    }
    
    public void includeAce(Card c){
      String s = c.toString().substring(1);
      if(s.equals("A")){
        this.ace = true;
      } 
    }
    
    public String toString(){
    	String result = "Dealer has cards: ";
    	for(int i=0; i<this.computerCardsList.size(); i++){
    		result += this.computerCardsList.get(i).toString()+" ";
    	}
    	return result;
    }
    
    public String scoreToString(){
    	return "Total value for dealer is: " + this.getScore();
    }
}
