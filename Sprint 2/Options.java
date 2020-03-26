package me.logan.senpagamemory;

import java.util.Scanner;

public class Options {
    private String[] optionList = new String[5]; //may have to change this
    private int option;

    public Options() {
        optionList[0] = "1) Memorize Names";
        optionList[1] = "2) Memorize Cards";
        optionList[2] = "3) Memorize Words";
        optionList[3] = "4) Memorize Numbers";
        optionList[4] = "5) Quit";
    }

    public int getOption() {
        return this.option;
    }

    public void print() {
        System.out.println("Welcome to Senpaga Memory\n\nSelect an option to continue\n");
        for (int i = 0; i < optionList.length; i++) {
            System.out.println(optionList[i]);
        }
        System.out.println("");
    }

    public int selectOption() {
        int optionSelect;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select an option: ");

        /*while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Invalid Option! Please enter a number between 1 and 5");
            System.out.print("Select an option: ");
        }*/

        optionSelect = checkNumber(scanner, 1, 5);

        //optionSelect = scanner.nextInt();
        this.option = optionSelect;
        return optionSelect;
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