package core;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private int myScore = 0;
    private List<Card> myCardsList = new ArrayList<Card>();

    public List<Card> getMyCardList(){
      return myCardsList;
    }

    public int getScore(){

      return this.myScore;
    }

    public void addPlayerCard(Card c){
      myCardsList.add(c);
      this.myScore += c.getScore();
      System.out.println("You get a new Card: "+c.toString());
      System.out.println("Your total score now is: "+this.myScore);
    }

}
