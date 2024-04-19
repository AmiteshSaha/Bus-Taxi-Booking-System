package USER;

public class Login implements user_base{
	@Override
	public String checkLogin(String email,String password) {
		int f=-1;;
		for(int i=0;i<Customer.custs.size();i++) {
			if(Customer.custs.get(i).email==email&&Customer.custs.get(i).password==password)
				f=0;
			else if(Customer.custs.get(i).email==email&&Customer.custs.get(i).password!=password) {
				f=1;
			}
		}
		if(f==0)
			return "Welcome";
		else if(f==1)
			return "Invalid password";
		else
			return "user doesnt exists. Please sign up!!";
			
	}
	@Override
	public String newLogin(String name, String password, String email, long mob_no) {
		for(int i=0;i<Customer.custs.size();i++) {
			if(Customer.custs.get(i).email==email)
				return "User already exists";
		}
		Customer cust=new Customer(name, password, email, mob_no);
		cust.addCustomer();
		return "Sign Up Successful!";
	}

	@Override
	public String deleteLogin(String email,String password) {
		for(int i=0;i<Customer.custs.size();i++) {
			if(Customer.custs.get(i).email==email&&Customer.custs.get(i).password==password)
			{Customer.custs.remove(i);
				return "User deleted Successful";
			}
		}
		return "invalid user id or password";
	}
}
