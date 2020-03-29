//package randomWordGame;

import java.io.*;
import java.util.*;

public class WordMemorization {
	
	private static final String DEFAULT_FILEPATH = "SenpagaDefaultWords.txt";
	
	private static final String USER_FILEPATH = "SenpagaUserWords.txt";
	
	private static final String FOREIGN_FILEPATH = "SenpagaForeignWords.txt";
	
	private static ArrayList<String> arrayOfWords = new ArrayList<String>();
	
	

	public static void addWords() {
		
		// Instructing the user for proper input.
		System.out.println("Type words you wish to add one line at a time."
				+"\nType QUIT on a new line to quit to the menu.");

		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			
			String inputStr = br.readLine();
			
		/* BufferedWriter wraps FileWriter which will create a new text file with given name
		   if it does not already exist. If it does exist, append inputStr to it, then add a new line.
		   While loop reads inputStr to check if user enters QUIT, if so will break out of the loop,
		   and control will go to the optionsMenu method. */
			
		while(!inputStr.contentEquals("QUIT")) {
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(USER_FILEPATH, true))){
				bw.write(inputStr);
				bw.newLine();
				inputStr = br.readLine();
			}
			
			catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
		// Control goes to Options Menu.
		UserInterface.optionsMenu();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		}
	

	public static void populateArrayList(int startIndex, int limit){
		
		// Making sure the array is clear of input before adding to it.
		arrayOfWords.clear();

		String[] files = {DEFAULT_FILEPATH, USER_FILEPATH, FOREIGN_FILEPATH};
		
		for(int i = startIndex; i < limit; i++) {
		try(Scanner scan1 = new Scanner(new File(files[i]))){
			while(scan1.hasNext()){
				
				arrayOfWords.add(scan1.nextLine());
				
				}
			
				scan1.close();
			}
		
			catch(IOException e){
				
				e.printStackTrace();
				
			}
		}
		System.out.println(arrayOfWords);
	}
	
	//overloaded function 
	public static void populateArrayList(String fileName){
		
		// Making sure the array is clear of input before adding to it.
		arrayOfWords.clear();

		String[] files = {DEFAULT_FILEPATH, FOREIGN_FILEPATH};
		
		for(int i = 0; i < files.length; i++) {
		try(Scanner scan1 = new Scanner(new File(files[i]))){
			while(scan1.hasNext()){
				
				arrayOfWords.add(scan1.nextLine());
				
				}
			
				scan1.close();
			}
		
			catch(IOException e){
				
				e.printStackTrace();
				
			}
		}
		System.out.println(arrayOfWords);
	}
	
	
}
		
	
	


