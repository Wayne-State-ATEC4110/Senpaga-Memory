//package randomWordGame;


/**
 * Sprint 2
 * Class that begins game.
 * @author Christine
 *
 */
public class MemorizeWordsGame {

	/**
	 * Sprint 2
	 * Begins game with all of the user's game selections.
	 * @throws InterruptedException thrown when sleep is interrupted before/during execution.
	 */
	
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
