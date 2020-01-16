package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Database {
	
	public static User userAuth;
	
	private Connection conn;
	
	public Database()
	{
		this.conn =  null;
	}
	
	boolean openConnection() throws SQLException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost/practicedb?user=root&password=gfhjkm2288");
		}
		catch(InstantiationException | IllegalAccessException | ClassNotFoundException e)
		{
			System.out.println("SQL exception" + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	void closeConnection() {
		try {
			if (this.conn != null)
				this.conn.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		this.conn = null;
	}
	
	public boolean Authorization(String login, String password) throws SQLException
	{
		try {
			List<User> us = getAllUser();
			for (int i = 0; i < us.size(); i++)
			{
				if (us.get(i).getLogin().equals(login) && us.get(i).getPassword().equals(password))
				{
					userAuth = new User(us.get(i).getIduser(), us.get(i).getPosition(), us.get(i).getName(),
							us.get(i).getLogin(), us.get(i).getPassword());
					return true;
				}
			}
			return false;
		}
		catch(SQLException e)
		{
			System.out.println("SQl exception" + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Client> getAllClient() throws SQLException{
		Statement st = null;
		ResultSet rs = null;
		List<Client> lClient = new ArrayList<Client>();
		if (openConnection()) {
			try {
				st = (Statement) conn.createStatement();
				rs = st.executeQuery("select * from practicedb.client");
				while(rs.next()) {
					lClient.add(new Client(rs.getInt("idclient"), rs.getString("first_name"),
							rs.getString("last_name")));
				}
			}catch(SQLException e) {
				System.out.println("SQL exception" + e.getMessage());
				e.printStackTrace();
				return null;
			}
			finally {
				try {
					if (st != null)
						st.close();
					closeConnection();
					}
					catch(SQLException e)
					{
					e.printStackTrace();
					}
				st = null;
				}
			}
		return lClient;
	}
	
	public boolean newClient(String first_name, String last_name) throws SQLException {
		int result = 0;
		if (openConnection()) {
			Statement st = null;
			try {
				st = (Statement) conn.createStatement();
				result = st.executeUpdate("insert into practicedb.client (first_name, last_name)"
						+ "values('" + first_name + "','"
						+ last_name + "');");
			} catch (SQLException e) {
				System.out.println("SQl exception" + e.getMessage());
				e.printStackTrace();
			} finally {
				try {
					if (st != null)
						st.close();
					closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
		}
				st = null;
			}
		}
		return (result == 1);
	}

	public boolean deleteClient(Integer idclient) throws SQLException
	{
		int result = 0;
		if (openConnection())
		{
			Statement st = null;
			try {
				st = (Statement) conn.createStatement(); 
				result = st.executeUpdate("delete from practicedb.client where idclient = '"
						+ idclient + "';");
			}
			catch (SQLException e) {
				result = 0;
				System.out.println("SQl exception" + e.getMessage());
				e.printStackTrace();
			}
			finally {
				try {
					if (st != null)
						st.close();
					closeConnection();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				st = null;
			}
		}
		return (result == 1);
		}
	
	public boolean editClient(Integer idclient, String first_name, String last_name) throws SQLException
	{
		int result = 0;
		if (openConnection()) {
			Statement st = null;
			try {
				st = (Statement) conn.createStatement();
				result = st.executeUpdate("update practicedb.client set first_name = '" + first_name 
						+ "', last_name = '"  + last_name + "' where idclient = '" + idclient + "';");
			} catch (SQLException e) {
				System.out.println("SQl exception" + e.getMessage());
				e.printStackTrace();
			} finally {
				try {
					if (st != null)
						st.close();
					closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				st = null;
			}
		}
		return (result == 1);
	}
	
	public List<Hotel> getAllHotel() throws SQLException
	{
		Statement st = null;
		ResultSet rs = null;
		List<Hotel> lHotel = new ArrayList<Hotel>();
		if (openConnection())
		{
			try 
			{
				st = (Statement) conn.createStatement();
				rs = st.executeQuery("select * from practicedb.hotel");
				while(rs.next()) 
				{
					lHotel.add(new Hotel(rs.getInt("idhotel"), rs.getInt("locality_idlocality"), rs.getString("hotel_name"),
							rs.getInt("number_of_stars")));
				}
			}
			catch(SQLException e) {
				System.out.println("SQL exception" + e.getMessage());
				e.printStackTrace();
				return null;
			}
			finally 
			{
				try 
				{
					if (st != null)
						st.close();
					closeConnection();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
					st = null;
			}
		}
		return lHotel;
	}
			
	public boolean newHotel(Integer locality_idlocality, String hotel_name, Integer number_of_stars) throws SQLException
	{
		int result = 0;
		if (openConnection()) 
		{
			Statement st = null;
			try {
				st = (Statement) conn.createStatement();
				result = st.executeUpdate("insert into practicedb.hotel (locality_idlocality, hotel_name, number_of_stars)"
						+ "values('" + locality_idlocality + "','" + hotel_name + "','" + number_of_stars + "');");
			}
			catch (SQLException e) 
			{
				System.out.println("SQl exception" + e.getMessage());
				e.printStackTrace();
			}
			finally
			{
				try 
				{
					if (st != null)
						st.close();
					closeConnection();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				st = null;
			}
		}
		return (result == 1);
		}
	
	public boolean deleteHotel(Integer idhotel) throws SQLException
	{
		int result = 0;
		if (openConnection())
		{
			Statement st = null;
			try {
				st = (Statement) conn.createStatement(); 
				result = st.executeUpdate("delete from practicedb.hotel where idhotel = '"
						+ idhotel + "';");
			}
			catch (SQLException e) {
				result = 0;
				System.out.println("SQl exception" + e.getMessage());
				e.printStackTrace();
			}
			finally {
				try {
					if (st != null)
						st.close();
					closeConnection();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				st = null;
			}
		}
		return (result == 1);
	}
	
	public boolean editHotel(Integer idhotel, Integer locality_idlocality,
			String hotel_name, Integer number_of_stars) throws SQLException
	{
		int result = 0;
		if (openConnection()) {
			Statement st = null;
			try {
				st = (Statement) conn.createStatement();
				result = st.executeUpdate("update practicedb.hotel set locality_idlocality = '" + locality_idlocality 
						+ "', hotel_name = '"  + hotel_name + "', number_of_stars = '" + number_of_stars + "' where idhotel = '" + idhotel + "';");
			} catch (SQLException e) {
				System.out.println("SQl exception" + e.getMessage());
				e.printStackTrace();
			} finally {
				try {
					if (st != null)
						st.close();
					closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				st = null;
			}
		}
		return (result == 1);
	}
	
	public List<Locality> getAllLocality() throws SQLException
	{
		Statement st = null;
		ResultSet rs = null;
		List<Locality> lLocality = new ArrayList<Locality>();
		if (openConnection())
		{
			try 
			{
				st = (Statement) conn.createStatement();
				rs = st.executeQuery("select * from practicedb.locality");
				while(rs.next()) 
				{
					lLocality.add(new Locality(rs.getInt("idlocality"), rs.getInt("tour_idtour"), rs.getString("locality_name"),
							rs.getString("country_of_location")));
				}
			}
			catch(SQLException e) {
				System.out.println("SQL exception" + e.getMessage());
				e.printStackTrace();
				return null;
			}
			finally 
			{
				try 
				{
					if (st != null)
						st.close();
					closeConnection();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
					st = null;
			}
		}
		return lLocality;
	}

	public boolean newLocality(Integer tour_idtour, String locality_name, String country_of_location) throws SQLException
	{
		int result = 0;
		if (openConnection()) {
			Statement st = null;
			try {
				st = (Statement) conn.createStatement();
				result = st.executeUpdate("insert into practicedb.locality (tour_idtour, locality_name, country_of_location)"
						+ "values('" + tour_idtour + "','"
						+ locality_name + "','" + country_of_location + "');");
			} catch (SQLException e) {
				System.out.println("SQl exception" + e.getMessage());	
				e.printStackTrace();
			} finally {
				try {
					if (st != null)
						st.close();
					closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
		}
				st = null;
			}
		}
		return (result == 1);
	}

	public boolean deleteLocality(Integer idlocality) throws SQLException
	{
		int result = 0;
		if (openConnection())
		{
			Statement st = null;
			try {
				st = (Statement) conn.createStatement(); 
				result = st.executeUpdate("delete from practicedb.locality where idlocality = '"
						+ idlocality + "';");
			}
			catch (SQLException e) {
				result = 0;
				System.out.println("SQl exception" + e.getMessage());
				e.printStackTrace();
			}
			finally {
				try {
					if (st != null)
						st.close();
					closeConnection();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				st = null;
			}
		}
		return (result == 1);
	}
	
	public boolean editLocality(Integer idlocality, Integer tour_idtour, String locality_name, String country_of_location) throws SQLException
	{
		int result = 0;
		if (openConnection()) {
			Statement st = null;
			try {
				st = (Statement) conn.createStatement();
				result = st.executeUpdate("update practicedb.locality set tour_idtour = '" + tour_idtour 
						+ "', locality_name = '"  + locality_name + "', country_of_location = '" + country_of_location 
						+ "' where idlocality = '" + idlocality + "';");
			} catch (SQLException e) {
				System.out.println("SQl exception" + e.getMessage());
				e.printStackTrace();
			} finally {
				try {
					if (st != null)
						st.close();
					closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				st = null;
			}
		}
		return (result == 1);
	}
	
	public List<Tour> getAllTour() throws SQLException
	{
		Statement st = null;
		ResultSet rs = null;
		List<Tour> lTour = new ArrayList<Tour>();
		if (openConnection())
		{
			try 
			{
				st = (Statement) conn.createStatement();
				rs = st.executeQuery("select * from practicedb.tour");
				while(rs.next()) 
				{
					lTour.add(new Tour(rs.getInt("idtour"), rs.getInt("client_idclient"), rs.getString("name_of_tour"),
							rs.getFloat("price_of_tour"), rs.getString("kind_of_transport"), rs.getString("point_of_depature"),
							rs.getDate("number_of_tour")));
							
				}
			}
			catch(SQLException e) {
				System.out.println("SQL exception" + e.getMessage());
				e.printStackTrace();
				return null;
			}
			finally 
			{
				try 
				{
					if (st != null)
						st.close();
					closeConnection();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
					st = null;
			}
		}
		return lTour;
	}

	public boolean newTour(Integer client_idclient, String name_of_tour, Float price_of_tour, String kind_of_transport,
			String point_of_depature, Date number_of_tour) throws SQLException
	{
		int result = 0;
		if (openConnection()) {
			Statement st = null;
			try {
				st = (Statement) conn.createStatement();
				result = st.executeUpdate("insert into practicedb.tour (client_idclient, name_of_tour, price_of_tour,"
						+ "kind_of_transport, point_of_depature, number_of_tour)"
						+ "values('" + client_idclient + "','"
						+ name_of_tour + "','" + price_of_tour + "','" + kind_of_transport 
						+ "','" + point_of_depature + "','" + number_of_tour + "');");
			} catch (SQLException e) {
				System.out.println("SQl exception" + e.getMessage());
				e.printStackTrace();
			} finally {
				try {
					if (st != null)
						st.close();
					closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
		}
				st = null;
			}
		}
		return (result == 1);
	}

	public boolean deleteTour(Integer idtour) throws SQLException
	{
		int result = 0;
		if (openConnection())
		{
			Statement st = null;
			try {
				st = (Statement) conn.createStatement(); 
				result = st.executeUpdate("delete from practicedb.tour where idtour = '"
						+ idtour + "';");
			}
			catch (SQLException e) {
				result = 0;
				System.out.println("SQl exception" + e.getMessage());
				e.printStackTrace();
			}
			finally {
				try {
					if (st != null)
						st.close();
					closeConnection();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				st = null;
			}
		}
		return (result == 1);
	}
	
	public boolean editTour(Integer idtour, Integer client_idclient, String name_of_tour, Float price_of_tour, String kind_of_transport,
			String point_of_depature, Date number_of_tour) throws SQLException
	{
		int result = 0;
		if (openConnection()) {
			Statement st = null;
			try {
				st = (Statement) conn.createStatement();
				result = st.executeUpdate("update practicedb.tour set client_idclient = '" + client_idclient 
						+ "', name_of_tour = '"  + name_of_tour + "', price_of_tour = '" + price_of_tour + "', kind_of_transport = '" 
						+ kind_of_transport + "', point_of_depature = '" + point_of_depature + "', number_of_tour ='" 
						+ number_of_tour + "' where idtour = '" + idtour + "';");
			} catch (SQLException e) {
				System.out.println("SQl exception" + e.getMessage());
				e.printStackTrace();
			} finally {
				try {
					if (st != null)
						st.close();
					closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				st = null;
			}
		}
		return (result == 1);
	}
	
	public List<User> getAllUser() throws SQLException
	{
		Statement st = null;
		ResultSet rs = null;
		List<User> lUser = new ArrayList<User>();
		if (openConnection())
		{
			try 
			{
				st = (Statement) conn.createStatement();
				rs = st.executeQuery("select * from practicedb.user");
				while(rs.next()) 
				{
					lUser.add(new User(rs.getInt("iduser"), rs.getString("position"), rs.getString("name"),
							rs.getString("login"), rs.getString("password")));		
				}
			}
			catch(SQLException e) {
				System.out.println("SQL exception" + e.getMessage());
				e.printStackTrace();
				return null;
			}
			finally 
			{
				try 
				{
					if (st != null)
						st.close();
					closeConnection();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
					st = null;
			}
		}
		return lUser;
	}

	public boolean newUser(String position, String name, String login, String password) throws SQLException
	{
		int result = 0;
		if (openConnection()) {
			Statement st = null;
			try {
				st = (Statement) conn.createStatement();
				result = st.executeUpdate("insert into practicedb.user (position, name, login, password)"
						+ "values('" + position + "','"
						+ name + "','" + login + "','" + password + "');");
			} catch (SQLException e) {
				System.out.println("SQl exception" + e.getMessage());
				e.printStackTrace();
			} finally {
				try {
					if (st != null)
						st.close();
					closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
		}
				st = null;
			}
		}
		return (result == 1);
	}

	public boolean deleteUser(Integer iduser) throws SQLException
	{
		int result = 0;
		if (openConnection())
		{
			Statement st = null;
			try {
				st = (Statement) conn.createStatement(); 
				result = st.executeUpdate("delete from practicedb.user where iduser = '"
						+ iduser + "';");
			}
			catch (SQLException e) {
				result = 0;
				System.out.println("SQl exception" + e.getMessage());
				e.printStackTrace();
			}
			finally {
				try {
					if (st != null)
						st.close();
					closeConnection();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				st = null;
			}
		}
		return (result == 1);
	}

	public boolean editUser(Integer iduser, String position, String name, String login, String password) throws SQLException
	{
		int result = 0;
		if (openConnection()) {
			Statement st = null;
			try {
				st = (Statement) conn.createStatement();
				result = st.executeUpdate("update practicedb.user set position = '" + position 
						+ "', name = '"  + name + "', login = '" + login + "', password = '" 
						+ password +"' where iduser = '" + iduser + "';");
			} catch (SQLException e) {
				System.out.println("SQl exception" + e.getMessage());
				e.printStackTrace();
			} finally {
				try {
					if (st != null)
						st.close();
					closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
		}
				st = null;
			}
		}
		return (result == 1);
	}

}

