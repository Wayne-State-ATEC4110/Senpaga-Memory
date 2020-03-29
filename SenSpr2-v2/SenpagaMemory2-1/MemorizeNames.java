/**
 * @author Logan Jackson
 * Description: MemorizeNames class controls the functionality
 * for everything needed for the name memorization game.
*/

//package me.logan.senpagamemory;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class MemorizeNames {

    private static final String DEFAULT_FILE_PATH = "SenpagaDefaultNames.txt";
    private static final String USER_FILE_PATH = "SenpagaUserNames.txt";

    private ArrayList<String> names = new ArrayList<String>();
    private ArrayList<String> populatedArray = new ArrayList<String>();
    private ArrayList<String> namesGuessed = new ArrayList<String>();


    /**
     * Description: The startGame method controls the setup
     * of the game and runs the remaining methods in the order
     * needed for the game to run properly.
     */
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        int numOfNames;
        int nameType = selectNameType();
        System.out.println("\nHow many names do you want to memorize?\nEnter a number between 1 and 1000");
        System.out.print("Enter option: ");
        numOfNames = UserValidation.checkNumber(scanner, 1, 1000);
        if (nameType == 1) {
            loadNamesFromFile("Default");
        } else if (nameType == 2) {
            loadNamesFromFile("User");
        }
        populateNames(numOfNames);
        printNames();
        ClearScreen.Clear();
        guessNames();
        calculateNumberCorrect();
    }


    /**
     *  Description: The selectNameType method prompts the user to
     *  select what type of names they want to use.
     *  Option 1: Default Names (Pre generated file of names already created)
     *  Option 2: Your Own Names (User defined names written to a file)
     *
     *  @return An integer between 1 and 2
    */
    public int selectNameType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSelect name type");
        System.out.println("1) Use Default Names");
        System.out.println("2) Use Your Own Names");
        System.out.print("Enter option: ");
        return UserValidation.checkNumber(scanner, 1, 2);
    }




    /**
     * Description: The loadNamesFromFile method loads names from either
     * the Default File Path or the User File Path based on what
     * the user selected in the selectNameType method.
     *
     * @param nameType
     */
    public void loadNamesFromFile(String nameType) {
        populatedArray.clear();
        File file = new File(DEFAULT_FILE_PATH);

        if (nameType == "Default") {
            file = new File(DEFAULT_FILE_PATH);
        } else if (nameType == "User") {
            writeToFile();
            file = new File(USER_FILE_PATH);
        }

        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                populatedArray.add(line);
            }
        } catch(FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
    }



    /**
     * Description: Populates array list with random names
     * from another array list containing the entire file
     * of names.
     *
     * @param numberOfNames
     */
    public void populateNames(int numberOfNames) {
        Random rand = new Random();

        for(int i = 0; i < numberOfNames; i++) {
            names.add(populatedArray.get(rand.nextInt(populatedArray.size())));
        }
    }


    /**
     * Description: Writes user defined names to a file
     * until the user types "quit".
    */
    public void writeToFile() {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        FileWriter writeObj;
        PrintWriter printObj;

        System.out.println("Type 'QUIT' when you are done entering names.");
        try {
            while(!name.equalsIgnoreCase("QUIT")) {
                writeObj = new FileWriter(USER_FILE_PATH, true);
                printObj = new PrintWriter(writeObj);


                System.out.print("Enter name: ");
                name = scanner.nextLine();

                if (!name.equalsIgnoreCase("quit")) {
                    printObj.println(name);
                }
                printObj.close();
            }
        } catch(Exception e) {
            System.out.println("Error");
        }

    }


    /**
     * Description: printNames function prints names
     * with a selected amount of names per row defined
     * by the user. Then creates a delay in seconds before
     * the screen will be cleared also defined by the user.
    */
    public void printNames() {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;

        System.out.println("\nHow long do you want to view names (in seconds): ");
        System.out.print("Enter number between 1 and 1000: ");
        int seconds = UserValidation.checkNumber(scanner, 1, 1000);

        System.out.println("How many names do you want per row: ");
        System.out.print("Enter number between 1 and 10: ");
        int numOfNamesPerRow = UserValidation.checkNumber(scanner, 1, 10);

        System.out.println("\nYou have " + seconds + " seconds to remember the following names in order: \n");
        for (int i = 0; i < names.size(); i++) {
            if (counter < numOfNamesPerRow) {
                System.out.print(names.get(i) + " ");
                counter++;
            }
            if (counter == numOfNamesPerRow) {
                System.out.println();
                counter = 0;
            }
        }
        try {
            Thread.sleep(seconds * 1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * Description: Prompts users to enter names and
     * stores them in an Array List.
    */
    public void guessNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nGuess the names previously printed");

        namesGuessed.clear();
        for (int i = 0; i < names.size(); i++) {
            System.out.print((i + 1) + ": ");
            namesGuessed.add(i, scanner.nextLine());
        }
    }

    /**
     * Description: Calculates the number of names guessed
     * correct and prints it to the console.
    */
    public void calculateNumberCorrect() {
        int correct = 0;
        for (int i = 0; i < namesGuessed.size(); i++) {
            if (namesGuessed.get(i).equals(names.get(i))) {
                correct++;
            }
        }

        System.out.println("You got " + correct + " correct out of " + names.size() + "\n");

        // Can return a value if needed for leaderboards in future.
        //return ((correct / names.size()) * 100);
    }


}
