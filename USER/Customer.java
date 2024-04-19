package USER;
import java.util.*;

public class Customer extends userX{
	
	public static ArrayList<Customer> custs=new ArrayList<Customer>();
	
	public Customer(String name, String password, String email, long mob_no){
		this.name=name;
		this.email=email;
		this.password=password;
		this.mob_no=mob_no;
		this.cust_id=name+"/"+Integer.toString((int)(mob_no));
	}
	public void addCustomer() {
		custs.add(this);
	}
	public ArrayList<Customer> getCustomers(){
		return custs;
	}
	
}
