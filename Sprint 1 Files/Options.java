package me.logan.senpagamemory;

import java.util.Scanner;

public class Options {
    private String[] optionList = new String[3];
    private int option;

    public Options() {
        optionList[0] = "1) Memorize Names";
        optionList[1] = "2) Option 2";
        optionList[2] = "3) Quit";
    }

    public int getOption() {
        return this.option;
    }

    public void print() {
        System.out.println("Welcome to Senpaga Memory\n\nSelect an option to continue\n");
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
