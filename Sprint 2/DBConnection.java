import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	 private Connection connect = null;
	 private Statement statement = null;
	 private PreparedStatement preparedStatement = null;
	 private ResultSet resultSet = null;
	public void connect_func() throws SQLException {
		
	    if (connect == null || connect.isClosed()) {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            
	        } catch (ClassNotFoundException e) {
	            throw new SQLException(e);
	        }
	        
	        connect = (Connection) DriverManager
				      .getConnection("jdbc:mysql://senpaga.cvxtfkduma0q.us-east-2.rds.amazonaws.com:3306/senpaga?"
				          + "user=admin&password=password");
	        System.out.println(connect);
	    }
	}
	
	protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }

}
