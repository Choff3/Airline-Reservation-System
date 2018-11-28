package airlinegui;
import Entities.Admin;
import Entities.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
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
	TextField tpword;
	@FXML
	TextField tquestion;
	@FXML
	TextField tanswer;
	
	@FXML
	CheckBox admin;
	
	
	
	public void register() {
		
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
		}
		else {
			Customer c = new Customer(fname,lname,address,zip,state,uname,
					pword,email,ssn,question,answer);
			c.insertDB();
		}
		close();
		}
		catch(Exception e) {
			AlertBox.display("Error", "Check all fields and try again.");
		}
	}
	
	public void close() {
		Stage current = (Stage) tfname.getScene().getWindow();
		current.close();
	}
	
}
