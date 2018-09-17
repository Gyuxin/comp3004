package core;
import java.util.ArrayList;
import java.util.List;
public class Player {
    private int myScore = 0;
    private List<Card> myCardsList = new ArrayList<Card>();
    private boolean ace = false;

    public List<Card> getMyCardList(){
      return myCardsList;
    }

    public int getScore(){
      return this.myScore;
    }

    public void addPlayerCard(Card c){
      includeAce(c);
      myCardsList.add(c);
      this.myScore += c.getScore();
      if(ace){
          if(this.myScore > 21){
            this.myScore = this.myScore - 10;
            ace = false;
          }
        }

      System.out.println("You get a new Card: "+c.toString());
      
    }

    public void includeAce(Card c){
    	String s = c.toString().substring(1);
    	if(s.equals("A")){
    		this.ace = true;
    	} 
    }
    
    public String toString(){
    	String result = "You have cards: ";
    	for(int i=0; i<this.myCardsList.size(); i++){
    		result += this.myCardsList.get(i).toString()+" ";
    	}
    	return result;
    }
    
    public String scoreToString(){
    	return "Total value for player is: " + this.getScore();
    }
}
