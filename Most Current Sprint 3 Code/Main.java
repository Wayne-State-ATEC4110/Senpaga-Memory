package me.logan.senpagamemory;

import java.io.IOException;


public class Main {

    @SuppressWarnings("static-access")
    public static void main(String[] args) throws IOException {

        //Logan's Section
        Options opt = new Options();

        while(opt.getOption() != 5) //this is a loop that will keep on going until the quit option is chosen
        {
            opt.print();
            opt.selectOption();

            if(opt.getOption() == 1)
            {
                MemorizeNames nameGame = new MemorizeNames();
                nameGame.startGame();
                /*nameGame.populateArrayWithNames();
                nameGame.printNames();
                nameGame.guessNames();
                nameGame.printNumberCorrect();*/
            }

            if(opt.getOption() == 2)
            {
                Cards user = new Cards();
                UI initial = new UI();
                StopWatch test = new StopWatch();

                test.initialize();

                user.customization();
                for(int i = 0; i < user.packNumber; i++)
                {
                    System.out.println("Pack " + (i+1)); //move this to a class later
                    initial.cardView(user.column);
                    System.out.println();
                }
                user.end();

                test.setTime();

                Correct checker = new Correct();


                checker.input(user.packNumber, user.cardNumber);
                checker.readFromFile();
                checker.compare();
                Scorekeeping scoreObj = new Scorekeeping();

                scoreObj.cardsScore(checker.correctNumber);

                System.out.println("Your entire memorization session was " + test.seconds + " seconds long.");
                System.out.println("You only got " + checker.correctNumber + " correct out of " + (52 * user.packNumber));
                System.out.println("Your overall score is: " + scoreObj.score);
                checker.clear();
            }

            if(opt.getOption() == 3)
            {
                //Christine's Section
                UserInterface ui = new UserInterface();
                ui.optionsMenu();
            }

            if(opt.getOption() == 4)
            {
                NumberGame ng = new NumberGame();
                ng.startGame();
            }

            if (opt.getOption() > 5 || opt.getOption() < 1) {
                System.out.println("\nInvalid Option! Please enter a number between 1 and 5\n");
            }



        }


    }

}
