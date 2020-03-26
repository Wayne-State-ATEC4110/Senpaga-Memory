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


    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        int numOfNames;
        int nameType = selectNameType();
        System.out.println("How many names do you want to memorize?\nEnter a number between 1 and 1000");
        System.out.print("Enter option: ");
        numOfNames = checkNumber(scanner, 1, 1000);
        if (nameType == 1) {
            loadNamesFromFile("Default");
        } else if (nameType == 2) {
            loadNamesFromFile("User");
        }
        populateNames(numOfNames);
        //printNames();
    }

    public int selectNameType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select name type");
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
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
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
