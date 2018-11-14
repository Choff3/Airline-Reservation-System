
public class Customer extends User {

	private int customerID;
	private static int count;
	
	public Customer(String firstname, String lastname, String address, int zip, String state, String username,
			String password, String email, String ssn, String question, String answer) {
		super(firstname, lastname, address, zip, state, username, password, email, ssn, question, answer);
		customerID = ++count;
		this.insertDB("customers",this.customerID);//insert the customer into the database
	}

}
