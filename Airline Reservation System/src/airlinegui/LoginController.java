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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	TextField tuname;
	@FXML
	TextField tpword;
	
	public void register() throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
		Stage regwindow = new Stage();
		regwindow.setScene(new Scene(root,650,500));
		regwindow.show();
		
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
	
	public void customerLogin(Customer c) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("CustomerScreen.fxml"));
		Stage regwindow = new Stage();
		regwindow.setScene(new Scene(root,650,500));
		regwindow.show();
	}
	
	public void adminLogin(Admin a) {
		System.out.println("admin is logged in "+a);
	}
	
}
