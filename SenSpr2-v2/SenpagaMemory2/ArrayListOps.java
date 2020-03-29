//package randomWordGame;

import java.io.*;
import java.util.*;

/**
 * This class handles ArrayList Operations, populating the arrayOfWords with user-chosen files,
 * as well as shuffling, sublisting, and displaying the arrayOfWords.
 * @author Christine
 *
 */
public class ArrayListOps extends SenpagaFileOps {
	
	
	/**
	 * Sprint 1
	 * Populates arrayOfWords with files next to each other in the files array.
	 * @param startIndex indicates the first file floor (first file).
	 * @param limit indicates the file ceiling (last file).
	 */
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
		
		//System.out.println(arrayOfWords);
	}
	
	/**
	 * Sprint 1
	 * Overloaded function to handle case of user choosing both Default and Foreign text files.
	 * @param fileName "Default and Foreign" in fileSelectMenu switch case.
	 */
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
		
		//System.out.println(arrayOfWords);
		
	}
	
	/**
	 * Sprint 2
	 * Shuffles arrayOfWords.
	 */
	public static void randomizeWords() {
		Collections.shuffle(arrayOfWords);
		//System.out.println("Randomized Words: \n" + arrayOfWords);
	}

	/**
	 * Sprint 2
	 * Selects a portion of arrayOfWords to be used as difficulty settings.
	 * @param sublist word count.
	 * @return new ArrayList.
	 */
	public static ArrayList<String> sublistOfWords(int sublist) {
		randomizeWords();
		ArrayList<String> theSublist = new ArrayList<String>(arrayOfWords.subList(0, sublist));
		//System.out.println("ArrayList of " + theSublist.size() +" words: " + theSublist);
		//theSublist.size();
		
		return theSublist;
	}
	
	/**
	 * Sprint 1/2
	 * Displays words from the passed ArrayList.
	 * @param theSublist passed from sublistOfWords function.
	 */
	public static void displayWords(ArrayList<String> theSublist) {
		int count = 1;
		for (int i = 0; i < theSublist.size(); i++) {
			System.out.println(count + ". " + theSublist.get(i));
			count++;
		}
		theSublist.size();
		
	}
	
}
