import java.io.IOException;
import java.net.URL;


public class Main {
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//Logan's Section
		Options opt = new Options();
		MemorizeNames nameGame = new MemorizeNames();
		
		ManagingUserDB db = new ManagingUserDB();
		db.createDB(); //creates and connects to the database
		
		
		
		while(opt.getOption() != 5) //this is a loop that will keep on going until the quit option is chosen
		{
			opt.print();
			opt.selectOption();
			
			if(opt.getOption() == 1)
			{
				nameGame.populateArrayWithNames();
				nameGame.printNames();
				nameGame.guessNames();
				nameGame.printNumberCorrect();
			}
			
			if(opt.getOption() == 2)
			{
				Cards user = new Cards();
				UI initial = new UI();
				StopWatch test = new StopWatch();
				
				
				
				user.customization();
				
				test.initialize(); //initializes the stopwatch
				for(int i = 0; i < user.packNumber; i++)
				{
					System.out.println("Pack " + (i+1)); //move this to a class later
					initial.cardView(user.column, user.jokerBool);
					System.out.println();
				}
				user.end();
				
				nameGame.clearScreen(); //so that the user isn't tempted to go back and check the cards
				
				
				test.setTime();
				
				Correct checker = new Correct();
				
				
				checker.input(user.packNumber, user.cardNumber);
				checker.readFromFile();
				checker.compare();
				Scorekeeping scoreObj = new Scorekeeping();
				
				scoreObj.cardsScore(checker.correctNumber);
				
				System.out.println("Your entire memorization session was " + test.seconds + " seconds long.");
				System.out.println("You only got " + checker.correctNumber + " correct out of " + (52 * user.packNumber));
				System.out.println("Your overall score is: " + scoreObj.score);
				checker.clear();
			}
			
			if(opt.getOption() == 3)
			{
				//Christine's Section
				UserInterface ui = new UserInterface();
				ui.optionsMenu();
			}
			
			if(opt.getOption() == 4)
			{
				NumberGame ng = new NumberGame();
				ng.startGame();
			}
			
			
			
		}
		

	}

}
