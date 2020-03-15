//author: Logan Jackson

import java.io.*;
import java.util.*;

public class MemorizeNames {
    private String[] namesInFile;
    private String[] names;
    private String[] enterNames;
    private File file;
    private String nameType;
    
    //I added this variable to make scorekeeping easier
    double correctSend;


    public int getAmountLinesInFile(File file) {
        int numOfLines = 0;
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                numOfLines++;
            }
            reader.close();
        } catch(FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        return numOfLines;
    }

    /*
        Asks what type of names they want to use
        Option 1: Memorize random names from pre-given file
        Option 2: Enter their own names
    */
    public String getNameType() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDo you want to use random names or your own names?");
        System.out.println("1) Random Names\n2) Own Names");
        System.out.print("Select an option: ");
        choice = scanner.nextInt();
        if (choice == 1) {
            return "Random";
        } else if (choice == 2) {
            return "Own";
        } else {
            return "Error";
        }
    }

    public void populateArrayWithNames() {
        int counter = 0;
        String nameType = getNameType();
        
        //commenting this out to get the jar to work, could probably use an if statement here to jury rig
        File file = new File(nameType +  ".txt");
        //File file = new File("Random.txt");
        
        int numOfLines = getAmountLinesInFile(file);
        namesInFile = new String[numOfLines];

        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                namesInFile[counter] = line;
                counter++;
            }
            reader.close();
        } catch(FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        populateArrayWithRandomNames();
        //System.out.println("Your file has " + numOfLines + " names.");

    }

    public void populateArrayWithRandomNames() {
        int numOfNames;
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nHow many names would you like to memorize?");
        System.out.print("Enter a number: ");
        numOfNames = scanner.nextInt();
        names = new String[numOfNames];

        for (int i = 0; i < numOfNames; i++) {
            names[i] = namesInFile[rand.nextInt(namesInFile.length)];
        }

    }

    public void createFile() {
        try {
            File file = new File("customnames.txt");
            if (file.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("File already exits");
            }
        } catch (IOException e) {
            System.out.println("Error occured");
            e.printStackTrace();
        }
    }


    public void printNames() {
        Scanner scanner = new Scanner(System.in);
        int seconds;
        System.out.println("\nHow long do you want to view names (in seconds): ");
        System.out.print("Enter number: ");
        seconds = scanner.nextInt();

        System.out.println("\nYou have " + seconds + " seconds to remember the following names in order: \n");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
        try {
            Thread.sleep(seconds * 1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        clearScreen();
    }


    public void guessNames() {
        Scanner scanner = new Scanner(System.in);
        enterNames = new String[names.length];
        System.out.println("\nGuess the names previously printed");

        for (int i = 0; i < enterNames.length; i++) {
            System.out.print((i + 1) + ": ");
            enterNames[i] = scanner.nextLine();
        }


    }


    public double calculateNumberCorrect() {
        double correct = 0;
        for(int i=0; i < enterNames.length; i++) {
            if (enterNames[i].equals(names[i])) {
                correct++;
            }
        }
        
        this.correctSend = correct;
        return ((correct / names.length) * 100);
    }

    public void printNumberCorrect() {
        System.out.println("\nYou got a " + calculateNumberCorrect() + "%\n");
    }

    public void printGuess() {
        for (int i = 0; i < enterNames.length; i++) {
            System.out.println(enterNames[i]);
        }
    }

    public void clearScreen() {
        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }
    }


}