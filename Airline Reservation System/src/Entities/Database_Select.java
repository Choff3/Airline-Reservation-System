package Entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database_Select {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://cisproject.cjh80q7hgyjz.us-east-2.rds.amazonaws.com:3306/Flight Database";
   public static ArrayList<Flight> FlightList = new ArrayList<Flight>();
   public static ArrayList<Customer> customerList = new ArrayList<Customer>();
   public static ArrayList<Admin> adminList = new ArrayList<Admin>();
   public static ArrayList<Booking> bookingList = new ArrayList<Booking>();

   //  Database credentials
   static final String USER = "cis2019";
   static final String PASS = "GSUcis2019!!";
   
   public static void setCustomers() {//method that returns an ArrayList of Customer objects from the database
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.cj.jdbc.Driver");

	      //STEP 3: Open a connection
	      //System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      //System.out.println("Connected database successfully...");
	      
	      //STEP 4: Execute a query
	      //System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql = "SELECT F_Name, L_Name, Address, Zip, State, U_Name, Password, email, SSN, Question, Answer, ID FROM CUSTOMERS";
	      ResultSet rs = stmt.executeQuery(sql);
	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         String firstName = rs.getString("F_Name");
	         String lastName = rs.getString("L_Name");
	         String address = rs.getString("Address");
	         int zip  = rs.getInt("Zip");
	         String state = rs.getString("State");
	         String userName = rs.getString("U_Name");
	         String password = rs.getString("Password");
	         String email = rs.getString("email");
	         String ssn = rs.getString("SSN");
	         String question = rs.getString("Question");
	         String answer = rs.getString("answer");
	         int id = rs.getInt("ID");
	         
	         customerList.add(new Customer(firstName, lastName, address, zip, state, userName, password, email, ssn, question, answer, id));
	      }
	      rs.close();
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
       }
   
   public static void setAdmins() {//method that returns an ArrayList of Admin objects from the database
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.cj.jdbc.Driver");

	      //STEP 3: Open a connection
	      //System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      //System.out.println("Connected database successfully...");
	      
	      //STEP 4: Execute a query
	      //System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql = "SELECT F_Name, L_Name, Address, Zip, State, U_Name, Password, email, SSN, Question, Answer, ID FROM EMPLOYEES";
	      ResultSet rs = stmt.executeQuery(sql);
	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         String firstName = rs.getString("F_Name");
	         String lastName = rs.getString("L_Name");
	         String address = rs.getString("Address");
	         int zip  = rs.getInt("Zip");
	         String state = rs.getString("State");
	         String userName = rs.getString("U_Name");
	         String password = rs.getString("Password");
	         String email = rs.getString("email");
	         String ssn = rs.getString("SSN");
	         String question = rs.getString("Question");
	         String answer = rs.getString("answer");
	         int id = rs.getInt("ID");
	         
	         adminList.add(new Admin(firstName, lastName, address, zip, state, userName, password, email, ssn, question, answer, id));
	      }
	      rs.close();
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
       }
   
   public static void setFlights() {//method that returns an ArrayList of Flight objects from the database
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.cj.jdbc.Driver");

      //STEP 3: Open a connection
      //System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      //System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();

      String sql = "SELECT F_Number, O_City, D_City, T_Time, A_Time, Airline, F_Date FROM FLIGHTS";
      ResultSet rs = stmt.executeQuery(sql);
      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         //int fNumber  = rs.getInt("F_Number");
         String oCity = rs.getString("O_City");
         String dCity = rs.getString("D_City");
         int tTime  = rs.getInt("T_Time");
         int aTime  = rs.getInt("A_Time");
         String airline = rs.getString("Airline");
         String date = rs.getString("F_Date");
         
         FlightList.add(new Flight(oCity, dCity, tTime, aTime, airline, date));
      }
      rs.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}
   
   public static void setBookings() {//method that returns an ArrayList of Flight objects from the database
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.cj.jdbc.Driver");

	      //STEP 3: Open a connection
	      //System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      //System.out.println("Connected database successfully...");
	      
	      //STEP 4: Execute a query
	      //System.out.println("Creating statement...");
	      stmt = conn.createStatement();

	      String sql = "SELECT User_ID, F_Num FROM BOOKINGS";
	      ResultSet rs = stmt.executeQuery(sql);
	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         int uId  = rs.getInt("User_ID");
	         int fNum  = rs.getInt("F_Num");
	         
	         bookingList.add(new Booking(uId,fNum));
	      }
	      rs.close();
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	}
   
   public static ArrayList<Flight> getFlights() {
	return FlightList;
}

public static ArrayList<Customer> getCustomers() {
	return customerList;
}

public static ArrayList<Admin> getAdmins() {
	return adminList;
}

public static ArrayList<Booking> getBookings() {
	   return bookingList;
   }
}