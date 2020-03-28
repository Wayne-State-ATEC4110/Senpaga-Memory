import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//author: Ervin Colston

//this class is for the Managing Multiple Users functionality
//try and catch blocks are used in the SQL operations for rainy day purposes

public class ManagingUser {
	
	int count; //this field is for keeping track of how many users are in the system so that switching between users is 
	//easier
	int userNumberSelection; //used for validation purposes for ranges
	String word; //this field is mainly used for accessing the strings stored in the database
	String currentUser; //used for storing the current user in the system
	
	public void getCurrentUser(){
		
		ManagingUserDB connector = new ManagingUserDB(); //using the database class to help supplement most of the database operations
		
        String sql = "SELECT CurrentUser FROM CurrentUser";
        
        try (Connection conn = connector.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("CurrentUser"));
                this.currentUser = rs.getString("CurrentUser");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

	public void getUsers() //prints out every user in the db
	{
		ManagingUserDB connector = new ManagingUserDB();
		
        String sql = "SELECT UserNames FROM Users";
        
        try (Connection conn = connector.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
        	this.count = 0;
        	int itr = 1;
            // loop through the result set
        	System.out.println();
        	System.out.println("Users Stored in the System");
            while (rs.next()) {
                System.out.println(itr + " " + rs.getString("UserNames"));
                itr++;
                this.count++;
            }
            System.out.println("\n");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public void switchUser()
	{
		
		//use the count field as a limit
		
		do {
			System.out.print("Choose the Number of the User you Wish to be: ");
			@SuppressWarnings("resource") //to close the scanner leak
			Scanner sc = new Scanner(System.in);
			int num;
			
			
			while(!sc.hasNextInt())
			{
				System.out.print("Enter a Number!: ");
				sc.next();
			}
			
			num = sc.nextInt();
			
			//the below code guarantees that you choose a valid user
			if(num < 1)
				{ System.out.println("Error! Too Low!"); }
			if(num > this.count)
				{ System.out.println("Error! Too High!"); }
				
			
			this.userNumberSelection = num;
		}
		while (this.userNumberSelection < 1 || this.userNumberSelection > this.count);
		
		getReplacement();
		replace();
		
		System.out.println("User has been changed \n\n"); //validation code message
		
	}
	
	public void getReplacement() //will get the user you want to be
	{
		ManagingUserDB connector = new ManagingUserDB();
		
        String sql = "SELECT UserNames FROM Users";
        
        try (Connection conn = connector.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
        	int itr = 1;
            while (rs.next()) {
            	if(itr == this.userNumberSelection)
            	{
            		this.word = rs.getString("UserNames");
            	}
                itr++;
                
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}

	public void replace() //actually replace the current user with the new current user
	{
		//first truncate table
		ManagingUserDB connector = new ManagingUserDB();
		
		try {
			
			 
			Connection conn = connector.connect();
            Statement stmt  = conn.createStatement();
           
			stmt.executeUpdate("DELETE FROM CurrentUser");
			 
			 
			    } catch (SQLException e) {
			 
			  System.out.println("Could not truncate table " + e.getMessage());
			    }
		
		//now insert value
		
		final String SQL = "INSERT INTO CurrentUser VALUES(?)";
		
		try {
			
			 
			Connection conn = connector.connect();
            //Statement stmt  = conn.createStatement();
            PreparedStatement ps = conn.prepareStatement(SQL);
            
            ps.setString(1, this.word);
            
			  ps.executeUpdate();
			 
			 
			    } catch (SQLException e) {
			 
			  System.out.println("Could not complete operation " + e.getMessage());
			    }
	}

}
