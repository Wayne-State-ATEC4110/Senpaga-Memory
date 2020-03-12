package randomWordGame;

import java.util.Scanner;

public class UserInterface extends WordMemorization{
	

	
	public static void optionsMenu() {
		
		System.out.println("\n\t\t\t\t    OPTIONS");
		System.out.println("\t\t      Enter a number from the menu below.\n");
		System.out.println("\t\tUse only default words -----------------------> 1");
		System.out.println("\t\tUse only your words --------------------------> 2");
		System.out.println("\t\tUse only foreign words -----------------------> 3");
		System.out.println("\t\tUse both the default words and your words ----> 4");
		System.out.println("\t\tUse both the default words and foreign words -> 5");
		System.out.println("\t\tUse both your words and foreign words --------> 6");
		System.out.println("\t\tAdd words ------------------------------------> 7");
		System.out.println("\t\tDelete words ---------------------------------> 8");
		System.out.println("\t\tQuit to Main Menu ----------------------------> 9");
		
		int choice, startIndex, limit;
		String fileName;
		String word = null;
		Scanner scan = new Scanner(System.in);
		
		do {
			choice = scan.nextInt();
		switch(choice) {
		case 1:
			startIndex = 0;
			limit = 1;
			populateArrayList(startIndex, limit);			
			break;
		case 2:
			startIndex = 1;
			limit = 2;
			populateArrayList(startIndex, limit);
			break;
		case 3:
			startIndex = 2;
			limit = 3;
			populateArrayList(startIndex, limit);
			break;
		case 4:
			startIndex = 0;
			limit = 2;
			populateArrayList(startIndex, limit);
			break;
		case 5:
			fileName = "Default and Foreign";
			populateArrayList(fileName);
			break;
		case 6:
			startIndex = 1;
			limit = 3;
			populateArrayList(startIndex, limit);
			break;
		case 7:
			addWords();
			break;
		case 8:
			deleteWords();
			break;
		case 9:
			System.out.println("Quitting to Senpaga Memory Home Page...");
			break;
		default:
			System.out.println("Invalid Input. Enter a number between 1 and 9.");
			break;
		}
			
	} while(choice != 9);
	
		
}
	
}
	
