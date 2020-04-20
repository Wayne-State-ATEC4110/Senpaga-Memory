import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Scanner;
//authors: Ervin, Calvin, Christine, Logan

public class Main {
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		
		Options opt = new Options();
		Leaderboards leader = new Leaderboards();
		ManagingUser currentUser = new ManagingUser();
		
		//creating a database object in order to connect to database
		ManagingUserDB db = new ManagingUserDB();
		db.createDB(); //creates and connects to the database ; displays a message if the database is connected to properly
		
		
		
		while(opt.getOption() != 9) //this is a loop that will keep on going until the quit option is chosen
		{
			
			opt.print();
			opt.selectOption();
			
			if(opt.getOption() == 1)
			{
				 MemorizeNames nameGame = new MemorizeNames();
	             nameGame.startGame();
				
				//scorekeeping added
				Scorekeeping scoreObj = new Scorekeeping();
				scoreObj.namesScore(nameGame.correctness);
				scoreObj.printScore();
				
				leader.updateLeaderboards(scoreObj.score, 2);
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
				
				Correct checker = new Correct();
				
				checker.clear(); //so that the user isn't tempted to go back and check the cards
				
				
				test.setTime();
				
				
				
				checker.input(user.packNumber, user.cardNumber, user.jokerBool);
				checker.readFromFile();
				checker.compare();
				Scorekeeping scoreObj = new Scorekeeping();
				
				scoreObj.cardsScore(checker.correctNumber);
				
				System.out.println("Your entire memorization session was " + test.seconds + " seconds long.");
				int number = 0;
				if(user.jokerBool)
				{
					number = 54;
				}
				else
				{
					number = 52;
				}
				System.out.println("You only got " + checker.correctNumber + " correct out of " + (number * user.packNumber));
				scoreObj.printScore();
				
				leader.updateLeaderboards(scoreObj.score, 3);
				checker.clear();
			}
			
			if(opt.getOption() == 3)
			{
				//Christine's Section
				MenuSystem gameMenu = MenuSystem.getInstance();
				
				System.out.println("\nWelcome to Senpaga Memory: Memorize Words!\n "
						+ "\nSelect a Game Mode from the options below.\n");
				
				gameMenu.fileSelectMenu();
			}
			
			if(opt.getOption() == 4)
			{
				NumberGame ng = new NumberGame();
				ng.startGame();
				
				//scorekeeping added
				Scorekeeping scoreObj = new Scorekeeping();
				scoreObj.numbersScore(ng.correctAnswers);
				scoreObj.printScore();
				leader.updateLeaderboards(scoreObj.score, 5);
			}
			
			if(opt.getOption() == 5) //Managing Multiple Users Option
			{
				ManagingUser select = new ManagingUser();
				select.getUsers();
				select.switchUser();
			}
			
			if(opt.getOption() == 6) //Add User Option
			{
				UserMasterDAO userMasterDAO = new UserMasterDAO();
				Scanner input = new Scanner(System.in);
				System.out.print("Please enter a username: ");
				String user = input.nextLine();
				UserMaster userObj = new UserMaster(user);
				userMasterDAO.add(userObj);	
			}
			
			if(opt.getOption() == 7) //Delete User Option
			{
				UserMasterDAO userMasterDAO = new UserMasterDAO();
				Scanner input = new Scanner(System.in);
				System.out.print("Please enter username to delete: ");
				String user = input.nextLine();
				userMasterDAO.delete(user);
			}
			
			if (opt.getOption() == 8)
            {
                Leaderboards leaderboard = new Leaderboards();
                leaderboard.chooseLeaderboardToView();
                leaderboard.printLeaderboard();
            }
			
			
		}
		

	}

}
