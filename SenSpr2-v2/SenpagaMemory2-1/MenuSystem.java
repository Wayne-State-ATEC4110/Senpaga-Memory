//package randomWordGame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Sprint 2 UI
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
	 * Sprint 2
	 * First menu the user accesses, wherein they will select their preferred game mode.
	 */
	public static void gameModeMenu() {
		System.out.println("1) Practice \n2) Competitive \n3) Custom\n");
		choice = scan.nextInt();
		if (choice == 1) {
			fileSelectMenu();
			//Timer or no timer
		}
		else if (choice == 2) {
			//stopwatch
			fileSelectMenu();
		}
		else if (choice == 3) {
			fileSelectMenu();
			//how many words 
			//timer or no timer
		}
		else {
			System.out.println(reprompt);
			gameModeMenu();
		}
	}
	
	/**
	 * Sprint 1, but new UI
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
	 * Sprint 1, but new UI
	 * User selects their file(s).
	 */
	//*user* words before they proceed to the difficulty menu
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
	 * Sprint 2
	 * Difficulty Menu allows users to set their difficulty based on word count.
	 * @throws InterruptedException thrown when sleep is interrupted before/during execution.
	 * Thrown due to control going to the startGame function of MemorizeWordsGame class.
	 */
	public static void difficultyMenu() throws InterruptedException {
		
		System.out.println("Select a Difficulty from the options below.\n");
		System.out.println("1) Easy \n2) Medium \n3) Hard\n");
		choice = scan.nextInt();
		if (choice == 1) {
			gameArrayList.addAll(ArrayListOps.sublistOfWords(20));
			MemorizeWordsGame.startGame();
		}
		else if (choice == 2) {
			gameArrayList.addAll(ArrayListOps.sublistOfWords(40));
			MemorizeWordsGame.startGame();
		}
		else if (choice == 3) {
			gameArrayList.addAll(ArrayListOps.sublistOfWords(60));
			MemorizeWordsGame.startGame();
		}
		else {
			System.out.println(reprompt);
			difficultyMenu();
		}
		
	}
		
	
}
