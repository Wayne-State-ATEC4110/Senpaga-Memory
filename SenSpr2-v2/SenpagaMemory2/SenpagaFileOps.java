//package randomWordGame;

import java.io.*;
import java.util.*;

/**
 * This class handles the Senpaga Word Memorization Files.
 * It encapsulates CRUD operations on the SenpagaUserWords.txt file, as well as declare 
 * the SenpagaDefaultWords.txt and SenpagaForeignWords.txt as constants.
 * 
 * @author Christine
 *
 */
public class SenpagaFileOps {
	
	protected static final String DEFAULT_FILEPATH = "SenpagaDefaultWords.txt";
	
	protected static final String USER_FILEPATH = "SenpagaUserWords.txt";
	
	protected static final String FOREIGN_FILEPATH = "SenpagaForeignWords.txt";
	
	protected static ArrayList<String> arrayOfWords = new ArrayList<String>();
	
	/**
	 * Sprint 1
	 * Creates SenpagaUserWords.txt if not already created and allows users to append words to it.
	 */
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
		
		MenuSystem.wordManagementMenu();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		}
	
	/**
	 * Sprint 2
	 * Deletes words from SenpagaUserWords.txt, one word at a time.
	 */
	public static void deleteWords( ){
		System.out.println("Type a word from the file to delete. ");
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
		String word = br.readLine();
		
			for(int i = 0; i< arrayOfWords.size(); i++) {
				if(arrayOfWords.get(i).equals(word)) {
					arrayOfWords.remove(i);
				
				}
				
			}
				//updating the file so it reflects the new list of words after deletion.
				updateFile(arrayOfWords);
		
				System.out.println("Word Deleted Successfully.");
		
				try {
					Thread.sleep(3000);
			
			
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		
				MenuSystem.wordManagementMenu();
				
			} catch (IOException e) {
			e.printStackTrace();
			}
		
	}
	
	/**
	 * Sprint 2
	 * Updates the SenpagaUserWords.txt to reflect deletion.
	 * @param arrayList arrayOfWords ArrayList passed from deleteWords function.
	 */

	public static void updateFile(ArrayList<String> arrayList) {
		try { 
			BufferedWriter bw2 = new BufferedWriter(new FileWriter(USER_FILEPATH));
		
		for (int x = 0; x < arrayList.size(); x++) {
			bw2.write(arrayOfWords.get(x));
			bw2.newLine();
		}
		bw2.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

	
}
		
	
	


