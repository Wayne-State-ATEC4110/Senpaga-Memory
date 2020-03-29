/**
 * @author Logan Jackson
 * Description: Options class is used to create
 * an options menu for users to navigate through the program.
*/

package me.logan.senpagamemory;

import java.util.Scanner;

public class Options {
    private String[] optionList = new String[5]; //may have to change this
    private int option;


    /**
     * Description: Options constructor initializes the Options
     * object and defines the option items.
    */
    public Options() {
        optionList[0] = "1) Memorize Names";
        optionList[1] = "2) Memorize Cards";
        optionList[2] = "3) Memorize Words";
        optionList[3] = "4) Memorize Numbers";
        optionList[4] = "5) Quit";
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
    */
    public void print() {
        System.out.println("Welcome to Senpaga Memory\n\nSelect an option to continue\n");
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
        optionSelect = UserValidation.checkNumber(scanner, 1, 5);
        this.option = optionSelect;
        return optionSelect;
    }


}