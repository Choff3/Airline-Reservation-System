package airlinegui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CustomerController {

	//@FXML
	//static Label userLabel = new Label(LoginController.loggedIn.toString());
	
	public void viewFlights() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("FlightsScreen.fxml"));
		Stage regwindow = new Stage();
		regwindow.setScene(new Scene(root,650,500));
		regwindow.show();
	}
	
	public void viewBooked() throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("BookedFlightsScreen.fxml"));
		Stage regwindow = new Stage();
		regwindow.setScene(new Scene(root,650,500));
		regwindow.show();
		
	}
	
}
