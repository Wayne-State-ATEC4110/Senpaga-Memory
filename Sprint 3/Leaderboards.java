/**
 * @author Logan Jackson & Ervin Colston
 * Description: The Leaderboards class contains the functionality
 * for printing the leaderboards and updating the leaderboards
 */




import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Leaderboards {

    private static final String DEFAULT_LEADERBOARD_PATH = "Leaderboards.txt";
    private static final String NAMES_LEADERBOARD_PATH = "NamesLeaderboards.txt";
    private static final String WORDS_LEADERBOARD_PATH = "WordsLeaderboards.txt";
    private static final String CARDS_LEADERBOARD_PATH = "CardsLeaderboards.txt";
    private static final String NUMBERS_LEADERBOARD_PATH = "NumbersLeaderboards.txt";
    private HashMap<String, Integer> leaderboard = new HashMap<>();


    public void chooseLeaderboardToView() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSelect leaderboard to view");
        System.out.println("1) Overall Leaderboards");
        System.out.println("2) Names Leaderboards");
        System.out.println("3) Cards Leaderboards");
        System.out.println("4) Words Leaderboards");
        System.out.println("5) Numbers Leaderboards");
        System.out.print("Enter option: ");
        loadLeaderboard(UserValidation.checkNumber(scanner, 1, 5));
    }


    /**
     * Description: The loadLeaderboard method is used to
     * load the values of a leaderboard from a file into a
     * hashmap.
     *
     * @param leaderboardType
     */
    public void loadLeaderboard(int leaderboardType) {
        File file = new File(DEFAULT_LEADERBOARD_PATH);
        leaderboard.clear();
        if (leaderboardType == 1) {
            file = new File(DEFAULT_LEADERBOARD_PATH);
        } else if (leaderboardType == 2) {
            file = new File(NAMES_LEADERBOARD_PATH);
        } else if (leaderboardType == 3) {
            file = new File(CARDS_LEADERBOARD_PATH);
        } else if (leaderboardType == 4) {
            file = new File(WORDS_LEADERBOARD_PATH);
        } else if (leaderboardType == 5) {
            file = new File(NUMBERS_LEADERBOARD_PATH);
        }

        try {
            Scanner reader = new Scanner(file);
            int index = 0;
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] splitLine = line.split(" ");
                leaderboard.put(splitLine[0], Integer.parseInt(splitLine[1]));
                index++;
            }
        } catch(FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
    }

    /**
     * Description: The printLeaderboard Method is used
     * to print the leaderboards for any specific category.
     */
    public void printLeaderboard() {
        int index = 1;
        System.out.println("\n      Leaderboards           \n--------------------------");
        for (Map.Entry entry : leaderboard.entrySet()) {
            System.out.println(index + ") " + entry.getKey() + "   -   Score: " + entry.getValue());
            index++;
        }
        System.out.println("");
    }


    /**
     * For Ervin To Complete
     * @throws IOException 
     */
    public void updateLeaderboards(int score, int leaderboardType) throws IOException { //the leaderboardType is for determining 
    	//which file to use
    	File file = new File(DEFAULT_LEADERBOARD_PATH);
        leaderboard.clear();
        if (leaderboardType == 1) {
            file = new File(DEFAULT_LEADERBOARD_PATH);
        } else if (leaderboardType == 2) {
            file = new File(NAMES_LEADERBOARD_PATH);
        } else if (leaderboardType == 3) {
            file = new File(CARDS_LEADERBOARD_PATH);
        } else if (leaderboardType == 4) {
            file = new File(WORDS_LEADERBOARD_PATH);
        } else if (leaderboardType == 5) {
            file = new File(NUMBERS_LEADERBOARD_PATH);
        }
        
        
        
        //update current user score
        
        Scanner reader = new Scanner(file);
        int index = 0;
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] splitLine = line.split(" ");
            leaderboard.put(splitLine[0], Integer.parseInt(splitLine[1]));
            index++;
        }
        
        ManagingUser update = new ManagingUser();
        
        String currentUser = update.getCurrentUser();
        currentUser = currentUser.replaceAll("\\s", ""); //get rid of any potential white space so that the hashmap can work smoothly later
        
        //replace with new score if higher
        int value = leaderboard.get(currentUser); //getting value associated with user
        if(value < score) //if your score is higher than your current leaderboard value
        {
        	leaderboard.replace(currentUser, score);
        	//System.out.println("The new key value is: " + leaderboard.get(currentUser)); //for testing purposes
        }
        
        //write hashmap to file
        BufferedWriter bf = null;
        bf = new BufferedWriter(new FileWriter(file));
        for (Map.Entry entry : leaderboard.entrySet()) {
            bf.write(entry.getKey() + " " + entry.getValue());
            bf.newLine();
        }
        bf.flush();
        bf.close();
        System.out.println("");
        
    }
    
    //Ervin Colston
    public void addMissingUser(String currentUser) throws IOException { //this will notify the user to add the required user to the leaderboards
    	//files
    	
    	
    	currentUser = currentUser.replaceAll("\\s", ""); //get rid of any potential white space so that the hashmap can work smoothly later
    	
    	File file = null;
    	
    	int itr = 1;
    	
    	
    	for(itr = 1; itr <6; itr++) {
    		
    		
    		if (itr == 1) {
                file = new File(DEFAULT_LEADERBOARD_PATH);
            } else if (itr == 2) {
                file = new File(NAMES_LEADERBOARD_PATH);
            } else if (itr == 3) {
                file = new File(CARDS_LEADERBOARD_PATH);
            } else if (itr == 4) {
                file = new File(WORDS_LEADERBOARD_PATH);
            } else if (itr == 5) {
                file = new File(NUMBERS_LEADERBOARD_PATH);
            }
    		
    		leaderboard.clear();
	    	boolean flag = false;
	    	try {
	            Scanner reader = new Scanner(file);
	            int index = 0;
	            while (reader.hasNextLine()) { //putting all of the elements inside of a hash
	                String line = reader.nextLine();
	                String[] splitLine = line.split(" ");
	                leaderboard.put(splitLine[0], Integer.parseInt(splitLine[1]));
	                index++;
	            }
	            
	            
	            for (Map.Entry entry : leaderboard.entrySet()) { //checking to see if user exists in the file
	            	//System.out.println(entry.getKey());
	            	if(currentUser.equals(entry.getKey()))
	            	{
	            		flag = true;
	            	}
	            }
	            
	            if(!flag || leaderboard.isEmpty())
	            {
	            	System.out.println("You need to add your username with no spaces and a score of 0 to the leaderboard files or else"
	            			+ "you won't get a leaderboard score.\n");
	            	break;
	            }
	            
	        } catch(FileNotFoundException e) {
	            System.out.println("File not found!");
	            e.printStackTrace();
	        }
	    	 //itr++;
    	}
    }
    

}
