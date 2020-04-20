
//package senpaga_test2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class main_test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//System.out.println("here here");
//		try {
//			System.out.println("going in");
//			connect_func();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		TrainingSession trs = new TrainingSession();
		trs.showTrainingSession("Calvin");

	}
	
	public static void connect_func() throws SQLException {
		 Connection connect = null;
		 Statement statement = null;
		 PreparedStatement preparedStatement = null;
		 ResultSet resultSet = null;
		System.out.println("here here");
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
	    System.out.println("end");
	}

}
