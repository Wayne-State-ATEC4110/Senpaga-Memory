//author: Ervin Colston


public class Scorekeeping {
	
	int score;
	
	void cardsScore(int correct)
	{
		this.score = correct * 5;
	}
	
	void namesScore(int correct)
	{
		this.score = correct * 2;
	}
	
	void numbersScore(int correct)
	{
		this.score = correct * 6;
	}
	
	void wordsScore(int correct)
	{
		this.score = correct * 10;
	}
}
