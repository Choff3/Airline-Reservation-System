package Entities;

import java.util.ArrayList;

public class Customer extends User {

	private int customerID;
	private static int cusCount;
	private ArrayList<Flight> booked;
	
	public Customer(String firstname, String lastname, String address, int zip, String state, String username,
			String password, String email, String ssn, String question, String answer) {
		super(firstname, lastname, address, zip, state, username, password, email, ssn, question, answer);
	}
	public int getId() {
		return this.customerID;
	}
	public void insertDB() {
		this.customerID = ++cusCount;
		super.insertDB("customers",this.customerID);
	}
	public void book(Flight f) {
		this.booked.add(f);
	}
}
