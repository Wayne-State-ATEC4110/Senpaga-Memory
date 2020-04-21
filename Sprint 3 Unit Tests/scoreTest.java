
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class scoreTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		Scorekeeping score = new Scorekeeping();
		
		//zero, negative, positive
		
		score.cardsScore(0);
		assertEquals(0, score.score);
		score.cardsScore(-1);
		assertEquals(-5, score.score);
		score.cardsScore(1);
		assertEquals(5, score.score);
		
		score.namesScore(0);
		assertEquals(0, score.score);
		score.namesScore(-1);
		assertEquals(-2, score.score);
		score.namesScore(1);
		assertEquals(2, score.score);
		
		score.numbersScore(0);
		assertEquals(0, score.score);
		score.numbersScore(-1);
		assertEquals(-6, score.score);
		score.numbersScore(1);
		assertEquals(6, score.score);
		
		score.wordsScore(0);
		assertEquals(0, score.score);
		score.wordsScore(-1);
		assertEquals(-10, score.score);
		score.wordsScore(1);
		assertEquals(10, score.score);
	}

}
