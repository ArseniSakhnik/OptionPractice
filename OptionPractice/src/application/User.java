package application;

import java.io.IOException;
import java.io.InputStream;

import com.mysql.jdbc.log.Log;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
	private IntegerProperty iduser;
	private StringProperty position;
	private StringProperty name;
	private StringProperty login;
	private StringProperty password;
	
	public User()
	{
		this.iduser = new SimpleIntegerProperty(0);
		this.position = new SimpleStringProperty("");
		this.name = new SimpleStringProperty("");
		this.login = new SimpleStringProperty("");
		this.password = new SimpleStringProperty("");
	}
	
	public User(Integer iduser, String position, String name, String login, String password)
	{
		this.iduser = new SimpleIntegerProperty(iduser);
		this.position = new SimpleStringProperty(position);
		this.name = new SimpleStringProperty(name);
		this.login = new SimpleStringProperty(login);
		this.password = new SimpleStringProperty(password);
	}
	
	public void createBackUpCopy(String nameBackUpCopy) throws InterruptedException
	{
		try {
			Runtime.getRuntime().exec("cmd /c \"cd C:\\Program Files\\MariaDB 10.4\\bin && "
					+ "mysqldump -uroot -pgfhjkm2288 practicedb > practicedb-dump2.sql");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void restoreBackUpCopy(String nameBackUpCopy) throws InterruptedException
	{
		try {
			Runtime.getRuntime().exec("cmd /c \"cd C:\\Program Files\\MariaDB 10.4\\bin && "
					+ "mysqldump -uroot -pgfhjkm2288 practicedb < practicedb-dump2.sql");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public Integer getIduser() {
		return iduser.get();
	}

	public String getPosition() {
		return position.get();
	}

	public String getName() {
		return name.get();
	}

	public String getLogin() {
		return login.get();
	}

	public String getPassword() {
		return password.get();
	}
	
}
