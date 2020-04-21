
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Sprint 2/3
 * Class that begins game.
 * @author Christine
 *
 */
public class MemorizeWordsGame {
	
	private static long startTime;
	private static Scanner scan = new Scanner(System.in); 
	protected static ArrayList<String> userInput = new ArrayList<String>();
	
	/**
	 * Sprint 3
	 * Moved count down to a separate function to avoid repetitive block of code.
	 * Gives user 3 seconds to prepare to begin memorizing words.
	 * InterruptedException thrown when sleep is interrupted before/during execution.
	 */
	public static void countDown() throws InterruptedException {
		System.out.println("Game starting in: \n3..." );
		Thread.sleep(1000);
		System.out.println("2...");
		Thread.sleep(1000);
		System.out.println("1...\n");
		Thread.sleep(1000);
	}
	
	/**
	 * Sprint 2/3
	 * Begins game with all of the user's game selections without a timer.
	 * InterruptedException thrown when sleep is interrupted before/during execution.
	 */
	public static void startGame() throws InterruptedException {
		
		countDown();
		
		ArrayListOps.displayWords(MenuSystem.gameArrayList);
	}
		
	/**
	 * Sprint 3
	 * Begins game with all of the user's game selections with a timer.
	 * InterruptedException thrown when sleep is interrupted before/during execution.
	 * @throws IOException 
	 */
	public static void startGameWithTimer() throws InterruptedException, IOException {
		
		countDown();
		
		stopWatch();
		ArrayListOps.displayWords(MenuSystem.gameArrayList);
		Scanner scan = new Scanner(System.in);
		System.out.println("Press anything to start inputting answers.");
		scan.next();
		System.out.println("Input Answers followed by a new line.");
		
		for(int i = 0; i < MenuSystem.gameArrayList.size(); i++) {
			System.out.print((i + 1) + ". ");
			userInput.add(scan.next());
		}
		
		stopWatch();
		
		results();
		
	}
		
	/**
	 * Sprint 3
	 * Stopwatch functionality.
	 * Function to initialize stopwatch.
	 */
	public static void stopWatch() {
		startTime = System.currentTimeMillis();
	}
	
	/**
	 * Sprint 3
	 * Stopwatch functionality.
	 * Function to stop stopwatch and return the total time taken.
	 */
	public static String elapsedTime() {
        long finalTime = System.currentTimeMillis();
        double endTime = (finalTime - startTime) /1000;
        
        return ("You took: " + elapsedTime() + " seconds.\n");
        
    }
	
	/**
	 * Sprint 3
	 * Function to display the player's final score after each game.
	 * @throws IOException 
	 */
	public static String results() throws IOException {
		 double score = 0;
	        for(int i= 0; i < userInput.size(); i++) {
	            if (userInput.get(i).contentEquals((MenuSystem.gameArrayList.get(i)))) {
	                score++;
	            }
	          
	        }
	        Leaderboards leader = new Leaderboards();
	        leader.updateLeaderboards((int)score, 4);
	        
	        //Training session
	        ManagingUser currentUser = new ManagingUser();
	        String current = currentUser.getCurrentUser();
	        Score scoreObj = new Score(current,(int)score);
	        ScoreDAO scoreDAO = new ScoreDAO("words");
	        try {
				scoreDAO.save(scoreObj);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        double result = (score / MenuSystem.gameArrayList.size()) * 100;
	        String stringResult = ("You scored: " + result + "%\n");
	        System.out.println(stringResult + "\n");
	        return stringResult;
		
	}
	
		
}

