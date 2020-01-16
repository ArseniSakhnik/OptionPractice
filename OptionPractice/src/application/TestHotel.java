package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestHotel {

	private Hotel h1, h2;
	
	@BeforeEach
	void init()
	{
		h1 = new Hotel();
		h2 = new Hotel(1, 1, "hotel", 1);
	}
	
	@AfterEach
	void close()
	{
		h1 = null;
		h2 = null;
	}
	
	@Test
	@DisplayName("TEST 1")
	void emptyHotel()
	{
		assertEquals(h1.getIdhotel(), Integer.valueOf(0), "idhotel");
		assertEquals(h1.getLocality_idlocality(), Integer.valueOf(0), "locality_idlocality");
		assertEquals(h1.getHotel_name(), String.valueOf(""), "hotel_name");
		assertEquals(h1.getNumber_of_stars(), Integer.valueOf(0), "number_of_stars");
	}
	
	@Test
	@DisplayName("TEST 2")
	void idHotel()
	{
		assertEquals(h2.getIdhotel(), Integer.valueOf(1), "idhotel");
	}
	
	@Test
	@DisplayName("TEST 3")
	void locality_idlocality()
	{
		assertEquals(h2.getLocality_idlocality(), Integer.valueOf(1), "locality_idlocality");
	}
	
	@Test
	@DisplayName("TEST 4")
	void hotel_name()
	{
		assertEquals(h2.getHotel_name(), String.valueOf("hotel"), "hotel_name");
	}
	
	@Test
	@DisplayName("TEST 5")
	void number_of_stars()
	{
		assertEquals(h2.getNumber_of_stars(), Integer.valueOf(1), "number_of_stars");
	}
	
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
