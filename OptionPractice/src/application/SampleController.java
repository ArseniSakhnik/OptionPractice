package application;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

//project
public class SampleController {
	
	@FXML private Tab tabLocality_view;
	@FXML private Tab tabTour_view;
	@FXML private Tab tabClient_view;
	@FXML private Tab tabUser_view;
	
	/*client_view*/
	@FXML private TableView<Client> tvClient;
	@FXML private TableColumn<Client, Integer> tcIdClient;
	@FXML private TableColumn<Client, String> tcFirstName;
	@FXML private TableColumn<Client, String> tcLastName;
	@FXML private TextField tfIdClient;
	@FXML private TextField tfFirstName;
	@FXML private TextField tfLastName;
	
	private Database db = new Database();
	private DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
	
	@FXML
	private void initialize() throws SQLException
	{
		tcIdClient.setCellValueFactory(new PropertyValueFactory<Client, Integer>("idclient"));
		tcFirstName.setCellValueFactory(new PropertyValueFactory<Client, String>("first_name"));
		tcLastName.setCellValueFactory(new PropertyValueFactory<Client, String>("last_name"));
		tvClient.setItems(FXCollections.observableArrayList(db.getAllClient()));
		showClientDetails(null);
		tvClient.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->
		{
			showClientDetails(newValue);
		});
		
		tcIdHotel.setCellValueFactory(new PropertyValueFactory<Hotel, Integer>("idhotel"));
		tcLocality_idLocality.setCellValueFactory(new PropertyValueFactory<Hotel, Integer>("locality_idlocality"));
		tcHotel_name.setCellValueFactory(new PropertyValueFactory<Hotel, String>("hotel_name"));
		tcNumber_of_stars.setCellValueFactory(new PropertyValueFactory<Hotel, Integer>("number_of_stars"));
		
		tvHotel.setItems(FXCollections.observableArrayList(db.getAllHotel()));
		showHotelDetails(null);
		tvHotel.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->
		{
			showHotelDetails(newValue);
		});
		
		tcIdlocality.setCellValueFactory(new PropertyValueFactory<Locality, Integer>("idlocality"));
		tcTour_idtour.setCellValueFactory(new PropertyValueFactory<Locality, Integer>("tour_idtour"));
		tcLocality_name.setCellValueFactory(new PropertyValueFactory<Locality, String>("locality_name"));
		tcCountry_of_location.setCellValueFactory(new PropertyValueFactory<Locality, String>("country_of_location"));
		
		tvLocality.setItems(FXCollections.observableArrayList(db.getAllLocality()));
		showLocalityDetails(null);
		
		tvLocality.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->
		{
			showLocalityDetails(newValue);
		});
		
		tcIdtour.setCellValueFactory(new PropertyValueFactory<Tour, Integer>("idtour"));
		tcClient_idclient.setCellValueFactory(new PropertyValueFactory<Tour, Integer>("client_idclient"));
		tcName_of_tour.setCellValueFactory(new PropertyValueFactory<Tour, String>("name_of_tour"));
		tcPrice_of_tour.setCellValueFactory(new PropertyValueFactory<Tour, Float>("price_of_tour"));
		tcKind_of_transport.setCellValueFactory(new PropertyValueFactory<Tour, String>("kind_of_transport"));
		tcPoint_of_depature.setCellValueFactory(new PropertyValueFactory<Tour, String>("point_of_depature"));
		tcNumber_of_tour.setCellValueFactory(new PropertyValueFactory<Tour, Date>("number_of_tour"));
		
		tvTour.setItems(FXCollections.observableArrayList(db.getAllTour()));
		showTourDetails(null);
		
		tvTour.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->
		{
			showTourDetails(newValue);
		});
			tcIduser.setCellValueFactory(new PropertyValueFactory<User, Integer>("iduser"));
			tcPosition.setCellValueFactory(new PropertyValueFactory<User, String>("position"));
			tcName.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
			tcLogin.setCellValueFactory(new PropertyValueFactory<User, String>("login"));
