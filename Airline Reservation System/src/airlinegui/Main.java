package airlinegui;

import java.io.IOException;
import java.util.ArrayList;

import Entities.Database_Select;
import Entities.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application{
	
	public static boolean isSplashLoaded;

	public void start(Stage primaryStage) throws Exception{
	
	Parent root = FXMLLoader.load(getClass().getResource("Splash.fxml"));
	primaryStage.setTitle("Flight Application");
	primaryStage.setScene(new Scene(root));
	primaryStage.initStyle(StageStyle.UNDECORATED);
	
	primaryStage.show();
		
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
	//initialize all data structures
	
	/*
	Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
	primaryStage.setTitle("Flight Application");
	primaryStage.setScene(new Scene(root));
	primaryStage.show();
	 */
	
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		//LauncherImpl.launchApplication(Main.class, Splash.class, args);
		launch(args);
	}

}
