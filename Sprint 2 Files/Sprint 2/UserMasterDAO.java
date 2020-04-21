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
	//private DBConnection dbConnection = null;
	private ManagingUserDB muConnection = null;
	
	/**
     * Description: method to create user table
     *
    */
	@Override
	public void createTable() throws SQLException {
		//dbConnection = new DBConnection();
	//	connect = dbConnection.connect_func();
		System.out.println(connect);
		Statement statement = null;
		String sqlstmt = "CREATE TABLE IF NOT EXISTS User " +
                "(userID VARCHAR(20) not NULL, " + " firstName VARCHAR(20), " +
                " lastName VARCHAR(20), " +
                " PRIMARY KEY ( userID ))"; 
        statement.executeUpdate(sqlstmt);
        statement.close();
	}
	
	/**
     * Description: method to get user info from user table
     *
     *@return userMaster
    */
	@Override
	public UserMaster get(String ID) throws SQLException {
		UserMaster userMaster = new UserMaster();
        String sql = "SELECT * FROM Users WHERE UserNames = ?";
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, ID);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
            String userID = resultSet.getString("userID");
        }
        
        resultSet.close();
        preparedStatement.close();
         
        return userMaster;
    }
	
	/**
     * Description: method to add user info to user table
     *
    */
	@Override
	public void add(UserMaster userMaster) throws SQLException {
		muConnection = new ManagingUserDB();
		connect = muConnection.connect();
		String sql = "insert into  Users(UserNames) values (?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, userMaster.getUserNames());
		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
	
	/**
     * Description: method to update user info to user table
     *
    */
	@Override
	public void update(UserMaster userMaster) throws SQLException {
		connect = muConnection.connect();
		String sql = "update Users set UserNames = ? where UserNames = ?";
       
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, userMaster.getUserNames());
        preparedStatement.setString(2, userMaster.getUserNames());
        
        preparedStatement.executeUpdate();
        preparedStatement.close();
    //    dbConnection.disconnect();
    }
	
	/**
     * Description: method to delete user from user table
     *
    */
	@Override
	public void delete(String UserNames) throws SQLException {
		muConnection = new ManagingUserDB();
		connect = muConnection.connect();
        String sql = "DELETE FROM Users WHERE UserNames = ?";        
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, UserNames);
         
        preparedStatement.executeUpdate();
        preparedStatement.close(); 
    }
	
	/**
     * Description: method to get list of all users from user table
     *
     *@return userList
    */
	@Override
	public List<UserMaster> getAll() throws SQLException {
        List<UserMaster> userList = new ArrayList<UserMaster>();
       // createTable();
		//dbConnection = new DBConnection();
		//connect = dbConnection.connect_func();
        muConnection = new ManagingUserDB();
        connect = muConnection.connect();
        String sql = "SELECT * FROM Users";           
        statement =  (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	String userID = resultSet.getString("UserNames");
        	//String firstName = resultSet.getString("firstName");
        	//String lastName = resultSet.getString("lastName");
             
            //UserMaster userMaster = new UserMaster(userID, firstName, lastName);
            //userList.add(userMaster);
            
        }        
        resultSet.close();
        statement.close();         
    //    dbConnection.disconnect();   
        return userList;
    }

}
