import java.io.IOException;

//this the file from which we will use as a general base for our program.

//classes are in the same package, so they do not need to be imported

public class Main {

	public static void main(String[] args) throws IOException {
		
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
		
		System.out.println(checker.correctNumber);

	}

}
