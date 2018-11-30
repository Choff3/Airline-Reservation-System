package airlinegui;

import java.util.ArrayList;

import Entities.Database_Select;
import Entities.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	public void start(Stage primaryStage) throws Exception{
	
	Database_Select.setAdmins();
	Database_Select.setCustomers();
	Database_Select.setFlights();
	Database_Select.setBookings();
	
	for(int i = 0; i<Database_Select.getBookings().size(); i++) {
		Database_Select.getBookings().get(i).updateBookings();
	}
	
	ArrayList<User> users = new ArrayList<User>();
	users.addAll(Database_Select.getAdmins());
	users.addAll(Database_Select.getCustomers());
	
	for(int i = 0; i<users.size(); i++) {
		users.get(i).updateBookings();
	}
		
	Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
	primaryStage.setTitle("Flight Application");
	primaryStage.setScene(new Scene(root,650,500));
	primaryStage.show();
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
