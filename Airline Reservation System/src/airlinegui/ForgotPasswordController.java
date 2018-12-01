package airlinegui;

import java.io.IOException;
import java.util.ArrayList;

import Entities.Database_Select;
import Entities.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ForgotPasswordController {

	private User selected;
	@FXML
	TextField tuname;
	@FXML
	TextField tanswer;
	
	public void getQuestion() {
		
		ArrayList<User> users = new ArrayList<User>();
		users.addAll(Database_Select.getAdmins());
		users.addAll(Database_Select.getCustomers());
		
		String uname = tuname.getText();
		boolean found = false;
		
		
		for(int i = 0; i<users.size();i++) {
			if(users.get(i).getUsername().equals(uname)) {
				selected=users.get(i);
				AlertBox.display("Security Question", selected.getQuestion());
				found = true;
				break;
			}
		}
		if(!found)
			AlertBox.display("Error", "Username not found.");
	}
	
	public void getPassword() {
		String answer = tanswer.getText();
		if(selected.getAnswer().equals(answer))
			AlertBox.display("Password Recovered", "Your password is: \n"+selected.getPassword());
		else
			AlertBox.display("Incorrect", "Your answer was incorrect.");
	}
	
	public void goBack() throws IOException {
		Stage stage = (Stage) tuname.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
	    stage.setScene(new Scene(root));
	}
	
}
