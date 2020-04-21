import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.Test;

public class uiTest {

	@Test
	public void test() throws IOException {
		//fail("Not yet implemented");
		Cards user = new Cards();
		user.column = 52;
		user.jokerBool = true;
		UI ui = new UI();
		ui.cardView(user.column , user.jokerBool);
		assertEquals(54, ui.testLength);
	}

}
