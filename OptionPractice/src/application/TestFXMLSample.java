package application;

import java.io.IOException;
import org.junit.Test;
import org.testfx.framework.junit.*;

import com.sun.glass.ui.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.hasText;

public class TestFXMLSample extends ApplicationTest{

	@Override
	public void start(Stage stage) throws Exception
	{
		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Sample.fxml"));
		new Database().Authorization("login", "password");
		Scene scene = new Scene(root, 600, 600);
		stage.setScene(scene);
		stage.show();
	}
	
	@Test
	public void inputNumber_of_stars()
	{
		clickOn("#tfNumber_of_stars");
		write("3");
		verifyThat("#tfNumber_of_stars", hasText("3"));
	}
	
	@Test
	public void inputLocality_idLocality()
	{
		clickOn("#tfLocality_idLocality");
		write("2");
		verifyThat("#tfLocality_idLocality", hasText("2"));
	}
	
	@Test
	public void inputHotel_name()
	{
		clickOn("#tfHotel_name");
		write("hotel");
		verifyThat("#tfHotel_name", hasText("hotel"));
	}
	
	@Test
	public void inputLocality_name()
	{
		clickOn("#tabLocality_view");
		clickOn("#tfLocality_name");
		write("nameOfLocality");
		verifyThat("#tfLocality_name", hasText("nameOfLocality"));
	}
	
	@Test
	public void inputTour_idtour()
	{
		clickOn("#tabLocality_view");
		clickOn("#tfTour_idtour");
		write("3");
		verifyThat("#tfTour_idtour", hasText("3"));
	}
	
	@Test 
	public void inputCountry_of_location()
	{
		clickOn("#tabLocality_view");
		clickOn("#tfCountry_of_location");
		write("countryOfLocation");
		verifyThat("#tfCountry_of_location", hasText("countryOfLocation"));
	}
	
	@Test
	public void inputName_of_tour()
	{
		clickOn("#tabTour_view");
		clickOn("#tfName_of_tour");
		write("nameOfTour");
		verifyThat("#tfName_of_tour", hasText("nameOfTour"));
	}
	
	@Test
	public void inputKind_of_transport()
	{
		clickOn("#tabTour_view");
		clickOn("#tfKind_of_transport");
		write("kindOfTransport");
		verifyThat("#tfKind_of_transport", hasText("kindOfTransport"));
	}
	
	@Test
	public void inputClient_idclient()
	{
		clickOn("#tabTour_view");
		clickOn("#tfClient_idclient");
		write("2");
		verifyThat("#tfClient_idclient", hasText("2"));
	}
	
	@Test
	public void inputPrice_of_tour()
	{
		clickOn("#tabTour_view");
		clickOn("#tfPrice_of_tour");
		write("2.5");
		verifyThat("#tfPrice_of_tour", hasText("2.5"));
	}
	
	@Test
	public void inputPoint_of_depature()
	{
		clickOn("#tabTour_view");
		clickOn("#tfPoint_of_depature");
		write("pointOfDepature");
		verifyThat("#tfPoint_of_depature", hasText("pointOfDepature"));
	}
	
	@Test
	public void inputNumber_of_tour()
	{
		clickOn("#tabTour_view");
		clickOn("#tfNumber_of_tour");
		write("1995-12-12");
		verifyThat("#tfNumber_of_tour", hasText("1995-12-12"));
	}
	
	@Test
	public void inputFirstName()
	{
		clickOn("#tabClient_view");
		clickOn("#tfFirstName");
		write("FirstName");
		verifyThat("#tfFirstName", hasText("FirstName"));
	}
	
	@Test
	public void inputLastName()
	{
		clickOn("#tabClient_view");
		clickOn("#tfLastName");
		write("LastName");
		verifyThat("#tfLastName", hasText("LastName"));
	}
	
	@Test
	public void inputLogin()
	{
		clickOn("#tabUser_view");
		clickOn("#tfLogin");
		write("Login");
		verifyThat("#tfLogin", hasText("Login"));
	}
	
	@Test
	public void inputPosition()
	{
		clickOn("#tabUser_view");
		clickOn("#tfPosition");
		write("Position");
		verifyThat("#tfPosition", hasText("Position"));
	}
	
	@Test
	public void inputPassword()
	{
		clickOn("#tabUser_view");
		clickOn("#tfPassword");
		write("password");
		verifyThat("#tfPassword", hasText("password"));
	}
	
	@Test
	public void inputName()
	{
		clickOn("#tabUser_view");
		clickOn("#tfName");
		write("Name");
		verifyThat("#tfName", hasText("Name"));
	}
	
	@Test
	public void inputBackUpCopyName()
	{
		clickOn("#tabUser_view");
		clickOn("#tfBackUpCopyName");
		write("BackUpCopyName");
		verifyThat("#tfBackUpCopyName", hasText("BackUpCopyName"));
	}
	
	
	
	
}
