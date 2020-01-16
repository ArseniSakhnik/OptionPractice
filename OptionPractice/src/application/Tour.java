package application;

import java.sql.Date;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Tour {
	private IntegerProperty idtour;
	private IntegerProperty client_idclient;
	private StringProperty name_of_tour;
	private FloatProperty price_of_tour;
	private StringProperty kind_of_transport;	
	private StringProperty point_of_depature;	
	private ObjectProperty<Date> number_of_tour;
	
	public Tour()
	{
		this.idtour = new SimpleIntegerProperty(0);
		this.client_idclient = new SimpleIntegerProperty(0);
		this.name_of_tour = new SimpleStringProperty("");
		this.price_of_tour = new SimpleFloatProperty(0);
		this.kind_of_transport = new SimpleStringProperty("");
		this.point_of_depature = new SimpleStringProperty("");
		this.number_of_tour = new SimpleObjectProperty<Date>(Date.valueOf("2018-01-01"));
	}
	
	public Tour(Integer idtour, Integer client_idclient, String name_of_tour, Float price_of_tour, String kind_of_transport,
			String point_of_depature, Date number_of_tour)
	{
		this.idtour = new SimpleIntegerProperty(idtour);
		this.client_idclient = new SimpleIntegerProperty(client_idclient);
		this.name_of_tour = new SimpleStringProperty(name_of_tour);
		this.price_of_tour = new SimpleFloatProperty(price_of_tour);
		this.kind_of_transport = new SimpleStringProperty(kind_of_transport);
		this.point_of_depature = new SimpleStringProperty(point_of_depature);
		this.number_of_tour = new SimpleObjectProperty<Date>(number_of_tour);
	}

	public Integer getIdtour() {
		return idtour.get();
	}

	public Integer getClient_idclient() {
		return client_idclient.get();
	}

	public String getName_of_tour() {
		return name_of_tour.get();
	}

	public Float getPrice_of_tour() {
		return price_of_tour.get();
	}

	public String getKind_of_transport() {
		return kind_of_transport.get();
	}

	public String getPoint_of_depature() {
		return point_of_depature.get();
	}

	public Date getNumber_of_tour() {
		return number_of_tour.get();
	}
	
	
}
