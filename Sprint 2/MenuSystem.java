package randomWordGame;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuSystem{
	

	private static String reprompt = "Invalid input, please choose from the options above. \n";
	private static Scanner scan = new Scanner(System.in);
	private static int choice;
	protected static ArrayList<String> gameArrayList = new ArrayList<String>();
	private static MenuSystem singleInstance = null;
	
	//singleton constructor
	private MenuSystem() {
		System.out.println("Menu System initialized.");
	}
	
	//checking that there is only once instance
	public static MenuSystem getInstance() {
		if (singleInstance == null) 
			singleInstance = new MenuSystem();
		
		return singleInstance;
	}
	
	//first menu the user accesses
	//here they select their game mode, which will ask (in the future) what timer they want 
	//practice mode has no timer currently
	//competitive simply means there is by default a timer and their scores will be recorded
	//custom mode will ask for a timer and number of words they want to memorize
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
	
	public static void fileSelectMenu() {
		System.out.println("Select your file(s) from the options below.");
		System.out.println("1) Default \n2) User \n3) Foreign \n4) Deafult + User"
				+ "\n5) Default + Foreign \n6) User + Foreign \n7) All "
				+ "\n8) Quit\n");
		
		do {
			choice = scan.nextInt();
		switch(choice) {
		case 1:
			ArrayListOps.populateArrayList(0, 1);	
			continuePrompt();
			break;
		case 2:
			ArrayListOps.populateArrayList(1, 2);	
			continuePrompt();			
			break;
		case 3:
			ArrayListOps.populateArrayList(2, 3);	
			continuePrompt();
			break;
		case 4:
			ArrayListOps.populateArrayList(0, 2);	
			continuePrompt();
			break;
		case 5:
			ArrayListOps.populateArrayList("Default and Foreign");
			continuePrompt();
			break;
		case 6:
			ArrayListOps.populateArrayList(1, 3);
			continuePrompt();
			break; 
		case 7:
			ArrayListOps.populateArrayList(0, 3);
			continuePrompt();
			break;
		case 9:
			System.out.println("\nQuitting to Senpaga Memory Home...");
			break;
		default:
			System.out.println("Invalid Input. Enter a number between 1 and 6.\n");
			break;
	}
		}while(scan.hasNext());
		
	}
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
