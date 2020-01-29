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

public class TestFXMLAuthorization extends ApplicationTest
{

	@Override
	public void start(Stage stage) throws Exception
	{
		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("SampleAuthorization.fxml"));
		Scene scene = new Scene(root, 600, 300);
		stage.setScene(scene);
		stage.show();
	}

	@Test
	public void inputLogin()
	{
		clickOn("#tfLoginField");
		write("ivan");
		verifyThat("#tfLoginField", hasText("ivan"));
	}
	
	@Test 
	public void inputPassword()
	{
		clickOn("#tfPasswordField");
		write("ivan");
		verifyThat("#tfPasswordField", hasText("ivan"));
	}
	

}
