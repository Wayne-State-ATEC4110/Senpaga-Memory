/*
    Author: Logan Jackson
    Description: UserValidation class is a class which contains
    methods to validate user's inputs.
*/

package me.logan.senpagamemory;

import java.util.Scanner;


public class UserValidation {

    /*
        Description: A method to check if user input is between two
        numbers. Used to validate user input throughout the program.
    */
    public static int checkNumber(Scanner userInput, int numberRangeOne, int numberRangeTwo) {
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
