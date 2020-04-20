//author: Ervin Colston

import java.io.FileWriter;
import java.io.IOException;

//This is the UI class.  It displays the cards to be memorized and the cards input UI, 


public class UI {

	Cards uiUser = new Cards();
	Correct collect = new Correct();
	int testLength = 0;
	
	public void cardView(int column, boolean bool) throws IOException { //works
		uiUser.randomize();
		uiUser.jokerRand();
		int spacing = 0;
		int length;
		String array[];
		
		if(bool) //set the length depending on whether or not you're using joker cards or not
		{
			length = uiUser.jokerCards.length;
			array = uiUser.jokerCards;
			this.testLength = uiUser.jokerCards.length;
		}
		else
		{
			length = uiUser.cards.length;
			array = uiUser.cards;
			this.testLength = uiUser.cards.length;
		}
		
		FileWriter systemWriter = new FileWriter("systemAttempt.txt"); //works like a charm!
		for(int i = 0; i < length; i++)
		{
			System.out.print(array[i] + " ");
			systemWriter.write(array[i] + " \n");
			spacing++;
			if(spacing % column == 0)
			{
				System.out.println();
			}
		}
		systemWriter.close();
		
	}
	
	
}
