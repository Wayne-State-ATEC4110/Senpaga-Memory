import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class UserDAO {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private DBConnection dbConnection = null;
	
	private void createTable() throws SQLException {
		dbConnection = new DBConnection();
		connect = dbConnection.connect_func();
		System.out.println(connect);
		Statement statement = null;
		String sqlstmt = "CREATE TABLE IF NOT EXISTS User " +
                "(userID VARCHAR(20) not NULL, " + " firstName VARCHAR(20), " +
                " lastName VARCHAR(20), " +
                " PRIMARY KEY ( userID ))"; 
		statement = connect.createStatement();
        statement.executeUpdate(sqlstmt);
        statement.close();
        dbConnection.disconnect();
	}
	
	public User getUser(String ID) throws SQLException {
		User user = new User();
		createTable();
		connect = dbConnection.connect_func();
        String sql = "SELECT * FROM User WHERE userID = ?";
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, ID);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
            String userID = resultSet.getString("userID");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
             
            user = new User(userID, firstName, lastName);
        }
        
        resultSet.close();
        preparedStatement.close();
        dbConnection.disconnect();
         
        return user;
    }

}
