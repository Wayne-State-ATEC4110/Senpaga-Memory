//author: Ervin Colston


public class Scorekeeping {
	
	int score;
	
	void cardsScore(int correct)
	{
		this.score = correct * 5;
	}
	
	void namesScore(double correct)
	{
		this.score = (int)(correct * 2.0);
	}
	
	void numbersScore(int correct)
	{
		this.score = correct * 6;
	}
	
	void wordsScore(int correct)
	{
		this.score = correct * 10;
	}
	
	void printScore()
	{
		System.out.println("Your overall score is: " + this.score);
	}
}
