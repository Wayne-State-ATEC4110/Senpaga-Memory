package me.logan.senpagamemory;

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


    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        int numOfNames;
        int nameType = selectNameType();
        System.out.println("\nHow many names do you want to memorize?\nEnter a number between 1 and 1000");
        System.out.print("Enter option: ");
        numOfNames = checkNumber(scanner, 1, 1000);
        if (nameType == 1) {
            loadNamesFromFile("Default");
        } else if (nameType == 2) {
            loadNamesFromFile("User");
        }
        populateNames(numOfNames);
        printNames();
        clearScreen();
        guessNames();
        calculateNumberCorrect();
    }

    public int selectNameType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSelect name type");
        System.out.println("1) Use Default Names");
        System.out.println("2) Use Your Own Names");
        System.out.print("Enter option: ");
        return checkNumber(scanner, 1, 2);
    }



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

    public void populateNames(int numberOfNames) {
        Random rand = new Random();

        for(int i = 0; i < numberOfNames; i++) {
            names.add(populatedArray.get(rand.nextInt(populatedArray.size())));
        }
    }


    public void writeToFile() {

        Scanner scanner = new Scanner(System.in);
        String name = "";
        FileWriter writeObj;
        PrintWriter printObj;

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


    public void printNames() {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;

        System.out.println("\nHow long do you want to view names (in seconds): ");
        System.out.print("Enter number between 1 and 1000: ");
        int seconds = checkNumber(scanner, 1, 1000);

        System.out.println("How many names do you want per row: ");
        System.out.print("Enter number between 1 and 10: ");
        int numOfNamesPerRow = checkNumber(scanner, 1, 10);

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

    public void guessNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nGuess the names previously printed");

        namesGuessed.clear();
        for (int i = 0; i < names.size(); i++) {
            System.out.print((i + 1) + ": ");
            namesGuessed.add(i, scanner.nextLine());
        }
    }

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

    public void clearScreen() {
        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }
    }

    // Function - To check if the user has inputted a number between two numbers.
    public int checkNumber(Scanner userInput, int numberRangeOne, int numberRangeTwo) {
        for (; ; ) {
            if (!userInput.hasNextInt()) {
                System.out.print("Please enter a number: ");
            } else {
                int number = userInput.nextInt();
                if ((number >= numberRangeOne) && number <= numberRangeTwo) return number;
                System.out.print("Your number must be between " + numberRangeOne + " and " + numberRangeTwo + ": ");
            }
            userInput.nextLine(); // discard line of input.

        }
    }
}
