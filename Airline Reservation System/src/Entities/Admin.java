package Entities;
public class Admin extends User {

	private int employeeID;
	private static int empCount;
	
	//this creates a flight object
	Flight myFlight = new Flight();
	
	public Admin(String firstname, String lastname, String address, int zip, String state, String username,
			String password, String email, String ssn, String question, String answer) {
		super(firstname, lastname, address, zip, state, username, password, email, ssn, question, answer);
	}
	public int getId() {
		return this.employeeID;
	}
	public void insertDB() {
		this.employeeID = ++empCount;
		super.insertDB("employees",this.employeeID);
	}
	
	//gives admin the ability to add/insert new flights
	protected void addFlight() {
		myFlight.insertDB();
	}
	
	//admin takes a flight number and uses method to select a flight to update
	protected void updateFlight(int flightNumber,String originCity, String destinationCity, int takeoffTime, int arrivalTime) {
		myFlight.updateDB(flightNumber, originCity, destinationCity, takeoffTime, arrivalTime);
		
	}
	
	//admin takes a flight number and uses method to select a flight to delete
	protected void deleteFlight(int flightNumber) {
		myFlight.deleteDB(flightNumber);
		
	}
	
	
}
