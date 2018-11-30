package airlinegui;

import Entities.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class BookedFlightsController {
	
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
    	flightslist.addAll(LoginController.loggedIn.getBooked());
    	
    	return flightslist;
    }
    
    public void selectFlight() {
    	
    	ObservableList<Flight> cellSelected;
    	cellSelected = table.getSelectionModel().getSelectedItems();
    	this.selected = cellSelected.get(0);
    	
    }
    @FXML
    public void delete() {
    	try {	
    		LoginController.loggedIn.deleteBooking(selected);
    	}
    	catch(Exception e) {
    		AlertBox.display("Error", "Please select a flight.");
    	}
    }
	
}
