/**
 * @author Calvin Brooks
 * Description: Class for Number Game
 * 
*/
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;

public class NumberGame {
	private int numberAmt = 0;
	private int numberType = 0;
	public int correctAnswers = 0;
	private ArrayList<String> randomNumbers = new ArrayList<String>();
	private ArrayList<String> answers = new ArrayList<String>();
	
	public NumberGame() {
		
	}
	
	/**
	 * Description: method for getting random numbers for game
	 * 
	*/
	private void getRandomNumber() {
		Random random = new Random();
		int randomCount = 255;
		int randNum = 0; 
		for(int i = 0; i < numberAmt; i++) {
			randNum = random.nextInt(randomCount);
			switch (numberType) {
			case 1:
				randomNumbers.add(Integer.toString(randNum));
				break;
			case 2:
				if(randNum > 15)
					randomNumbers.add(String.format("%8s", Integer.toBinaryString(randNum)).replace(" ", "0"));
				else
					randomNumbers.add(String.format("%4s", Integer.toBinaryString(randNum)).replace(" ", "0"));
				break;
			case 3:
				randomNumbers.add(Integer.toHexString(randNum));
				break;
			default:
				break;
			}
		}
	}
	
	/**
	 * Description: method to get correct answers game
	 * 
	*/
	private void getCorrectAnswers() {
		for(int i = 0; i < numberAmt; i++) {
			if(randomNumbers.get(i).equals(answers.get(i)))
				correctAnswers++;
		}
	}
	
	/**
	 * Description: prints out the random numbers
	 * 
	*/
	private void printRandomNumbers() {
		double convAmt = (double)numberAmt/5;
		int amtCeiling = (int)Math.ceil(convAmt);
		int index = 0;
		
		for(int i = 0; i < amtCeiling; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print("\t" + randomNumbers.get(index));
				index++;
			}
			System.out.println();
		}
	}
	
	/**
	 * Description: method for entering numbers after memorizng
	 * 
	*/
	private void enterAnswers() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter numbers:");
		for(int i = 0; i < numberAmt; i++)
			answers.add(input.next());
	}
	
	/**
	 * Description: method for printing the results of guessed answers
	 * 
	*/
	private void printResults() {
		double percentCorrect = (double)(correctAnswers/numberAmt) * 100;
		System.out.println("Amount of number memorized: " + numberAmt +
				            "\n" + "Amount correctly answered: " + correctAnswers +
				            "\n" + "Percent correct: " + (int)percentCorrect);
	}
	
	/**
	 * Description: method for starting the number game
	 * 
	*/
	public void startGame() {
		Scanner input = new Scanner(System.in);
		String memorize = "";
		ClearScreen Clr = new ClearScreen();
		boolean isNumberType = false;
		System.out.println("1. Decimal" + 
						 "\n" + "2. Binary" +
						 "\n" + "3. Hexadecimal");
		while(numberType < 1 || numberType > 3) {
		System.out.println("Enter number type: ");
		numberType = input.nextInt();
		if(numberType < 1 || numberType > 3)
			System.out.println("Incorrect number type");
		}
		while(numberAmt < 5) {
		System.out.println("Enter amount of numbers to memorize (5 or more): ");
		numberAmt = input.nextInt();
		if(numberAmt < 5)
			System.out.println("Amount to memorize must be 5 or more");
		}
		getRandomNumber();
		printRandomNumbers();
		System.out.print("Press anything to start memorizing");
		input.nextLine();
		input.nextLine();
		ClearScreen.Clear();
		enterAnswers();
		System.out.print("Press anything to see results");
		input.nextLine();
		ClearScreen.Clear();
		getCorrectAnswers();
		printResults();
		
		
	}
	
}
