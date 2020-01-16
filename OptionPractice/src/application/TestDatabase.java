package application;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestDatabase {

	private Database db;
	
	@BeforeEach
	void init() throws SQLException
	{
		db = new Database();
		db.openConnection();
	}
	
	@AfterEach
	void close()
	{
		db.closeConnection();
		db = null;
	}
	
	@Test
	@DisplayName("TEST 1")
	void insertClient() throws SQLException
	{
		assertEquals(db.newClient("ivan", "ivanov"), true);
	}
	
	@Test
	@DisplayName("TEST 2")
	void editClient() throws SQLException
	{
		assertEquals(db.editClient(23, "ivan", "ivanov"), true);
	}
	
	@Test
	@DisplayName("TEST 3")
	void deleteClient() throws SQLException
	{
		assertEquals(db.deleteClient(50), true);
	}
	
	@Test
	@DisplayName("TEST 4")
	void newHotel() throws SQLException
	{
		assertEquals(db.newHotel(1, "name", 1), true);
	}
	
	@Test
	@DisplayName("TEST 5")
	void editHotel() throws SQLException
	{
		assertEquals(db.editHotel(32, 1, "name", 3), true);
	}
	
	@Test
	@DisplayName("TEST 6")
	void deleteHotel() throws SQLException
	{
		assertEquals(db.deleteHotel(35), true);
	}
	
	@Test
	@DisplayName("TEST 7")
	void newLocality() throws SQLException
	{
		assertEquals(db.newLocality(2, "name", "name"), true);
	}
	
	@Test
	@DisplayName("TEST 8")
	void editLocality() throws SQLException
	{
		assertEquals(db.editLocality(12, 2, "name", "name"), true);
	}
	
	@Test
	@DisplayName("TEST 9")
	void deleteLocality() throws SQLException
	{
		assertEquals(db.deleteLocality(26), true);
	}
	
	@Test
	@DisplayName("TEST 10")
	void newTour() throws SQLException
	{
		assertEquals(db.newTour(40, "name", new Float(1), "name", "name", new Date(Calendar.getInstance().getTimeInMillis())), true);
	}
	
	@Test
	@DisplayName("TEST 11")
	void editTour() throws SQLException
	{
		assertEquals(db.editTour(2, 26, "name", new Float(1), "name", "name", new Date(Calendar.getInstance().getTimeInMillis())), true);
	}
	
	@Test
	@DisplayName("TEST 12")
	void deleteTour() throws SQLException
	{
		assertEquals(db.deleteTour(23), true);
	}
	
	@Test
	@DisplayName("TEST 13")
	void newUser() throws SQLException
	{
		assertEquals(db.newUser("name", "name", "name", "name"), true);
	}
	
	@Test
	@DisplayName("TEST 14")
	void editUser() throws SQLException
	{
		assertEquals(db.editUser(1, "name", "name", "name", "name"), true);
	}
	
	@Test
	@DisplayName("TEST 15")
	void deleteUser() throws SQLException
	{
		assertEquals(db.deleteUser(29), true);
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
