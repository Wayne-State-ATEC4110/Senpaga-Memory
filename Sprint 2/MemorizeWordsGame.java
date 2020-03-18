package randomWordGame;

import java.util.ArrayList;

public class MemorizeWordsGame {

	//private static ArrayList<String> theList = new ArrayList<String>();
	public static void startGame() throws InterruptedException {
		
		System.out.println("Game starting in: \n3..." );
		Thread.sleep(1000);
		System.out.println("2...");
		Thread.sleep(1000);
		System.out.println("1...\n");
		Thread.sleep(1000);
		
		//timer start
		ArrayListOps.displayWords(MenuSystem.gameArrayList);
		
		//timer end 
		
		//take user input to check amount correct
		
		//print score and time
		
	
		
	}
}
