import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Correct {
	
	//files will be used to check correctness
	File userAttempt = new File("userAttempt.txt");
	File systemAttempt = new File("systemAttempt.txt");
	
    
	int correctNumber = 0;
	
	public void input (int packNumber, int cardNumber) throws IOException { //getting the input from the user
		Cards correctCard = new Cards();
		int beginPack = 1;
		Scanner sc = new Scanner(System.in);
		
		FileWriter userWriter = new FileWriter("userAttempt.txt");
		
		
		System.out.println("Input Your Answers\n");
		
		for(int i = 0; i < packNumber ; i++)
		{
			System.out.println("Pack " + beginPack);
			for(int j = 0; j < cardNumber; j++)
			{
				System.out.print("Card " + (j+1) + ": ");
				//constantly add user input to text file
				String input = sc.next();
				userWriter.write(input + " \n"); //works like a charm!
			}
			System.out.println();
			beginPack++;
		}
		userWriter.close();
	}
	
	
	
}
