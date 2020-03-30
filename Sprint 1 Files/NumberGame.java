import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;

public class NumberGame {
	private int numberAmt = 0;
	private int numberType = 0;
	private int correctAnswers = 0;
	private ArrayList<String> randomNumbers = new ArrayList<String>();
	private ArrayList<String> answers = new ArrayList<String>();
	
	public NumberGame() {
		
	}
	private void getRandomNumber() {
		Random random = new Random();
		int randNum = 0; 
		for(int i = 0; i < numberAmt; i++) {
			randNum = random.nextInt(numberAmt) + 1;
			switch (numberType) {
			case 1:
				randomNumbers.add(Integer.toString(randNum));
				break;
			case 2:
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
	
	private void getCorrectAnswers() {
		for(int i = 0; i < numberAmt; i++) {
			if(randomNumbers.get(i).equals(answers.get(i)))
				correctAnswers++;
		}
	}
	
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
	
	private void enterAnswers() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter numbers:");
		for(int i = 0; i < numberAmt; i++)
			answers.add(input.next());
	}
	
	private void printResults() {
		double percentCorrect = (double)(correctAnswers/numberAmt) * 100;
		System.out.println("Amount of number memorized: " + numberAmt +
				            "\n" + "Amount correctly answered: " + correctAnswers +
				            "\n" + "Percent correct: " + (int)percentCorrect);
	}
	
	private void clearScreen() {
		for (int i = 0; i < numberAmt; i++) {
	            System.out.println("");
	        }
	}
	
	public void startGame() {
		Scanner input = new Scanner(System.in);
		String memorize = "";
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
		clearScreen();
		enterAnswers();
		System.out.print("Press anything to see results");
		input.nextLine();
		getCorrectAnswers();
		printResults();
		
		
	}
	
}
