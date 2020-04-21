/**
 * @author Calvin Brooks
 * Description: This class is meant for accessing the various scores databases
 * 
*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ScoreDAO implements IScoreDAO<Score> {
	private String table;
	public String getTable() {
		return table;
	}
	
	
	
	public ScoreDAO(String table) {
		super();
		this.table = table;
	}



	public void setTable(String table) {
		this.table = table;
	}

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private DBConnection dbConnection = null;
	
	/**
     * Description: method to create score table
     *
    */
	@Override
	public void createTable() throws SQLException {
		dbConnection = new DBConnection();
		connect = dbConnection.connect_func();
		System.out.println(connect);
		Statement statement = null;
		String sqlstmt = "CREATE TABLE IF NOT EXISTS "+ table +
                " (userID VARCHAR(20) not NULL, " + " score INTEGER, " +
                " date DATE)"; 
		statement = connect.createStatement();
        statement.executeUpdate(sqlstmt);
        statement.close();
        dbConnection.disconnect();
	}
	
	/**
     * Description: method to save score to score table
     *
    */
	@Override
	public void save(Score score) throws SQLException {
		createTable();
		long time = System.currentTimeMillis();
    	java.sql.Date date = new java.sql.Date(time);
		dbConnection = new DBConnection();
		connect = dbConnection.connect_func(); 
		String sql = "insert into " + table +"(userID, score, date) values (?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, score.getUserID());
		preparedStatement.setInt(2, score.getScore());
		preparedStatement.setDate(3, date);
		
		preparedStatement.executeUpdate();
        preparedStatement.close();
        dbConnection.disconnect();
    }
	
	/**
     * Description: method to get all scores from score table
     *
     *@return scoreList
    */
	@Override
	public List<Score> getAll() throws SQLException {
        List<Score> scoreList = new ArrayList<Score>();
        createTable();
        java.sql.Date date = new java.sql.Date(0);
		dbConnection = new DBConnection();
		connect = dbConnection.connect_func();
        String sql = "SELECT * FROM "+ table;           
        statement =  (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	String userID = resultSet.getString("userID");
        	int score = resultSet.getInt("score");
        	date = resultSet.getDate("date");
             
            Score scoreObj = new Score(userID, score, date);
            scoreList.add(scoreObj);
            
        }        
        resultSet.close();
        statement.close();         
        dbConnection.disconnect();   
        return scoreList;
    }
	
	/**
     * Description: method to get all scores of a specific user from score table
     *
     *@return scoreList
    */
	@Override
	public List<Score> getAll(String userID) throws SQLException {
        List<Score> scoreList = new ArrayList<Score>();
        createTable();
        java.sql.Date date = new java.sql.Date(0);
		dbConnection = new DBConnection();
		connect = dbConnection.connect_func();
        String sql = "SELECT * FROM " + table + " WHERE userID = ?";           
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, userID);
        ResultSet resultSet = preparedStatement.executeQuery();
         
        while (resultSet.next()) {
        	//String user = resultSet.getString("userID");
        	int score = resultSet.getInt("score");
        	date = resultSet.getDate("date");
            Score scoreObj = new Score(userID, score, date);
            scoreList.add(scoreObj);
            
        }        
        resultSet.close();
        preparedStatement.close();         
        dbConnection.disconnect();   
        return scoreList;
    }
}
