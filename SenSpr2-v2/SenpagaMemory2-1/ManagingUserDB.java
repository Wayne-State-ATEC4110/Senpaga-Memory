import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//author: Ervin Colston

//deal with all db options concerning the users

public class ManagingUserDB {

	public void createDB() throws ClassNotFoundException {  
		   
		// load the sqlite-JDBC driver using the current class loader
	    Class.forName("org.sqlite.JDBC");
        
   
        try {  
            Connection conn = DriverManager.getConnection("jdbc:sqlite:sample.db");  
            if (conn != null) {  
                System.out.println("Connected to the Database \n");  
            	}  
   
        	} 
        
        catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } 
        
	}
	
	
	Connection connect() { //for all other sqlite connections
        String url = "jdbc:sqlite:sample.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


	
}
