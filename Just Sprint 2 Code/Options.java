import java.util.Scanner;

public class Options {
    private String[] optionList = new String[8]; //may have to change this
    private int option;

    public Options() {
        optionList[0] = "1) Memorize Names";
        optionList[1] = "2) Memorize Cards";
        optionList[2] = "3) Memorize Words";
        optionList[3] = "4) Memorize Numbers";
        optionList[4] = "5) Choose a User";
        optionList[5] = "6) Add a User";
        optionList[6] = "7) Delete a User";
        optionList[7] = "8) Quit";
    }

    public int getOption() {
        return this.option;
    }

    public void print() {
    	ManagingUser current = new ManagingUser();
    	
        System.out.println("Welcome to Senpaga Memory\n\nSelect an option to continue");
        System.out.print("The current user is: ");
        current.getCurrentUser();
        System.out.println();
        
        
        for (int i = 0; i < optionList.length; i++) {
            System.out.println(optionList[i]);
        }
        System.out.println("");
    }

    public int selectOption() {
        int optionSelect;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select an option: ");
        optionSelect = scanner.nextInt();
        this.option = optionSelect;
        return optionSelect;
    }
    
   


}