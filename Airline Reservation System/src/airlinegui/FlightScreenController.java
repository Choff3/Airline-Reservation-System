package airlinegui;

import Entities.Database_Select;
import Entities.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FlightScreenController {

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
        table.setItems(getFlights());
    }
    
    public ObservableList<Flight> getFlights(){
    	ObservableList<Flight> flightslist = FXCollections.observableArrayList();
    	flightslist.addAll(Database_Select.getFlights());
    	
    	return flightslist;
    }
    
    public void book() {
    	System.out.println("Flight Booked");
    }
	
}
