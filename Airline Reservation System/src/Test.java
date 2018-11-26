import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		//Flight f1 = new Flight("Atlanta","Chicago",1130,1330,"Delta");
		//Flight f2 = new Flight("LA","NYC",1100,1830,"United");
		//f1.insertDB();
		//f2.insertDB();
		//System.out.println(a);
		
		
		
		//Customer cus = new Customer("John","Doe","a",3,"a","a","a","a","a","a","a");
		//cus.insertDB();
		
		//Admin ad = new Admin("Steve","Smith","a",4,"a","a","a","a","a","a","a");
		//ad.insertDB();
		
		ArrayList l = Database_Select.getFlights();
		ArrayList c = Database_Select.getCustomers();
		ArrayList a = Database_Select.getAdmins();
		
		System.out.println(l);
		System.out.println(c);
		System.out.println(a);
		
	}
	
	public static void addCustomer() {	
		Scanner input = new Scanner(System.in);
		System.out.println("First Name: ");
		String fname = input.nextLine();
		System.out.println("Last Name: ");
		String lname = input.nextLine();
		System.out.println("Address: ");
		String address = input.nextLine();
		System.out.println("Zip: ");
		String szip = input.nextLine();
		System.out.println("State: ");
		String state = input.nextLine();
		System.out.println("Username: ");
		String uname = input.nextLine();
		System.out.println("Password: ");
		String password = input.nextLine();
		System.out.println("Email: ");
		String email = input.nextLine();
		System.out.println("SSN: ");
		String ssn = input.nextLine();
		System.out.println("Security Question: ");
		String question = input.nextLine();
		System.out.println("Security Answer: ");
		String answer = input.nextLine();
		int zip = Integer.parseInt(szip);
		new Customer(fname,lname,address,zip,state,uname,password,email,ssn,question,answer).insertDB();
	}
	
	public static void addAdmin() {	
		Scanner input = new Scanner(System.in);
		System.out.println("First Name: ");
		String fname = input.nextLine();
		System.out.println("Last Name: ");
		String lname = input.nextLine();
		System.out.println("Address: ");
		String address = input.nextLine();
		System.out.println("Zip: ");
		String szip = input.nextLine();
		System.out.println("State: ");
		String state = input.nextLine();
		System.out.println("Username: ");
		String uname = input.nextLine();
		System.out.println("Password: ");
		String password = input.nextLine();
		System.out.println("Email: ");
		String email = input.nextLine();
		System.out.println("SSN: ");
		String ssn = input.nextLine();
		System.out.println("Security Question: ");
		String question = input.nextLine();
		System.out.println("Security Answer: ");
		String answer = input.nextLine();
		int zip = Integer.parseInt(szip);
		new Admin(fname,lname,address,zip,state,uname,password,email,ssn,question,answer).insertDB();
	}
	
	public static void addFlight() {	
		Scanner input = new Scanner(System.in);
		System.out.println("Origin City: ");
		String ocity = input.nextLine();
		System.out.println("Destination City: ");
		String dcity = input.nextLine();
		System.out.println("Takeoff Time: ");
		String sttime = input.nextLine();
		System.out.println("Arrival Time: ");
		String satime = input.nextLine();
		System.out.println("Airline: ");
		String aline = input.nextLine();
		int ttime = Integer.parseInt(sttime);
		int atime = Integer.parseInt(satime);
		new Flight(ocity,dcity,ttime,atime,aline).insertDB();
	}

}
