package me.logan.senpagamemory;

import java.util.Scanner;

public class Options {
    private String[] optionList = new String[5]; //may have to change this
    private int option;

    public Options() {
        optionList[0] = "1) Memorize Names";
        optionList[1] = "2) Memorize Cards";
        optionList[2] = "3) Memorize Words";
        optionList[3] = "4) Memorize Numbers";
        optionList[4] = "5) Quit";
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

        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Invalid Option! Please enter a number between 1 and 5");
            System.out.print("Select an option: ");
        }

        optionSelect = scanner.nextInt();

        this.option = optionSelect;
        return optionSelect;
    }




}