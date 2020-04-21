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
	String[] jokerCards = {"AH", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "10H", "JH", "QH", "KH",
			  "AS", "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "10S", "JS", "QS", "KS",
		      "AD", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "10D", "JD", "QD", "KD",
		      "AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "10C", "JC", "QC", "KC",
		      "Joker", "Joker"};
	int packNumber = 0;
	boolean jokerBool = false; //boolean used to determine if the user wants to use joker cards or not ; set to false by default
	int row = 0;
	int column = 0;
	boolean satisfaction = true; //boolean used to determine if the user is satisfied with their customization options ; set to true by
	//default ; if false is chosen, the user will have to re-enter their options again
	int cardNumber = cards.length;
	Scanner sc = new Scanner(System.in);
	
	public void randomize() { //works
		List<String> cardList = Arrays.asList(this.cards);
		Collections.shuffle(cardList);
		this.cards = cardList.toArray(new String[cardList.size()]);
	}
	
	public void jokerRand() { //randomizes the joker cards instead of the regular cards
		List<String> cardList = Arrays.asList(this.jokerCards);
		Collections.shuffle(cardList);
		this.jokerCards = cardList.toArray(new String[cardList.size()]);
	}
	
	
	public void customization() { //in order to implement validation checking, this whole method is a series of nested do-while loops
		
		do {
		
			do {
				System.out.println("How many card packs do you want to memorize?");
				System.out.print("Input must be between 1-10: ");
				int packNumber; 
				
				//The validation code is here so that the user doesn't break the program. 0 can't be there for obvious reasons
				//while I set the pack limit to 10 to avoid some memory concerns
				
				
				
				while(!sc.hasNextInt()) //this is here to make sure that the user actually enters a number
				{
					System.out.print("Enter a Number!: ");
					sc.next();
				}
				
				packNumber = sc.nextInt();
				
				if(packNumber < 1)
					{ System.out.println("Error! Too Low!"); }
				if(packNumber > 10)
					{ System.out.println("Error! Too High!"); }
					
				
				this.packNumber = packNumber;
			}
			while (this.packNumber < 1 || this.packNumber > 10); //if the parameters are not up to par, the user will have to enter this
			//information again
			
			
			System.out.print("Do you want to add Joker cards to your pack? (true/false): ");
			boolean jokerBool;
			while(!sc.hasNextBoolean()) //receiving input now
			{
				System.out.print("That's not a boolean! (true/false): " );
				sc.next();
			}
			jokerBool = sc.nextBoolean();
			this.jokerBool = jokerBool;
			
			int upper = 52; //represents how many cards per column you can have
			
			do {
				System.out.println("How many cards per column? ");
				
				if(this.jokerBool) //special option for those who want to use joker cards
				{
					System.out.print("Input must be between 1-54: ");
					upper = 54;
				}
				else
			    	{System.out.print("Input must be between 1-52: ");}
				int column;
				
				while(!sc.hasNextInt())
				{
					System.out.print("Enter a Number!: ");
					sc.next();
				}
				
				column = sc.nextInt();
				
				if(column < 1)
				{
					System.out.println("Error! Too Low!");
				}
				if(column > upper)
				{
					System.out.println("Error! Too High!");
				}
					
				
				this.column = column;
			}
			while (this.column < 1 || this.column > upper);
			
			
			
			System.out.print("Is everything to your satisfaction?(true/false): ");
			boolean satisfaction;
			while(!sc.hasNextBoolean())
			{
				System.out.print("That's not a boolean! (true/false): ");
				sc.next();
			}
			satisfaction = sc.nextBoolean();
			this.satisfaction = satisfaction;
			
			if(!this.satisfaction)
			{
				System.out.println();
				System.out.println("Ok, re-enter your choices again \n \n");
			}
		
		}while(!this.satisfaction);
		
		
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
