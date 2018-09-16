package core;

//52 cards
//a CARD

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
public class Poker {

String[] faceValue = {
 "DA","D2","D3","D4","D5","D6","D7","D8","D9","D10","DJ","DQ","DK",
 "SA","S2","S3","S4","S5","S6","S7","S8","S9","S10","SJ","SQ","SK",
 "HA","H2","H3","H4","H5","H6","H7","H8","H9","H10","HJ","HQ","HK",
 "CA","C2","C3","C4","C5","C6","C7","C8","C9","C10","CJ","CQ","CK"
};

private List<Card> deckPoker = new ArrayList<Card>(52);

public List<Card> getPoker(){
 return this.deckPoker;
}

public Card getOneCard(){
    Card temp = deckPoker.get(0);
    removePoker(0);
    return temp;
  }

public void initPoker(){
 for(int i = 0; i < 52; i++ ){
     Card temp = new Card(faceValue[i]);
     this.deckPoker.add(temp);
   }
 shufflePoker();
}

public void shufflePoker(){
 Collections.shuffle(deckPoker);
}

public void removePoker(int i){
 this.deckPoker.remove(i);
}

}
