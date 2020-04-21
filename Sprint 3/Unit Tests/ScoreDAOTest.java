import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ScoreDAOTest {
	@Before
	void addScore() throws SQLException {
		boolean scoreAdded;
		ScoreDAO scoreDAO = new ScoreDAO("testtable");
		String user = "JUnittestUser";
		Score score = new Score(user,10);
		scoreAdded = scoreDAO.save(score);	
		assertEquals(true, scoreAdded);
	}
	
	@Test
	void testSave() throws SQLException {
		boolean scoreAdded;
		ScoreDAO scoreDAO = new ScoreDAO("testtable");
		String user = "JUnittestUser";
		Score score = new Score(user,11);
		scoreAdded = scoreDAO.save(score);	
		assertEquals(true, scoreAdded);
	}
	
	@Test
	void testGet() throws SQLException{
		List<Score> scoreList = new ArrayList<Score>();
		ScoreDAO scoreDAO = new ScoreDAO("testtable");
		String user = "JUnittestUser";
		scoreList = scoreDAO.getAll(user);
		assertEquals(true, scoreList != null);
		assertEquals(true, !scoreList.isEmpty());
	}

}
