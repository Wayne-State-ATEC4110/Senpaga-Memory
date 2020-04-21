/**
 * 
 * @author Calvin Brooks
 * Description: Class for storing user data from DB
 */
public class UserMaster {
	private String UserNames;
//	private String firstName;
//	private String lastName;
	
	
	public UserMaster() {
	}
	public UserMaster(String UserNames) {
		this.UserNames = UserNames;
//		this.firstName = firstName;
//		this.lastName = lastName;
	}
	public String getUserNames() {
		return UserNames;
	}
	public void setUserNames(String userNames) {
		UserNames = userNames;
	}
//	public void setUserID(String userID) { //This code may be used later
//		this.userID = userID;
//	}
//	public String getFirstName() {
//		return firstName;
//	}
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//	public String getLastName() {
//		return lastName;
//	}
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}

}
