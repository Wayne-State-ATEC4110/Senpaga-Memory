/**
 * @author Calvin Brooks
 * Description: Class for storing score data from DB
 * 
*/
import java.sql.Date;

public class Score {
	private String userID;
	private int score;
	private java.sql.Date date;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userId) {
		this.userID = userId;
	}
	public Score(String userId, int score) {
		super();
		this.userID = userId;
		this.score = score;
	}
	
	public Score(String userID, int score, Date date) {
		super();
		this.userID = userID;
		this.score = score;
		this.date = date;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public java.sql.Date getDate() {
		return date;
	}
}
