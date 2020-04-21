import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class us2 {

	@Test
	void test() {
		//fail("Not yet implemented");
		Cards card = new Cards();
		String card1[] = card.cards;
		String card2[] = card.randomize();
		String card3[] = card.jokerCards;
		String card4[] = card.jokerRand();
		
		assertNotEquals(card1, card2); //make sure that both of the cards aren't the same
		assertNotEquals(card3, card4);
		
		System.out.println("Regular cards");
		for(int i = 0; i < 10; i++)
		{
			System.out.print(card1[i] + " ");
		}
		System.out.println("\n");
		
		System.out.println("Randomized Regular cards");
		for(int i = 0; i < 10; i++)
		{
			System.out.print(card2[i] + " ");
		}
		System.out.println("\n");
		
		System.out.println("Joker cards");
		for(int i = 0; i < 10; i++)
		{
			System.out.print(card3[i] + " ");
		}
		System.out.println("\n");
		
		System.out.println("Randomized Joker cards");
		for(int i = 0; i < 10; i++)
		{
			System.out.print(card4[i] + " ");
		}
		System.out.println("\n");
	}

}
