/**
 * @author Logan Jackson & Ervin Colston
 * Description: The Leaderboards class contains the functionality
 * for printing the leaderboards and updating the leaderboards
 */


package me.logan.senpagamemory;

import java.io.File;
import java.io.FileNotFoundException;
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
     */
    public void updateLeaderboards() {

    }
}