//			if (db.userAuth.getPosition().equals("admin"))
				tcPassword.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
			
			tvUser.setItems(FXCollections.observableArrayList(db.getAllUser()));
			showUserDetails(null);
			
			tvUser.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->
			{
				showUserDetails(newValue);
			});
	}
	
	@FXML TextField tfBackUpCopyName;
	
	@FXML
	private void handleCreateBackUpCopy() throws InterruptedException
	{
		if (db.userAuth.getPosition().equals("admin") && !tfBackUpCopyName.getText().trim().equals(""))
		{
			db.userAuth.createBackUpCopy(tfBackUpCopyName.getText().trim());
		}
		else
		{
			String errorMessage = "You have to have position admin or invalid fields";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
		}
			
	}
	
	@FXML
	private void handleRestoreBackUpCopy() throws InterruptedException
	{
		if (db.userAuth.getPosition().equals("admin") && !tfBackUpCopyName.getText().trim().equals(""))
		{
			db.userAuth.restoreBackUpCopy(tfBackUpCopyName.getText().trim());
		}
		else
		{
			String errorMessage = "You have to have position admin or invalid fields";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
		}
	}
	
	private void showClientDetails(Client cl)
	{
		if (cl != null)
		{
			tfIdClient.setText(Integer.toString(cl.getIdclient()));
			tfFirstName.setText(cl.getFirst_name());
			tfLastName.setText(cl.getLast_name());
		}
		else
		{
			tfIdClient.setText("");
			tfFirstName.setText("");
			tfLastName.setText("");
		}
	}
	
	@FXML
	private void handleNewClient() throws SQLException {
		if (isInputValidClient()) {
			db.newClient(tfFirstName.getText(), tfLastName.getText());
		}
		tvClient.setItems(FXCollections.observableArrayList(db.getAllClient()));
	}
	
	private boolean isInputValidClient()
	{
		String errorMessage = "";
		if (tfFirstName.getText() == null || tfFirstName.getText().length() == 0) {
			errorMessage += "No valid first name!\n";
		}
		if (tfLastName.getText() == null || tfLastName.getText().length() == 0) {
			errorMessage += "No valid last name!\n";
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
			return false;
		}
	}
	
	@FXML
	private void handleDeleteClient() throws NumberFormatException, SQLException
	{
		if (tfIdClient.getText() != null)
			db.deleteClient(new Integer(tfIdClient.getText()));
		else
		{
			String errorMessage = "Выберете элемент";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
		}
		initialize();
	}
	
	@FXML 
	private void handleEditClient() throws NumberFormatException, SQLException
	{
		if (tfIdClient.getText() != null)
			db.editClient(new Integer((tfIdClient.getText())), tfFirstName.getText(), tfLastName.getText());
		else
		{
			String errorMessage = "Выберете элемент";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
		}
		initialize();
	}
	
	@FXML private TableView<Locality> tvLocality;
	@FXML private TableColumn<Locality, Integer> tcIdlocality;
	@FXML private TableColumn<Locality, Integer> tcTour_idtour;
	@FXML private TableColumn<Locality, String> tcLocality_name;
	@FXML private TableColumn<Locality, String> tcCountry_of_location;
	@FXML private TextField tfIdlocality;
	@FXML private TextField tfTour_idtour;
	@FXML private TextField tfLocality_name;
	@FXML private TextField tfCountry_of_location;
	
	private void showLocalityDetails(Locality lo)
	{
		if (lo != null)
		{
			tfIdlocality.setText(Integer.toString(lo.getIdlocality()));
			tfTour_idtour.setText(Integer.toString(lo.getTour_idtour()));
			tfLocality_name.setText(lo.getLocality_name());
			tfCountry_of_location.setText(lo.getCountry_of_location());
		}
		else
		{
			tfIdlocality.setText("");
			tfTour_idtour.setText("");
			tfLocality_name.setText("");
			tfCountry_of_location.setText("");
		}
	}
	
	@FXML
	private void handleNewLocality() throws SQLException
	{
		if (isInputValidLocality()) {
			db.newLocality(new Integer(tfTour_idtour.getText()), tfLocality_name.getText(), tfCountry_of_location.getText());
		}
		tvLocality.setItems(FXCollections.observableArrayList(db.getAllLocality()));
	}
	
	private boolean isInputValidLocality()
	{
		String errorMessage = "";
		if (tfTour_idtour.getText() == null || tfTour_idtour.getText().length() == 0) {
			errorMessage += "No valid tfTour_idtour!\n";
		}
		if (tfLocality_name.getText() == null || tfLocality_name.getText().length() == 0) {
			errorMessage += "No valid tfLocality_name!\n";
		}
		if (tfCountry_of_location.getText() == null || tfCountry_of_location.getText().length() == 0) {
			errorMessage += "No valid tfCountry_of_location!\n";
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
			return false;
		}
	}
	
	@FXML
	private void handleDeleteLocality() throws SQLException
	{
		if (tfIdlocality.getText() != null)
			db.deleteLocality(new Integer(tfIdlocality.getText()));
		else
		{
			String errorMessage = "Выберете элемент";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
		}
		initialize();
	}

	@FXML
	private void handleEditLocality() throws SQLException
	{
		if (tfIdlocality.getText() != null)
			db.editLocality(new Integer((tfIdlocality.getText())), new Integer(tfTour_idtour.getText()), tfLocality_name.getText(), 
					tfCountry_of_location.getText());
		else
		{
			String errorMessage = "Выберете элемент";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
		}
		initialize();
	}
	/*hotel_view*/
	@FXML private TableView<Hotel> tvHotel;
	@FXML private TableColumn<Hotel, Integer> tcIdHotel;
	@FXML private TableColumn<Hotel, Integer> tcLocality_idLocality;
	@FXML private TableColumn<Hotel, String> tcHotel_name;
	@FXML private TableColumn<Hotel, Integer> tcNumber_of_stars;
	@FXML private TextField tfIdHotel;
	@FXML private TextField tfLocality_idLocality;
	@FXML private TextField tfHotel_name;
	@FXML private TextField tfNumber_of_stars;
	
	private void showHotelDetails(Hotel ho)
	{
		if (ho != null)
		{
			tfIdHotel.setText(Integer.toString(ho.getIdhotel()));
			tfLocality_idLocality.setText(Integer.toString(ho.getLocality_idlocality()));
			tfNumber_of_stars.setText(Integer.toString(ho.getNumber_of_stars()));
			tfHotel_name.setText(ho.getHotel_name());
			
		}
		else
		{
			tfIdHotel.setText("");
			tfLocality_idLocality.setText("");
			tfHotel_name.setText("");
			tfLocality_idLocality.setText("");
		}
	}
	
	@FXML
	private void handleNewHotel() throws SQLException
	{
		if (isInputValidHotel())
		{
			db.newHotel(new Integer(tfLocality_idLocality.getText()), tfHotel_name.getText(), 
					new Integer(tfNumber_of_stars.getText()));
		}
		else
		{
			String errorMessage = "Выберете элемент";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
		}
		initialize();
	}
	
	private boolean isInputValidHotel()
	{
		String errorMessage = "";
		if (tfLocality_idLocality.getText() == null || tfLocality_idLocality.getText().length() == 0)
		{
			errorMessage += "No valid tfLocality_idLocality!\n";
		}
		if (tfHotel_name.getText() == null || tfHotel_name.getText().length() == 0)
		{
			errorMessage += "No valid tfHotel_name!\n";
		}
		if (tfNumber_of_stars.getText() == null || tfNumber_of_stars.getText().length() == 0)
		{
			errorMessage += "No valid tfNumber_of_stars!\n";
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
			return false;
		}
	}
	
	@FXML
	private void handleDeleteHotel() throws SQLException
	{
		if (tfIdHotel.getText() != null)
			db.deleteHotel(new Integer(tfIdHotel.getText()));
		else
		{
			String errorMessage = "Выберете элемент";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
		}
		initialize();
	}
	
	@FXML
	private void handleEditHotel() throws NumberFormatException, SQLException
	{
		if (tfIdHotel.getText() != null)
			db.editLocality(new Integer((tfIdHotel.getText())), new Integer(tfLocality_idLocality.getText()), tfHotel_name.getText(), 
					tfNumber_of_stars.getText());
		else
		{
			String errorMessage = "Выберете элемент";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
		}
		initialize();
	}
	
	@FXML private TableView<Tour> tvTour;
	@FXML private TableColumn<Tour,Integer> tcIdtour;
	@FXML private TableColumn<Tour, Integer> tcClient_idclient;
	@FXML private TableColumn<Tour, String> tcName_of_tour;
	@FXML private TableColumn<Tour, Float> tcPrice_of_tour;
	@FXML private TableColumn<Tour, String> tcKind_of_transport;
	@FXML private TableColumn<Tour, String> tcPoint_of_depature;
	@FXML private TableColumn<Tour, Date> tcNumber_of_tour;
	@FXML private TextField tfIdtour;
	@FXML private TextField tfClient_idclient;
	@FXML private TextField tfName_of_tour;
	@FXML private TextField tfPrice_of_tour;
	@FXML private TextField tfKind_of_transport;
	@FXML private TextField tfPoint_of_depature;
	@FXML private TextField tfNumber_of_tour;
	
	private void showTourDetails(Tour to)
	{
		if (to != null)
		{
			tfIdtour.setText(Integer.toString(to.getIdtour()));
			tfClient_idclient.setText(Integer.toString(to.getClient_idclient()));
			tfName_of_tour.setText(to.getName_of_tour());
			tfPrice_of_tour.setText(Float.toString(to.getPrice_of_tour()));
			tfKind_of_transport.setText(to.getKind_of_transport());
			tfPoint_of_depature.setText(to.getPoint_of_depature());
			tfNumber_of_tour.setText(df.format(to.getNumber_of_tour()).toString());
		}
		else
		{
			tfIdtour.setText("");
			tfClient_idclient.setText("");
			tfName_of_tour.setText("");
			tfPrice_of_tour.setText("");
			tfKind_of_transport.setText("");
			tfPoint_of_depature.setText("");
			tfNumber_of_tour.setText("");
		}
	}

	@FXML
	private void handleNewTour() throws SQLException
	{
		if (isInputValidTour()) {
			try {
				db.newTour(new Integer(tfClient_idclient.getText()),tfName_of_tour.getText(), new Float(tfPrice_of_tour.getText()),tfKind_of_transport.getText(),
						tfPoint_of_depature.getText(), 
						new Date(df.parse(tfNumber_of_tour.getText()).getTime()));
			} catch (ParseException e) {
				System.out.println("failed parse date");
				e.printStackTrace();
			}
		}
		tvTour.setItems(FXCollections.observableArrayList(db.getAllTour()));
	}
	
	private boolean isInputValidTour()
	{
		String errorMessage = "";
		if (tfName_of_tour.getText() == null || tfName_of_tour.getText().length() == 0)
		{
			errorMessage += "No valid tfName_of_tour!\n";
		}
		if (tcClient_idclient.getText() == null || tcClient_idclient.getText().length() == 0)
		{
			errorMessage += "No valid tcClient_idclient!\n";
		}
		if (tfPrice_of_tour.getText() == null || tfPrice_of_tour.getText().length() == 0)
		{
			errorMessage += "No valid tfPrice_of_tour!\n";
		}
		if (tfKind_of_transport.getText() == null || tfKind_of_transport.getText().length() == 0)
		{
			errorMessage += "No valid tfKind_of_transport!\n";
		}
		if (tfPoint_of_depature.getText() == null || tfPoint_of_depature.getText().length() == 0)
		{
			errorMessage += "No valid tfPoint_of_depature!\n";
		}
		if (tfNumber_of_tour.getText() == null || tfNumber_of_tour.getText().length() == 0)
		{
			errorMessage += "No valid tfPoint_of_depature!\n";
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
			return false;
		}
	}

	@FXML
	private void handleDeleteTour() throws SQLException
	{
		if (tfIdtour.getText() != null)
			db.deleteTour(new Integer(tfIdtour.getText()));
		else
		{
			String errorMessage = "Выберете элемент";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
		}
		initialize();
	}
	
	@FXML
	private void handleEditTour() throws SQLException, NumberFormatException, ParseException
	{
		if (tfIdHotel.getText() != null) {
			try {
			db.editTour(new Integer((tfIdtour.getText())), new Integer(tfClient_idclient.getText()), tfName_of_tour.getText(),
					new Float(tfPrice_of_tour.getText()), 
					tfKind_of_transport.getText(), tfPoint_of_depature.getText(), 
					new Date(df.parse(tfNumber_of_tour.getText()).getTime()));
			}
			catch(ParseException e)
			{
				System.out.println("failed parse date");
				e.printStackTrace();
			}
		}
		else
		{
			String errorMessage = "Выберете элемент";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
		}
		initialize();
	}
	
	@FXML private TableView<User> tvUser;
	@FXML private TableColumn<User, Integer> tcIduser;
	@FXML private TableColumn<User, String> tcPosition;
	@FXML private TableColumn<User, String> tcName;
	@FXML private TableColumn<User, String> tcLogin;
	@FXML private TableColumn<User, String> tcPassword;
	@FXML private TextField tfIduser;
	@FXML private TextField tfPosition;
	@FXML private TextField tfName;
	@FXML private TextField tfLogin;
	@FXML private TextField tfPassword;
	
	private void showUserDetails(User us)
	{
		if (us != null && db.userAuth.getPosition().equals("admin"))
		{
			tfIduser.setText(Integer.toString(us.getIduser()));
			tfPosition.setText(us.getPosition());
			tfName.setText(us.getName());
			tfLogin.setText(us.getLogin());
			tfPassword.setText(us.getPassword());
		}
		else
		{
			tfIduser.setText("");
			tfPosition.setText("");
			tfName.setText("");
			tfLogin.setText("");
			tfPassword.setText("");
		}
	}
	
	@FXML
	private void handleNewUser() throws SQLException
	{
		if (isInputValidUser()) {
			db.newUser(tfPosition.getText(), tfName.getText(), tfLogin.getText(), tfPassword.getText());
		}
		tvUser.setItems(FXCollections.observableArrayList(db.getAllUser()));
	}
	
	private boolean isInputValidUser()
	{
		String errorMessage = "";
		if (tfPosition.getText() == null || tfPosition.getText().length() == 0)
		{
			errorMessage += "No valid tfPosition!\n";
		}
		if (tfName.getText() == null || tfName.getText().length() == 0)
		{
			errorMessage += "No valid tfName!\n";
		}
		if (tfLogin.getText() == null || tfLogin.getText().length() == 0)
		{
			errorMessage += "No valid tfLogin!\n";
		}
		if (tfPassword.getText() == null || tfPassword.getText().length() == 0)
		{
			errorMessage += "No valid tfPassword!\n";
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
			return false;
		}
	}

	@FXML
	private void handleDeleteUser() throws SQLException
	{
		if (tfIduser.getText() != null && db.userAuth.getPosition().equals("admin"))
			db.deleteUser(new Integer(tfIduser.getText()));
		else
		{
			String errorMessage = "Выберете элемент";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields or you have to have the position admin");
			alert.setContentText(errorMessage);
			alert.showAndWait();
		}
		initialize();
	}

	@FXML
	private void handleEditUser() throws SQLException
	{
		if (tfIduser.getText() != null && db.userAuth.getPosition().equals("admin"))
			db.editUser(new Integer(tfIduser.getText()), tfPosition.getText(), tfName.getText(), tfLogin.getText(),
					tfPassword.getText());
		else
		{
			String errorMessage = "Выберете элемент";
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields or you have to have the position admin");
			alert.setContentText(errorMessage);
			alert.showAndWait();
		}
		initialize();
	}

}
