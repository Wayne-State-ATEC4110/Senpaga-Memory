//author: Ervin Colston

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
	List<String> ua = new ArrayList<String>(); //user attempt
	List<String> sa = new ArrayList<String>(); //system attempt
	

	
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
	
	public void readFromFile() throws IOException 
	{
		  BufferedReader uaReader = new BufferedReader(new FileReader("userAttempt.txt"));

		    String line = uaReader.readLine();
		    while (line != null) {
		      this.ua.add(line);
		      line = uaReader.readLine();
		    }
		    uaReader.close(); //close memory leak
		    
		    BufferedReader saReader = new BufferedReader(new FileReader("systemAttempt.txt"));

		    line = saReader.readLine();
		    while (line != null) {
		      this.sa.add(line);
		      line = saReader.readLine();
		    }
		    saReader.close(); //close memory leak
	}
	
	public void compare() //works
	{
		for(int i = 0; i < ua.size();i++)
		{
			//System.out.println(this.ua.get(i)); //delete later
			String check1 = this.ua.get(i);
			String check2 = this.sa.get(i);
			
			if(check1.equals(check2))
			{
				this.correctNumber++;
			}
		}
	}
	
	public void clear() throws FileNotFoundException //clears the different variables and files out for the next potential session
	{
		this.ua.clear();
		this.sa.clear();
		this.correctNumber = 0;
		PrintWriter uaClear = new PrintWriter("userAttempt.txt");
		uaClear.close();
		PrintWriter saClear = new PrintWriter("systemAttempt.txt");
		saClear.close();
		
	}
	
	
}
