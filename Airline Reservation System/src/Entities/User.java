package Entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class User {

	private String firstname;
	private String lastname;
	private String address;
	private int zip;
	private String state;
	private String username;
	private String password;
	private String email;
	private String ssn;
	private String question;
	private String answer;
	
	Flight myFlight = new Flight();
	
	public User(String firstname, String lastname, String address, int zip, String state, String username,
			String password, String email, String ssn, String question, String answer) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.zip = zip;
		this.state = state;
		this.username = username;
		this.password = password;
		this.email = email;
		this.ssn = ssn;
		this.question = question;
		this.answer = answer;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public boolean loggedin(String name, String password) {
		if(name==this.username && password==this.password)
			return true;
		else
			return false;
	}
	public String retrievePass(String user, String answer) {
		if(user==this.username && answer==this.answer)
			return this.password;
		else
			return "incorrect answer";
	}
	protected void insertDB(String table,int id) { //method for inserting users into the database
		
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@131.96.101.119:1521:cisjj", "c##CHoff82354", "fpcs5673");
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into "+table+" values("
					+ id +",'"+this.firstname+"','"+this.lastname+"','"+this.address+"',"+this.zip+",'"+this.state+"','"+this.username+"','"+this.password+"','"+this.email+"','"+this.ssn+"','"+this.question+"','"+this.answer+"')");
			connection.close();
		} 
		catch (Exception e) {
			System.out.println("error");
		}

	}
	
	//adds flight to user account
	protected void createBooking(String table, int id, int flightNumber) {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@131.96.101.119:1521:cisjj", "c##CHoff82354", "fpcs5673");
			PreparedStatement statement = con.prepareStatement("insert into " + table + "(F_Number) values (?)");
			statement.setInt(1, flightNumber);
			statement.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//TODO close connection
		}
		
	}
	
	
	//adds flight to user account
	protected void deleteBooking(String table, int id, int flightNumber) {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@131.96.101.119:1521:cisjj", "c##CHoff82354", "fpcs5673");
			PreparedStatement statement = con.prepareStatement("delete from " + table + " where F_Number = ?");
			statement.setInt(1, flightNumber);
			statement.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//TODO close connection
		}
		
	}
	
	//counts the number of rows ("seats") in a flight
	protected int countDB(int flightNumber) {
		int rowCount = 0;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@131.96.101.119:1521:cisjj", "c##CHoff82354", "fpcs5673");
			PreparedStatement statement = con.prepareStatement ("Select * from flights WHERE F_Number = ?");
			statement.setInt(1, flightNumber);
			ResultSet rs = statement.executeQuery();
		    while (rs.next()) {
		        rowCount = rs.getInt(1);
		      }
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//TODO close connection
		}
		
		  return rowCount;
	}
	
	protected void searchFlight(String originCity, String destinationCity,int takeOffTime, int arrivalTime) {
		myFlight.searchDB(originCity, destinationCity, takeOffTime, arrivalTime);
		
	}
	
	public String toString() {
		return this.firstname+" "+this.lastname;
	}
}
