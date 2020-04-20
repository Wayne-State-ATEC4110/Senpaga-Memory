package randomWordGame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Sprint 2/3 UI
 * This class encapsulates a menu system for Senpaga-Memory players to navigate the 
 * Word Memorization Game.
 * 
 * @author Christine
 *
 */
public class MenuSystem{
	

	private static String reprompt = "Invalid input, please choose from the options above. \n";
	private static Scanner scan = new Scanner(System.in);
	private static int choice;
	protected static ArrayList<String> gameArrayList = new ArrayList<String>();
	private static MenuSystem singleInstance = null;
	
	/**
	 * Sprint 2
	 * Singleton Constructor of the MenuSystem class.
	 */
	private MenuSystem() {
		System.out.println("Menu System initialized.");
	}
	
	/**
	 * Ensuring that there is only one instance of the MenuSystem class.
	 * @return MenuSystem singleInstance.
	 */
	public static MenuSystem getInstance() {
		if (singleInstance == null) 
			singleInstance = new MenuSystem();
		
		return singleInstance;
	}
	
	
	/**
	 * Sprint 1/2 
	 * New UI implemented in Sprint 2.
	 * Optional menu the user can access before they begin the game to manage words in 
	 * the SenpagaUserWords.txt.
	 */
	public static void wordManagementMenu() {
		System.out.println("Select from the options below.\n");
		System.out.println("1) Add Words \n2) Delete Words \n3) Quit\n");
		choice = scan.nextInt();
		if (choice == 1) {
			SenpagaFileOps.addWords();
			
		}
		else if (choice == 2) {
			SenpagaFileOps.deleteWords();
			
		}
		else if (choice == 3)
			try {
				difficultyMenu();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else {
			System.out.println(reprompt);
			wordManagementMenu();
		}
		
	}
	
	/**
	 * Sprint 1/2
	 * New UI implemented in Sprint 2
	 * User selects their file(s).
	 */
	public static void fileSelectMenu() {
		System.out.println("Select your file(s) from the options below.");
		System.out.println("1) Default \n2) User \n3) Foreign \n4) Deafult + User"
				+ "\n5) Default + Foreign \n6) User + Foreign \n7) All "
				+ "\n8) Quit\n");
		
		boolean flag = true; //flag used to break out of infinite loop
		
		do {
			choice = scan.nextInt();
		switch(choice) {
		case 1:
			ArrayListOps.populateArrayList(0, 1);	
			continuePrompt();
			flag = false;
			break;
		case 2:
			ArrayListOps.populateArrayList(1, 2);	
			continuePrompt();
			flag = false;
			break;
		case 3:
			ArrayListOps.populateArrayList(2, 3);	
			continuePrompt();
			flag = false;
			break;
		case 4:
			ArrayListOps.populateArrayList(0, 2);	
			continuePrompt();
			flag = false;
			break;
		case 5:
			ArrayListOps.populateArrayList("Default and Foreign");
			continuePrompt();
			flag = false;
			break;
		case 6:
			ArrayListOps.populateArrayList(1, 3);
			continuePrompt();
			flag = false;
			break; 
		case 7:
			ArrayListOps.populateArrayList(0, 3);
			continuePrompt();
			flag = false;
			break;
		case 8:
			System.out.println("\nQuitting to Senpaga Memory Home...");
			flag = false; 
			break;
		default:
			System.out.println("Invalid Input. Enter a number between 1 and 6.\n");
			break;
	}
		}while(flag); //hasNext creates an infinite loop situation
		
	}
	
	/**
	 * Sprint 2
	 * User is asked if they want to manage their SenpagaUserWords.txt file before they set
	 * their difficulty.
	 */
	public static void continuePrompt() {
		System.out.println("Would you like to manage your words before continuing? "
				+ "\n1) Yes \n2) No\n");
		choice= scan.nextInt();
		if (choice == 1) 
			wordManagementMenu();
		else if (choice == 2)
			try {
				difficultyMenu();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			System.out.println(reprompt);
	}
	
	/**
	 * Sprint 2/3
	 * Difficulty Menu allows users to set their difficulty based on word count.
	 * InterruptedException thrown due to control going to the timerSelect function.
	 */
	public static void difficultyMenu() throws InterruptedException {
		gameArrayList.clear();
		
		System.out.println("Select a Difficulty from the options below.\n");
		System.out.println("1) Easy \n2) Medium \n3) Hard \n4) Custom\n");
		int customNum;
		choice = scan.nextInt();
		if (choice == 1) {
			gameArrayList.addAll(ArrayListOps.sublistOfWords(20));
			timerSelect();
		}
		else if (choice == 2) {
			gameArrayList.addAll(ArrayListOps.sublistOfWords(40));
			timerSelect();
		}
		else if (choice == 3) {
			gameArrayList.addAll(ArrayListOps.sublistOfWords(60));
			timerSelect();
		}
		
		else if (choice == 4) {
		    int fileSize = ArrayListOps.arrayOfWords.size();
		    
			System.out.println("Enter a custom number of words to memorize.");
			customNum = scan.nextInt();
			
			while (customNum > fileSize) {
				System.out.println("Not enough words in file. Words in File: " + fileSize 
						+ "\nPlease choose a smaller number or add more words to the file. "
						+ "\nNOTE:CAN ONLY ADD TO USER FILE. ");
			
				customNum = scan.nextInt();
			}
			
				gameArrayList.addAll(ArrayListOps.sublistOfWords(customNum));
				timerSelect();
			
		}
		
		else {
			System.out.println(reprompt);
			difficultyMenu();
		}
		
	}
	
	/**
	 * Sprint 3
	 * User is asked if they want to be timed before they start their game.
	 * Throws InterruptedException because of countDown function in MemorizeWordsGame class.
	 * Control goes to startGame function within said class.
	 */
		
	public static void timerSelect() throws InterruptedException {
		
		System.out.println("Would you like to be timed? "
				+ "\n1) Yep, I'm pretty competitive. MLG status actually."
				+ " \n2) Nah, I'm just practicin'. I'm a total n00b.");
		
		choice = scan.nextInt();
		if (choice == 1) {
			MemorizeWordsGame.startGameWithTimer();
		}
		
		else if (choice == 2) {
			MemorizeWordsGame.startGame();
		}
	}
}