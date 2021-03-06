package airlinegui;

import java.io.IOException;
import java.util.ArrayList;

import Entities.Database_Select;
import Entities.Flight;
import Entities.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FlightScreenController {

	static User loggedIn;
	
	@FXML
	private TableView<Flight> table;
	
    @FXML
    private TableColumn<Flight, String> originColumn;

    @FXML
    private TableColumn<Flight, String> destinationColumn;

    @FXML
    private TableColumn<Flight, String> dateColumn;

    @FXML
    private TableColumn<Flight, String> takeoffColumn;
    
    @FXML
    private TableColumn<Flight, String> arrivalColumn;

    @FXML
    private TableColumn<Flight, String> airlineColumn;
    
    private Flight selected;
    
    @FXML
    void initialize() {

        originColumn.setCellValueFactory(
            new PropertyValueFactory<Flight,String>("originCity")
        );
        destinationColumn.setCellValueFactory(
            new PropertyValueFactory<Flight,String>("destinationCity")
        );
        dateColumn.setCellValueFactory(
            new PropertyValueFactory<Flight,String>("date")
        );
        takeoffColumn.setCellValueFactory(
            new PropertyValueFactory<Flight,String>("stTime")
        );
        arrivalColumn.setCellValueFactory(
            new PropertyValueFactory<Flight,String>("saTime")
        );
        airlineColumn.setCellValueFactory(
            new PropertyValueFactory<Flight,String>("airline")
        );
        table.setItems(getFlightsTable());
    }
    
    public ObservableList<Flight> getFlightsTable(){
    	ObservableList<Flight> flightslist = FXCollections.observableArrayList();
    	flightslist.addAll(Database_Select.getFlights());
    	
    	return flightslist;
    }
    
    public void selectFlight() {
    	
    	ObservableList<Flight> cellSelected;
    	cellSelected = table.getSelectionModel().getSelectedItems();
    	this.selected = cellSelected.get(0);
    	
    }
    @FXML
    public void book() {
    	try {
    		ArrayList<Flight> userFlights = new ArrayList<Flight>();
    		userFlights.addAll(LoginController.loggedIn.getBooked());
    		if(userFlights.contains(selected))
    			AlertBox.display("Error", "You have already booked that flight.");
    		else {
    			LoginController.loggedIn.book(selected);
    			AlertBox.display("Success", "The flight has been booked. \n"+selected);
    		}
    	}
    	catch(Exception e) {
    		AlertBox.display("Error", "Please select a flight.");
    	}
    }
    
    public void logout() throws IOException {
		Stage stage = (Stage) table.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
	    stage.setScene(new Scene(root));
	}
    
    public void mainMenu() throws IOException {
		Stage stage = (Stage) table.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("CustomerScreen.fxml"));
	    stage.setScene(new Scene(root));
	}
	
}
