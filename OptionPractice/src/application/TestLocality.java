package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestLocality {

	private Locality l1, l2;
	
	@BeforeEach
	void init()
	{
		l1 = new Locality();
		l2 = new Locality(1, 1, "name", "country");
	}
	
	@AfterEach
	void close()
	{
		l1 = null;
		l2 = null;
	}
	
	@Test
	@DisplayName("TEST 1")
	void emptyLocality()
	{
		assertEquals(l1.getIdlocality(), Integer.valueOf(0), "idlocality");
		assertEquals(l1.getTour_idtour(), Integer.valueOf(0), "tour_idtour");
		assertEquals(l1.getLocality_name(), String.valueOf(""), "locality_name");
		assertEquals(l1.getCountry_of_location(), String.valueOf(""), "country_of_location");
	}
	
	@Test
	@DisplayName("TEST 2")
	void getIdlocality()
	{
		assertEquals(l2.getIdlocality(), Integer.valueOf(1), "idlocality");
	}
	
	@Test
	@DisplayName("TEST 3")
	void getTour_idtour()
	{
		assertEquals(l2.getTour_idtour(), Integer.valueOf(1), "tour_idtour");
	}
	
	@Test
	@DisplayName("TEST 4")
	void getLocality_name()
	{
		assertEquals(l2.getLocality_name(), String.valueOf("name"), "locality_name");
	}
	
	@Test
	@DisplayName("TEST 5")
	void getCountry_of_location()
	{
		assertEquals(l2.getCountry_of_location(), String.valueOf("country"), "country_of_location");
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
