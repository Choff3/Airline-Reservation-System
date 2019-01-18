package Entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

public class Booking {

	private int UserID;
	private int FlightID;
	User user;
	Flight flightBooked;
	
	public Booking(int ID, int fNum) {
		this.UserID = ID;
		this.FlightID = fNum;
	}
	
	public void updateBookings() {
		
		ArrayList<Flight> flights = Database_Select.getFlights();
		ArrayList<Customer> customers = Entities.Database_Select.getCustomers();
		ArrayList<Admin> admins= Entities.Database_Select.getAdmins();
		ArrayList<User> users = new ArrayList<User>();
		users.addAll(customers);
		users.addAll(admins);
		
		for(int i = 0; i<users.size();i++) {
			User u = users.get(i);
			if(u.getID()==this.UserID)
				this.user = u;
		}
		
		for(int i = 0; i<flights.size();i++) {
			Flight f = flights.get(i);
			if(f.getFlightNumber()==this.FlightID)
				this.flightBooked = f;
		}
		
	}
	
	public Booking(Customer c, Flight f) {
		this.user = (Customer) c;
		this.flightBooked = f;
		this.FlightID = f.getFlightNumber();
		this.UserID = c.getID();
	}
	
	public Booking(Admin a, Flight f) {
		this.user = (Admin) a;
		this.flightBooked = f;
		this.FlightID = f.getFlightNumber();
		this.UserID = a.getID();
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public int getFlightID() {
		return FlightID;
	}

	public void setFlightID(int flightID) {
		FlightID = flightID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Flight getFlightBooked() {
		return flightBooked;
	}

	public void setFlightBooked(Flight flightBooked) {
		this.flightBooked = flightBooked;
	}
	
	public static void deleteDB(int userID, int flightID) {
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Flight Database", "root", "GSUcis2020!!");
			PreparedStatement statement = con.prepareStatement("delete from Bookings where F_Num = ? AND User_ID = ?");
			statement.setInt(1, flightID);
			statement.setInt(2, userID);
			statement.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//TODO close connection
		}
		
	}
	
	protected void insertDB() { //method for inserting bookings into the database
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Flight Database", "root", "GSUcis2020!!");
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into Bookings values("
					+ this.UserID +","+this.FlightID+")");
			connection.close();
		} 
		catch (Exception e) {
			System.out.println("Booking insertion error");
		}

	}
	
	public String toString() {
		
		return "User ID: "+this.UserID+" booked Flight Number: "+this.FlightID;
		
	}
	
	
}
