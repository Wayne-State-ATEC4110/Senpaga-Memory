/**
 * @author Logan Jackson
 * Description: Options class is used to create
 * an options menu for users to navigate through the program.
*/



import java.io.IOException;
import java.util.Scanner;

public class Options {
    private String[] optionList = new String[11]; //may have to change this
    public int option;


    /**
     * Description: Options constructor initializes the Options
     * object and defines the option items.
    */
    public Options() {
    	optionList[0] = "1) Memorize Names";
        optionList[1] = "2) Memorize Cards";
        optionList[2] = "3) Memorize Words";
        optionList[3] = "4) Memorize Numbers";
        optionList[4] = "5) Choose a User";
        optionList[5] = "6) Add a User";
        optionList[6] = "7) Delete a User";
        optionList[7] = "8) View Leaderboards";
        optionList[8] = "9) View Your Training Session";
        optionList[9] = "10) View Other User's Training Session";
        optionList[10] = "11) Quit";
    }

    /**
     * Description: method to get the option
     * selected.
     *
     * @return this.option
    */
    public int getOption() {
        return this.option;
    }

    /**
     * Description: Prints a welcome message and
     * a list of options for the user to select
     * from.
     * @throws IOException 
    */
    public void print() throws IOException {
    	ManagingUser current = new ManagingUser();
    	
        System.out.println("Welcome to Senpaga Memory\n\nSelect an option to continue");
        String currentUser = current.getCurrentUser();
        System.out.print("The current user is: " + currentUser);
        System.out.println();
        
        
        for (int i = 0; i < optionList.length; i++) {
            System.out.println(optionList[i]);
        }
        System.out.println("");
    }

    /**
     * Description: Prompts the user to select an
     * option from the options menu.
     *
     * @return optionSelect
    */
    public int selectOption() {
        int optionSelect;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select an option: ");
        optionSelect = UserValidation.checkNumber(scanner, 1, 11);
        this.option = optionSelect;
        return optionSelect;
    }


}