package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Locality {
	private IntegerProperty idlocality;
	private IntegerProperty tour_idtour;
	private StringProperty locality_name;
	private StringProperty country_of_location;
	
	public Locality()
	{
		this.idlocality = new SimpleIntegerProperty(0);
		this.tour_idtour = new SimpleIntegerProperty(0);
		this.locality_name = new SimpleStringProperty("");
		this.country_of_location = new SimpleStringProperty("");
	}
	
	public Locality(Integer idlocality, Integer tour_idtour, String locality_name, String country_of_location)
	{
		this.idlocality = new SimpleIntegerProperty(idlocality);
		this.tour_idtour = new SimpleIntegerProperty(tour_idtour);
		this.locality_name = new SimpleStringProperty(locality_name);
		this.country_of_location = new SimpleStringProperty(country_of_location);
	}

	public Integer getIdlocality() {
		return idlocality.get();
	}

	public Integer getTour_idtour() {
		return tour_idtour.get();
	}

	public String getLocality_name() {
		return locality_name.get();
	}

	public String getCountry_of_location() {
		return country_of_location.get();
	}
	
}
