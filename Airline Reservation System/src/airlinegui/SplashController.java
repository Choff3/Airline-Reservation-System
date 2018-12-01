package airlinegui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SplashController implements Initializable{

	@FXML
	private AnchorPane rootPane;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		new SplashScreen().start();
		
	}
	
	class SplashScreen extends Thread{
		
		public void run() {
			
			try {
				Thread.sleep(5000);
				
				Platform.runLater(new Runnable() {
					
					public void run() {
					Parent root = null;
					try {
						root = FXMLLoader.load(getClass().getResource("Login.fxml"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Stage primaryStage = new Stage();
					primaryStage.setTitle("Flight Application");
					primaryStage.setScene(new Scene(root));
					primaryStage.show();
					
					rootPane.getScene().getWindow().hide();
					}
				});
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	

}
