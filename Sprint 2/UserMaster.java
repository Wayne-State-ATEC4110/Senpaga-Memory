/**
 * 
 * @author Calvin Brooks
 * Description: Class for storing user data from DB
 */
public class UserMaster {
	private String userID;
	private String firstName;
	private String lastName;
	
	
	public UserMaster() {
	}
	public UserMaster(String userID, String firstName, String lastName) {
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
