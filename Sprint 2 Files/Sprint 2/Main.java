package randomWordGame;

/**
 * Main class creates single instance of MenuSystem object.
 * 
 * @author Christine
 *
 */

public class Main {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		
		MenuSystem gameMenu = MenuSystem.getInstance();
		
		System.out.println("\nWelcome to Senpaga Memory: Memorize Words!\n "
				+ "\nSelect a Game Mode from the options below.\n");
		
		gameMenu.gameModeMenu();
	}

}
