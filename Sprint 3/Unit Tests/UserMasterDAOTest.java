import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class UserMasterDAOTest {
	
	
	@Test
	void testAddUser() throws SQLException {
		boolean userAdded;
		UserMasterDAO userMasterDAO = new UserMasterDAO();
		Scanner input = new Scanner(System.in);
		String user = "JUnittestUser";
		UserMaster userObj = new UserMaster(user);
		userAdded = userMasterDAO.add(userObj);	
		assertEquals(true, userAdded);
	}
	
	@Test
	void testDeleteUser() throws SQLException {
		boolean userDeleted;
		UserMasterDAO userMasterDAO = new UserMasterDAO();
		String user = "JUnittestUser";
		userDeleted = userMasterDAO.delete(user);
		assertEquals(true, userDeleted);
	}

}
