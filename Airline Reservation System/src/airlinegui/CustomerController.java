package airlinegui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CustomerController implements Initializable{
	
	@FXML
	Label userLabel;
	
	public void viewFlights() throws IOException {
		Stage stage = (Stage) userLabel.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("FlightsScreen.fxml"));
	    stage.setScene(new Scene(root));
	}
	
	public void viewBooked() throws IOException {
		Stage stage = (Stage) userLabel.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("BookedFlightsScreen.fxml"));
	    stage.setScene(new Scene(root));
	}
	
	public void logout() throws IOException {
		Stage stage = (Stage) userLabel.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
	    stage.setScene(new Scene(root));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		userLabel.setText("Logged in: "+LoginController.loggedIn.toString());
	}
	
}
