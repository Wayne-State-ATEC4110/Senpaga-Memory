/**
 * @author Calvin Brooks
 * Description: This class is meant for accessing the user DB
 * 
*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class UserMasterDAO implements UserDAO<UserMaster> {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private DBConnection dbConnection = null;
	
	/**
     * Description: method to create user table
     *
    */
	@Override
	public void createTable() throws SQLException {
		dbConnection = new DBConnection();
		connect = dbConnection.connect_func();
		System.out.println(connect);
		Statement statement = null;
		String sqlstmt = "CREATE TABLE IF NOT EXISTS User " +
                "(userID VARCHAR(20) not NULL, " + " firstName VARCHAR(20), " +
                " lastName VARCHAR(20), " +
                " PRIMARY KEY ( userID ))"; 
        statement.executeUpdate(sqlstmt);
        statement.close();
        dbConnection.disconnect();
	}
	
	/**
     * Description: method to get user info from user table
     *
     *@return userMaster
    */
	@Override
	public UserMaster get(String ID) throws SQLException {
		UserMaster userMaster = new UserMaster();
		createTable();
		dbConnection = new DBConnection();
		connect = dbConnection.connect_func();
        String sql = "SELECT * FROM User WHERE userID = ?";
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, ID);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
            String userID = resultSet.getString("userID");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
             
            userMaster = new UserMaster(userID, firstName, lastName);
        }
        
        resultSet.close();
        preparedStatement.close();
        dbConnection.disconnect();
         
        return userMaster;
    }
	
	/**
     * Description: method to add user info to user table
     *
    */
	@Override
	public void add(UserMaster userMaster) throws SQLException {
		createTable();
		dbConnection = new DBConnection();
		connect = dbConnection.connect_func(); 
		String sql = "insert into  UserMaster(userID, firstName, lastName) values (?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, userMaster.getUserID());
		preparedStatement.setString(2, userMaster.getFirstName());
		preparedStatement.setString(3, userMaster.getLastName());
		
		preparedStatement.executeUpdate();
        preparedStatement.close();
        dbConnection.disconnect();
    }
	
	/**
     * Description: method to update user info to user table
     *
    */
	@Override
	public void update(UserMaster userMaster) throws SQLException {
		createTable();
		dbConnection = new DBConnection();
		connect = dbConnection.connect_func();
		String sql = "update usermaster set userType = ?, firstName = ?, lastName = ? where userID = ?";
       
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, userMaster.getUserID());
        preparedStatement.setString(1, userMaster.getFirstName());
        preparedStatement.setString(1, userMaster.getLastName());
         
        preparedStatement.executeUpdate();
        preparedStatement.close();
        dbConnection.disconnect();
    }
	
	/**
     * Description: method to delete user from user table
     *
    */
	@Override
	public void delete(String userID) throws SQLException {
		createTable();
		dbConnection = new DBConnection();
		connect = dbConnection.connect_func();
        String sql = "DELETE FROM usermaster WHERE userID = ?";        
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, userID);
         
        preparedStatement.executeUpdate();
        preparedStatement.close(); 
        dbConnection.disconnect();
    }
	
	/**
     * Description: method to get list of all users from user table
     *
     *@return userList
    */
	@Override
	public List<UserMaster> getAll() throws SQLException {
        List<UserMaster> userList = new ArrayList<UserMaster>();
        createTable();
		dbConnection = new DBConnection();
		connect = dbConnection.connect_func();
        String sql = "SELECT * FROM usermaster";           
        statement =  (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	String userID = resultSet.getString("userID");
        	String firstName = resultSet.getString("firstName");
        	String lastName = resultSet.getString("lastName");
             
            UserMaster userMaster = new UserMaster(userID, firstName, lastName);
            userList.add(userMaster);
            
        }        
        resultSet.close();
        statement.close();         
        dbConnection.disconnect();   
        return userList;
    }

}
