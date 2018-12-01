package airlinegui;

import java.io.IOException;
import java.util.ArrayList;

import Entities.Admin;
import Entities.Customer;
import Entities.Database_Select;
import Entities.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController{

	@FXML
	TextField tuname;
	@FXML
	PasswordField tpword;
	
	@FXML
	private AnchorPane root;
	
	public static AnchorPane rootP;
	
	static User loggedIn;
	
	public void register() throws Exception {
		Stage stage = (Stage) tuname.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
	    stage.setScene(new Scene(root));
	}
	
	public void login() throws IOException {
		
		String uname = tuname.getText();
		String pword = tpword.getText();
		
		ArrayList<User> users = new ArrayList();
		users.addAll(Database_Select.getCustomers());
		users.addAll(Database_Select.getAdmins());
		boolean valid = false;
		
		for(int i = 0; i<users.size();i++) {
			
			User u = users.get(i);
			String un = users.get(i).getUsername();
			String p = users.get(i).getPassword();
			
			if(un.equals(uname) && p.equals(pword) && (u instanceof Admin)) {
				adminLogin((Admin) u);
				valid = true;
			}
			else if(un.equals(uname) && p.equals(pword) && (u instanceof Customer)) {
				customerLogin((Customer) u);
				valid = true;
			}
			
		}
		
		if(!valid)
			AlertBox.display("Incorrect Username/Pasword", "Please check your username and password and try again.");
		
	}
	
	public void forgotPassword() throws IOException {
		Stage stage = (Stage) tuname.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("PasswordResetScreen.fxml"));
	    stage.setScene(new Scene(root));
	}
	
	
	public void customerLogin(Customer c) throws IOException {
		loggedIn = (Customer) c;
		Stage stage = (Stage) tuname.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("CustomerScreen.fxml"));
	    stage.setScene(new Scene(root));
	}
	
	public void adminLogin(Admin a) throws IOException {
		loggedIn = (Admin) a;
		Stage stage = (Stage) tuname.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("AdminScreen.fxml"));
	    stage.setScene(new Scene(root));
	}
	
}
