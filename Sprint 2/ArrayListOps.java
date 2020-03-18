package randomWordGame;

import java.io.*;
import java.util.*;

public class ArrayListOps extends SenpagaFileOps {
	
	
	
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
	
	
	public static void randomizeWords() {
		Collections.shuffle(arrayOfWords);
		//System.out.println("Randomized Words: \n" + arrayOfWords);
	}

	public static ArrayList<String> sublistOfWords(int sublist) {
		randomizeWords();
		ArrayList<String> theSublist = new ArrayList<String>(arrayOfWords.subList(0, sublist));
		//System.out.println("ArrayList of " + theSublist.size() +" words: " + theSublist);
		//theSublist.size();
		
		return theSublist;
	}
	
	public static void displayWords(ArrayList<String> theSublist) {
		int count = 1;
		for (int i = 0; i < theSublist.size(); i++) {
			System.out.println(count + ". " + theSublist.get(i));
			count++;
		}
		theSublist.size();
		
	}
	
}
