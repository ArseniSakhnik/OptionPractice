package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestClient {

	private Client c1, c2;
	
	@BeforeEach
	void init()
	{
		c1 = new Client();
		c2 = new Client(1, "ivan", "ivanov");
	}
	
	@AfterEach
	void close()
	{
		c1 = null;
		c2 = null;
	}
	
	@Test
	@DisplayName("TEST 1")
	void emptyClient()
	{
		assertEquals(c1.getIdclient(), Integer.valueOf(0), "idclient");
		assertEquals(c1.getFirst_name(), String.valueOf(""), "first_name");
		assertEquals(c1.getLast_name(), String.valueOf(""), "last_name");
	}
	
	@Test
	@DisplayName("TEST 2")
	void idClient() {
		assertEquals(c2.getIdclient(), Integer.valueOf(1), "idclient");
	}
	
	@Test 
	@DisplayName("TEST 3")
	void firstName() {
		assertEquals(c2.getFirst_name(), String.valueOf("ivan"),"first_name");
	}
	
	@Test
	@DisplayName("TEST 4")
	void lastName() {
		assertEquals(c2.getLast_name(), String.valueOf("ivanov"),"last_name");
	}
	
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

	
}
