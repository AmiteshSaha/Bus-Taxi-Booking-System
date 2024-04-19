package USER;
import java.util.*;

public class Customer extends userX{
	
	public static ArrayList<Customer> custs=new ArrayList<Customer>();
	
	public Customer(String name, String password, String email, long mob_no,char M){
		this.name=name;
		this.email=email;
		this.password=password;
		this.mob_no=mob_no;
		this.cust_id=name+"/"+Integer.toString((int)(mob_no%1000));
		this.gender=M;
	}
	public Customer(String name, String password, String email,long mob_no){
		this.name=name;
		this.email=email;
		this.password=password;
		this.mob_no=mob_no;
		this.cust_id=name+"/"+Integer.toString((int)(mob_no%1000));
		this.gender='B';
	}
	public void addCustomer() {
		custs.add(this);
	}
	public ArrayList<Customer> getCustomers(){
		return custs;
	}
	
}
