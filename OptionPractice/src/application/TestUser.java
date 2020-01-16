package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestUser {

	private User u1, u2;
	
	@BeforeEach
	void init()
	{
		u1 = new User();
		u2 = new User(1, "name", "name", "name", "name");
	}
	
	@AfterEach
	void close()
	{
		u1 = null;
		u2 = null;
	}
	
	@Test
	@DisplayName("TEST 1")
	void emptyUser()
	{
		assertEquals(u1.getIduser(), Integer.valueOf(0), "iduser");
		assertEquals(u1.getPosition(), String.valueOf(""), "position");
		assertEquals(u1.getName(), String.valueOf(""), "name");
		assertEquals(u1.getLogin(), String.valueOf(""), "login");
		assertEquals(u1.getPassword(), String.valueOf(""), "password");
	}
	
	@Test
	@DisplayName("TEST 2")
	void getIduser()
	{
		assertEquals(u2.getIduser(), Integer.valueOf(1), "iduser");
	}
	
	@Test
	@DisplayName("TEST 3")
	void getPosition()
	{
		assertEquals(u2.getPosition(), String.valueOf("name"), "position");
	}
	
	@Test
	@DisplayName("TEST 4")
	void getName()
	{
		assertEquals(u2.getName(), String.valueOf("name"), "name");
	}
	
	@Test
	@DisplayName("TEST 5")
	void getLogin()
	{
		assertEquals(u2.getLogin(), String.valueOf("name"), "login");
	}
	
	@Test
	@DisplayName("TEST 6")
	void getPassword()
	{
		assertEquals(u2.getPassword(), String.valueOf("name"), "password");
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
