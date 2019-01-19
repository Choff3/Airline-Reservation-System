package Entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Flight {
	private static int flightCount;
	private int flightNumber;
	private String originCity;
	private String destinationCity;
	private int takeoffTime;
	private int arrivalTime;
	private String airline;
	private String date;
	
	private String stTime;
	private String saTime;
	//string version of time for display purposes
	
	public Flight(String originCity, String destinationCity, int takeoffTime, int arrivalTime,String airline, String date) {
		this.flightNumber=++flightCount;
		this.originCity = originCity;
		this.destinationCity = destinationCity;
		this.takeoffTime = takeoffTime;
		this.arrivalTime = arrivalTime;
		this.airline = airline;
		this.date = date;
		this.stTime = timeToString(takeoffTime);
		this.saTime = timeToString(arrivalTime);
	}
	
	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getStTime() {
		return stTime;
	}

	public void setStTime(String stTime) {
		this.stTime = stTime;
	}

	public String getSaTime() {
		return saTime;
	}

	public void setSaTime(String saTime) {
		this.saTime = saTime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOriginCity() {
		return originCity;
	}
	public void setOriginCity(String originCity) {
		this.originCity = originCity;
	}
	public String getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	public int getTakeoffTime() {
		return takeoffTime;
	}
	public void setTakeoffTime(int takeoffTime) {
		this.takeoffTime = takeoffTime;
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String timeToString(int time) {
		int hour = (time/100);
		String ampm;
		if(hour>=12) {
			hour-=12;
			ampm="pm";
		}
		else
			ampm="am";
		if((time%100)==0)
			return hour+":"+"00"+ampm;
		return hour+":"+(time%100)+ampm;
	}//method for returning a time int as a String
	public String toString() {
		return "Flight number "+flightNumber+
				" departs from "+originCity+
				" at "+timeToString(takeoffTime)+
				" and arrives in "+destinationCity+
				" at "+timeToString(arrivalTime)+".";
	}//toString method
	
	public void insertDB() {	//method for inserting flights into the database
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection connection = DriverManager.getConnection("jdbc:mysql://cisproject.cjh80q7hgyjz.us-east-2.rds.amazonaws.com:3306/Flight Database", "cis2019", "GSUcis2019!!");
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into FLIGHTS values("+this.flightNumber+",'"+this.originCity+"','"+this.destinationCity+"',"+this.takeoffTime+","+this.arrivalTime+",'"+this.airline+"','"+this.date+"')");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void updateDB(int flightNumber, String originCity, String destinationCity, int takeoffTime, int arrivalTime) {	//method for updating flight information in the database
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://cisproject.cjh80q7hgyjz.us-east-2.rds.amazonaws.com:3306/Flight Database", "cis2019", "GSUcis2019!!");
			PreparedStatement statement = con.prepareStatement ("UPDATE FLIGHTS SET O_City = ?, D_City = ?,"
					+ "T_Time = ?, A_Time = ? WHERE F_Number = ?");
			statement.setString(1, this.getOriginCity());
			statement.setString(2, this.getDestinationCity());
			statement.setInt(3, this.getTakeoffTime());
			statement.setInt(4, this.getArrivalTime());
			statement.setInt(5, this.flightNumber);
			statement.setString(6, this.getDate());
			statement.executeUpdate();
			System.out.println("Flight info updated successfully.");
			con.close();
		} catch (SQLException e) {
			System.out.print("Error");
		}finally {
			//TODO close connection
		}
	}
	
	public void deleteDB() {	//method for deleting flights from the database
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://cisproject.cjh80q7hgyjz.us-east-2.rds.amazonaws.com:3306/Flight Database", "cis2019", "GSUcis2019!!");
			PreparedStatement statement = con.prepareStatement("delete from FLIGHTS where F_Number = ?");
			statement.setInt(1, this.flightNumber);
			statement.executeUpdate();
			System.out.println("Flight deleted successfully.");
			con.close();
		} catch (SQLException e) {
			System.out.print("Error");
	
		}
	}
	
	protected void searchDB(String originCity, String destinationCity,int takeOffTime, int arrivalTime) {	//method for searching flights in the database
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://cisproject.cjh80q7hgyjz.us-east-2.rds.amazonaws.com:3306/Flight Database", "cis2019", "GSUcis2019!!");
			PreparedStatement statement = con.prepareStatement("Select * from FLIGHTS WHERE O_City = ?, D_City = ?,  T_Time = ?, A_Time = ?");
			statement.setString(1, this.getOriginCity());
			statement.setString(2, this.getDestinationCity());
			statement.setInt(3, this.getTakeoffTime());
			statement.setInt(4, this.getArrivalTime());
			statement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			System.out.print("Error");
		}finally {
			//TODO close connection
		}
	}

	public int getFlightNumber() {
		return this.flightNumber;
	}
}