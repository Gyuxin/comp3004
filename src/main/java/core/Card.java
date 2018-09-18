package core;

//a CARD
public class Card {
	
	private String score;
	
	public Card(String s){
		 this.score = s;
		 exceptionTest(s);
	}
	
	
	public void exceptionTest(String s){
		
		 if(!s.substring(0,1).equals("S") && !s.substring(0,1).equals("C") && 
			!s.substring(0,1).equals("D") && !s.substring(0,1).equals("H")){
			 throw new IllegalArgumentException("ERROR: Invalid Suit " + s.substring(0,1));
		 }
		 
		 String word = s.substring(1);
		 if(!word.equals("A") && !word.equals("2") && !word.equals("3") && !word.equals("4") && 
		    !word.equals("5") && !word.equals("6") && !word.equals("7") && !word.equals("8") &&
		    !word.equals("9") && !word.equals("10") && !word.equals("J") && !word.equals("Q") &&
		    !word.equals("K")){
			 throw new IllegalArgumentException("ERROR: Invalid Rank "+ word);
		 }
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
