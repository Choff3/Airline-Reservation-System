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
	
	public Flight(String originCity, String destinationCity, int takeoffTime, int arrivalTime,String airline, String date) {
		this.flightNumber=++flightCount;
		this.originCity = originCity;
		this.destinationCity = destinationCity;
		this.takeoffTime = takeoffTime;
		this.arrivalTime = arrivalTime;
		this.airline = airline;
		this.date = date;
	}
	
	public Flight() {
		// TODO Auto-generated constructor stub
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
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@131.96.101.119:1521:cisjj", "c##CHoff82354", "fpcs5673");
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into flights values("+this.flightNumber+",'"+this.originCity+"','"+this.destinationCity+"',"+this.takeoffTime+","+this.arrivalTime+",'"+this.airline+",'"+this.date+"')");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void updateDB(int flightNumber, String originCity, String destinationCity, int takeoffTime, int arrivalTime) {	//method for updating flight information in the database
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@131.96.101.119:1521:cisjj", "c##CHoff82354", "fpcs5673");
			PreparedStatement statement = con.prepareStatement ("UPDATE flights SET O_City = ?, D_City = ?,"
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
	
	protected void deleteDB(int flightNumber) {	//method for deleting flights from the database
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@131.96.101.119:1521:cisjj", "c##CHoff82354", "fpcs5673");
			PreparedStatement statement = con.prepareStatement("delete from flights where F_Number = ?");
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
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@131.96.101.119:1521:cisjj", "c##CHoff82354", "fpcs5673");
			PreparedStatement statement = con.prepareStatement("Select * from flights WHERE O_City = ?, D_City = ?,  T_Time = ?, A_Time = ?");
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
	
}
