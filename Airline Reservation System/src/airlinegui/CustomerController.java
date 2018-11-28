package airlinegui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CustomerController {

	public void viewFlights() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("FlightsScreen.fxml"));
		Stage regwindow = new Stage();
		regwindow.setScene(new Scene(root,650,500));
		regwindow.show();
	}
	
	public void viewBooked() {
		System.out.println("Viewing Booked");
	}
	
}
