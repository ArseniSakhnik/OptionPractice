package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Hotel {

	private IntegerProperty idhotel;
	private IntegerProperty locality_idlocality;
	private StringProperty hotel_name;
	private IntegerProperty number_of_stars;
	
	public Hotel()
	{
		this.idhotel = new SimpleIntegerProperty(0);
		this.locality_idlocality = new SimpleIntegerProperty(0);
		this.hotel_name = new SimpleStringProperty("");
		this.number_of_stars = new SimpleIntegerProperty(0);
	}
	
	public Hotel(Integer idhotel, Integer locality_idlocality, String hotel_name, Integer number_of_stars)
	{
		this.idhotel = new SimpleIntegerProperty(idhotel);
		this.locality_idlocality = new SimpleIntegerProperty(locality_idlocality);
		this.hotel_name = new SimpleStringProperty(hotel_name);
		this.number_of_stars = new SimpleIntegerProperty(number_of_stars);
	}

	public Integer getIdhotel() {
		return idhotel.get();
	}

	public Integer getLocality_idlocality() {
		return locality_idlocality.get();
	}

	public String getHotel_name() {
		return hotel_name.get();
	}

	public Integer getNumber_of_stars() {
		return number_of_stars.get();
	}
	
}
