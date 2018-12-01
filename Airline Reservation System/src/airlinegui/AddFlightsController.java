package airlinegui;

import java.io.IOException;

import Entities.Flight;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddFlightsController {
	@FXML
	TextField toCity;
	@FXML
	TextField tdCity;
	@FXML
	TextField ttTime;
	@FXML
	TextField taTime;
	@FXML
	TextField tAirline;
	@FXML
	TextField tDate;
	
	public void addFlight() {
		
		try {
		String oCity = toCity.getText();
		String dCity = tdCity.getText();
		int tTime = Integer.parseInt(ttTime.getText());
		int aTime = Integer.parseInt(taTime.getText());
		String airline = tAirline.getText();
		String date = tDate.getText();
		
		Flight f = new Flight(oCity, dCity, tTime, aTime, airline, date);
		f.insertDB();
		Entities.Database_Select.FlightList.add(f);
		AlertBox.display("Success", "The Flight has been added to the database.\n"+f);
		
		}
		catch(Exception e) {
			AlertBox.display("Error", "Check all fields and try again.");
		}
	}
	
	public void logout() throws IOException {
		Stage stage = (Stage) toCity.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
	    stage.setScene(new Scene(root));
	}
    
    public void customerMenu() throws IOException {
		Stage stage = (Stage) toCity.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("CustomerScreen.fxml"));
	    stage.setScene(new Scene(root));
	}
    
    public void adminMenu() throws IOException {
		Stage stage = (Stage) toCity.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("AdminScreen.fxml"));
	    stage.setScene(new Scene(root));
	}
	
}
