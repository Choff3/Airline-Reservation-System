package Entities;
public class Admin extends User {
	
	//this creates a flight object
	Flight myFlight;
	
	public Admin(String firstname, String lastname, String address, int zip, String state, String username,
			String password, String email, String ssn, String question, String answer) {
		super(firstname, lastname, address, zip, state, username, password, email, ssn, question, answer);
	}
	
	public Admin(String firstname, String lastname, String address, int zip, String state, String username,
			String password, String email, String ssn, String question, String answer, int id) {
		super(firstname, lastname, address, zip, state, username, password, email, ssn, question, answer, id);
	}
	
	public void insertDB() {
		super.insertDB("employees");
	}
	
	//gives admin the ability to add/insert new flights
	protected void addFlight() {
		myFlight.insertDB();
	}
	
	//admin takes a flight number and uses method to select a flight to update
	protected void updateFlight(int flightNumber,String originCity, String destinationCity, int takeoffTime, int arrivalTime) {
		myFlight.updateDB(flightNumber, originCity, destinationCity, takeoffTime, arrivalTime);
		
	}
	
}
