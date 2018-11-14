import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		//Flight f1 = new Flight("Atlanta","Chicago",1130,1330,"Delta");
		//Flight f2 = new Flight("LA","NYC",1100,1830,"United");
		//f1.insertDB();
		//f2.insertDB();
		//System.out.println(a);
		
		
		
		Customer cus = new Customer("John","Doe","a",4,"a","a","a","a","a","a","a");
		//cus.insertDB();
		
		Admin ad = new Admin("Steve","Smith","a",4,"a","a","a","a","a","a","a");
		//ad.insertDB();
		
		ArrayList l = Database_Select.getFlights();
		ArrayList c = Database_Select.getCustomers();
		ArrayList a = Database_Select.getAdmins();
		
		System.out.println(l);
		System.out.println(c);
		System.out.println(a);
		
	}

}
