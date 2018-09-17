package core;

//a CARD
public class Card {
private String score;

public Card(String s){
 this.score = s;
}

public int getScore(){

 String word = score.substring(1);
 if(word.equals("A")){
   return 11;
 } else if (word.equals("J") || word.equals("Q") || word.equals("K")){
   return 10;
 } else {
   int num = Integer.parseInt(word);
   return num;
 }
}

public String toString(){
    return this.score;
  }

}
