import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		System.out.println(1);
		
		ArrayList l = Entities.Database_Select.getFlights();
		ArrayList c = Entities.Database_Select.getCustomers();
		ArrayList a = Entities.Database_Select.getAdmins();
		
		System.out.println(l);
		System.out.println(c);
		System.out.println(a);
		
	}

}
