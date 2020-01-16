package application;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SampleAuthorizationController {

	
	private Database db = new Database();
	
	@FXML private TextField tfLoginField;
	@FXML private PasswordField tfPasswordField;
	
	@FXML
	private void handleAuthorization() throws SQLException
	{
		String errorMessage = "";
		if (tfLoginField.getText() == null || tfLoginField.getText().length() == 0) 
			errorMessage += "No valid tfLoginField!\n";
		
		if (tfPasswordField.getText() == null || tfPasswordField.getText().length() == 0) 
			errorMessage += "No valid tfPasswordField!\n";
		
		if (errorMessage.length() == 0)
		{
			if (db.Authorization(tfLoginField.getText(), tfPasswordField.getText()))
			{
				try 
				{
					Stage primaryStage = new Stage();
					AnchorPane root = new AnchorPane();
					root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
					
					Scene scene = new Scene(root, 500, 500);
					primaryStage.setScene(scene);
					primaryStage.setTitle("View");
					primaryStage.show();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			else
			{
				errorMessage = "Пользователь не найден";
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Invalid Fields");
				alert.setHeaderText("Incorrect login or password");
				alert.setContentText(errorMessage);
				alert.showAndWait();
			}
		}
		else
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
		}
			
	}
}
