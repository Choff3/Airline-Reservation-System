package Entities;

public class Customer extends User {
	
	public Customer(String firstname, String lastname, String address, int zip, String state, String username,
			String password, String email, String ssn, String question, String answer) {
		super(firstname, lastname, address, zip, state, username, password, email, ssn, question, answer);
	}
	public Customer(String firstname, String lastname, String address, int zip, String state, String username,
			String password, String email, String ssn, String question, String answer, int id) {
		super(firstname, lastname, address, zip, state, username, password, email, ssn, question, answer, id);
	}
	public void insertDB() {
		super.insertDB("CUSTOMERS");
	}
}