package application;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.Calendar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestTour {

	private Tour t1, t2;
	
	@BeforeEach
	void init()
	{
		t1 = new Tour();
		t2 = new Tour(1, 1, "name", new Float(1.0), "name", "name", new Date(Calendar.getInstance().getTimeInMillis()));
	}
	
	@AfterEach
	void close()
	{
		t1 = null;
		t2 = null;		
	}
	
	@Test
	@DisplayName("TEST 1")
	void emptyTour()
	{
		assertEquals(t1.getIdtour(), Integer.valueOf(0), "idtour");
		assertEquals(t1.getClient_idclient(), Integer.valueOf(0), "client_idclient");
		assertEquals(t1.getName_of_tour(), String.valueOf(""), "name_of_tour");
		assertEquals(t1.getPrice_of_tour(), Float.valueOf(0), "price_of_tour");
		assertEquals(t1.getKind_of_transport(), String.valueOf(""), "kind_of_transport");
		assertEquals(t1.getPoint_of_depature(), String.valueOf(""), "point_of_depature");
		assertEquals(t1.getNumber_of_tour(), Date.valueOf("2018-01-01"), "number_of_tour");
	}
	
	@Test
	@DisplayName("TEST 2")
	void getIdtour()
	{
		assertEquals(t2.getIdtour(), Integer.valueOf(1), "idtour");
	}
	
	@Test
	@DisplayName("TEST 3")
	void getClient_idclient()
	{
		assertEquals(t2.getClient_idclient(), Integer.valueOf(1), "client_idclient");
	}
	
	@Test
	@DisplayName("TEST 4")
	void getName_of_tour()
	{
		assertEquals(t2.getName_of_tour(), String.valueOf("name"), "name_of_tour");
	}
	
	@Test
	@DisplayName("TEST 5")
	void getPrice_of_tour()
	{
		assertEquals(t2.getPrice_of_tour(), Float.valueOf(1), "price_of_tour");
	}
	
	@Test
	@DisplayName("TEST 6")
	void getKind_of_transport()
	{
		assertEquals(t2.getKind_of_transport(), String.valueOf("name"), "kind_of_transport");
	}
	
	@Test
	@DisplayName("TEST 7")
	void getPoint_of_depature()
	{
		assertEquals(t2.getPoint_of_depature(), String.valueOf("name"), "kind_of_transport");
	}
	
	@Test
	@DisplayName("TEST 8")
	void getNumber_of_tour()
	{
		assertEquals(t2.getNumber_of_tour(), new Date(Calendar.getInstance().getTimeInMillis()), "point_of_depature");
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
