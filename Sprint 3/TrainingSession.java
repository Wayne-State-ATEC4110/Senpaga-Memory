import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainingSession {
	public void showTrainingSession(String user) throws SQLException {
		int max;
		List<Score> cardScore = new ArrayList<Score>();
		List<Score> wordScore = new ArrayList<Score>();
		List<Score> nameScore = new ArrayList<Score>();
		List<Score> numberScore = new ArrayList<Score>();
		
		ScoreDAO cardScoreDAO = new ScoreDAO("cards");
		ScoreDAO wordScoreDAO = new ScoreDAO("words");
		ScoreDAO nameScoreDAO = new ScoreDAO("names");
		ScoreDAO numberScoreDAO = new ScoreDAO("numbers");
		
		cardScore = cardScoreDAO.getAll(user);
		wordScore = wordScoreDAO.getAll(user);
		nameScore = nameScoreDAO.getAll(user);
		numberScore = numberScoreDAO.getAll(user);
		
		int [] maxArray = new int[4];
		maxArray[0] = cardScore.size();
		maxArray[1] = wordScore.size();
		maxArray[2] = nameScore.size();
		maxArray[3] = numberScore.size();
		max = maxArray[0];
		for(int i = 1; i < maxArray.length; i++)
			if(max < maxArray[i])
				max = maxArray[i];
		System.out.println("Cards" + "\t" + "Words" + "\t" + "Names" + "\t" + "Numbers");
		System.out.println("-----" + "\t" + "-----" + "\t" + "-----" + "\t" + "-------");
		for(int i = 0; i < max; i++) {
			String cardScoreStr = "";
			String wordScoreStr = "";
			String nameScoreStr = "";
			String numberScoreStr = "";
			if ((cardScore != null) && !cardScore.isEmpty()) {
				if(cardScore.size() <= max)
					cardScoreStr = Integer.toString(cardScore.get(i).getScore());
				else
					cardScoreStr = "-";
			}
			else
				cardScoreStr = "-";
			
			if ((wordScore != null) && !wordScore.isEmpty()) {
				if(wordScore.size() <= max)
					wordScoreStr = Integer.toString(wordScore.get(i).getScore());
				else
					wordScoreStr = "-";
			}
			else
				wordScoreStr = "-";
			
			if ((nameScore != null) && !nameScore.isEmpty()) {
				if(nameScore.size() <= max)
					nameScoreStr = Integer.toString(nameScore.get(i).getScore());
				else
					nameScoreStr = "-";
			}
			else
				nameScoreStr = "-";
			
			if ((numberScore != null) && !numberScore.isEmpty()) {
				if(numberScore.size() <= max) {
					numberScoreStr = Integer.toString(numberScore.get(i).getScore());}
				else
					numberScoreStr = "-";
			}
			else
				numberScoreStr = "-";
			
			System.out.println(cardScoreStr + "\t" + wordScoreStr + "\t" + nameScoreStr + "\t" 
			+ numberScoreStr);
				
				
		}
	}
}
