package Entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database_Select {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@131.96.101.119:1521:cisjj";
   static ArrayList<Flight> FlightList = new ArrayList();
   static ArrayList<Customer> customerList = new ArrayList();
   static ArrayList<Admin> adminList = new ArrayList();

   //  Database credentials
   static final String USER = "c##CHoff82354";
   static final String PASS = "fpcs5673";
   
   public static ArrayList<Customer> getCustomers() {//method that returns an ArrayList of Customer objects from the database
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("oracle.jdbc.driver.OracleDriver");

	      //STEP 3: Open a connection
	      //System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      //System.out.println("Connected database successfully...");
	      
	      //STEP 4: Execute a query
	      //System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql = "SELECT F_Name, L_Name, Address, Zip, State, U_Name, Password, email, SSN, Question, Answer FROM customers";
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
	         
	         customerList.add(new Customer(firstName, lastName, address, zip, state, userName, password, email, ssn, question, answer));
	      
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
	   
		return customerList;
       }
   
   public static ArrayList<Admin> getAdmins() {//method that returns an ArrayList of Admin objects from the database
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("oracle.jdbc.driver.OracleDriver");

	      //STEP 3: Open a connection
	      //System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      //System.out.println("Connected database successfully...");
	      
	      //STEP 4: Execute a query
	      //System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql = "SELECT F_Name, L_Name, Address, Zip, State, U_Name, Password, email, SSN, Question, Answer FROM employees";
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
	         
	         adminList.add(new Admin(firstName, lastName, address, zip, state, userName, password, email, ssn, question, answer));
	      
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
	   
		return adminList;
       }
   
   public static ArrayList<Flight> getFlights() {//method that returns an ArrayList of Flight objects from the database
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("oracle.jdbc.driver.OracleDriver");

      //STEP 3: Open a connection
      //System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      //System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();

      String sql = "SELECT F_Number, O_City, D_City, T_Time, A_Time, Airline FROM flights";
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
         FlightList.add(new Flight(oCity, dCity, tTime, aTime, airline));
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
   return FlightList;
}
}