package core;
import java.util.Scanner;
import java.io.*;

public class BlackJack {

  public static void main(String[] args) throws FileNotFoundException {
      	
	     boolean consoleInput = false;
         Scanner sc; 
	     System.out.println("File input(F) or Console input(C) ?");
         
	     while(true){
	         sc = new Scanner(System.in);
	         char c = sc.next().charAt(0);
		     
	         if(c == 'F' || c == 'f'){
		        	consoleInput = false;
		        	break;
		      } else if (c == 'C' || c == 'c'){
		        	consoleInput = true;
		        	break;
		      } else {
		        	 System.out.println("Please enter a valid char: F or C");
		      }
         }
         
        Game g = new Game();
        g.play(consoleInput);
        sc.close();
      }
    }
