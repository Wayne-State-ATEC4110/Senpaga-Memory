//author: Ervin Colston

//This is the cards class.  This class randomizes the cards, initializes the card packs, and provides a background timer.

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

class Cards{
	//H=Hearts	S=Spades	D=Diamonds	C=Clubs
	String[] cards = {"AH", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "10H", "JH", "QH", "KH",
					  "AS", "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "10S", "JS", "QS", "KS",
				      "AD", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "10D", "JD", "QD", "KD",
				      "AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "10C", "JC", "QC", "KC"};
	int packNumber = 0;
	boolean jokerBool = false;
	int row = 0;
	int column = 0;
	boolean satisfaction = true;
	int cardNumber = cards.length;
	Scanner sc = new Scanner(System.in);
	
	public void randomize() { //works
		List<String> cardList = Arrays.asList(cards);
		Collections.shuffle(cardList);
		cards = cardList.toArray(new String[cardList.size()]);
	}
	
	public void customization() {
		System.out.print("How many card packs do you want to memorize?: ");
		int packNumber = sc.nextInt();
		this.packNumber = packNumber;
		
		System.out.print("Do you want to add Joker cards to your pack? (true/false): ");
		boolean jokerBool = sc.nextBoolean();
		this.jokerBool = jokerBool;
		
		System.out.print("How many cards per column?: ");
		int column = sc.nextInt();
		this.column = column;
		
		System.out.print("Is everything to your satisfaction?(true/false): ");
		boolean satisfaction = sc.nextBoolean();
		this.satisfaction = satisfaction;
		
		System.out.println();
	}
	
	public void end () //ends the session when the user types anything and then "Enter"
	{
		System.out.print("Type in something and Press Enter to Begin Typing Your Answers: ");
		String end;
		end = sc.next();
		System.out.println();
	}
	
	

}
