package application;

import java.sql.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {
	
	private IntegerProperty idclient;
	private StringProperty first_name;
	private StringProperty last_name;
	
	public Client()
	{
		this.idclient = new SimpleIntegerProperty(0);
		this.first_name = new SimpleStringProperty("");
		this.last_name = new SimpleStringProperty("");
	}
	
	public Client(Integer iduser, String first_name, String last_name)
	{
		this.idclient = new SimpleIntegerProperty(iduser);
		this.first_name = new SimpleStringProperty(first_name);
		this.last_name = new SimpleStringProperty(last_name);
	}

	public Integer getIdclient() {
		return idclient.get();
	}

	public String getFirst_name() {
		return first_name.get();
	}

	public String getLast_name() {
		return last_name.get();
	}
	
}
