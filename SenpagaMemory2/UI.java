//author: Ervin Colston

import java.io.FileWriter;
import java.io.IOException;

//This is the UI class.  It displays the cards to be memorized and the cards input UI, 


public class UI {

	Cards uiUser = new Cards();
	Correct collect = new Correct();
	
	public void cardView(int column) throws IOException { //works
		uiUser.randomize();
		int spacing = 0;
		
		FileWriter systemWriter = new FileWriter("systemAttempt.txt"); //works like a charm!
		for(int i = 0; i < uiUser.cards.length; i++)
		{
			System.out.print(uiUser.cards[i] + " ");
			systemWriter.write(uiUser.cards[i] + " \n");
			spacing++;
			if(spacing % column == 0)
			{
				System.out.println();
			}
		}
		systemWriter.close();
		
	}
	
	
}
