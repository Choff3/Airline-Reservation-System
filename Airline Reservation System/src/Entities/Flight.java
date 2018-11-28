package Entities;
import java.sql.Connection;
import java.sql.DriverManager;
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
	
	public Flight(String originCity, String destinationCity, int takeoffTime, int arrivalTime,String airline, String date) {
		this.flightNumber=++flightCount;
		this.originCity = originCity;
		this.destinationCity = destinationCity;
		this.takeoffTime = takeoffTime;
		this.arrivalTime = arrivalTime;
		this.airline = airline;
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
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@131.96.101.119:1521:cisjj", "c##CHoff82354", "fpcs5673");
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into flights values("+this.flightNumber+",'"+this.originCity+"','"+this.destinationCity+"',"+this.takeoffTime+","+this.arrivalTime+",'"+this.airline+","+this.date+"')");
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//TODO close connection
		}
	}
}
