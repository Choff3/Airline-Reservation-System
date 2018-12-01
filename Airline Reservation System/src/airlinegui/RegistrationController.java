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
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationController {
	
	@FXML
	TextField tfname;
	@FXML
	TextField tlname;
	@FXML
	TextField taddress;
	@FXML
	TextField tstate;
	@FXML
	TextField tzip;
	@FXML
	TextField temail;
	@FXML
	TextField tssn;
	@FXML
	TextField tuname;
	@FXML
	PasswordField tpword;
	@FXML
	TextField tquestion;
	@FXML
	TextField tanswer;
	
	@FXML
	CheckBox admin;
	
	public void register() {
		
		ArrayList<User> users = new ArrayList<User>();
		users.addAll(Database_Select.getAdmins());
		users.addAll(Database_Select.getCustomers());
		boolean taken = false;
		
		for(int i = 0; i<users.size();i++) {
			String name = users.get(i).getUsername();
			if(tuname.getText().equals(name))
				taken = true;
		}
		
		if(taken)
			AlertBox.display("Error", "Username has already been taken.");
		else {
		
		try {
		String fname = tfname.getText();
		String lname = tlname.getText();
		String address = taddress.getText();
		String state = tstate.getText();
		int zip = Integer.parseInt(tzip.getText());
		String email = temail.getText();
		String ssn = tssn.getText();
		String uname = tuname.getText();
		String pword = tpword.getText();
		String question = tquestion.getText();
		String answer = tanswer.getText();
		
		if(admin.isSelected()) {
			Admin a = new Admin(fname,lname,address,zip,state,uname,
						pword,email,ssn,question,answer);
			a.insertDB();
			Database_Select.adminList.add(a);
			AlertBox.display("Success", "Your administrator account has been created.");
			logout();
		}
		else {
			Customer c = new Customer(fname,lname,address,zip,state,uname,
					pword,email,ssn,question,answer);
			c.insertDB();
			Database_Select.customerList.add(c);
			AlertBox.display("Success", "Your customer account has been created.");
			logout();
		}
		}
		catch(Exception e) {
			AlertBox.display("Error", "Check all fields and try again.");
		}
		}
	}
	
	public void logout() throws IOException {
		Stage stage = (Stage) admin.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
	    stage.setScene(new Scene(root));
	}
	
}
