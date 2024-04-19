package USER;
import java.util.*;

class Client extends Login{
	
	public int login() {
		Scanner in=new Scanner(System.in);
	int choice=0;
	System.out.println("Enter Choice: 1-> Sign In,  2->Sign Up,  3->Delete Account");
	choice=in.nextInt();
	if(choice==1) {
	String email,password;
	System.out.println("Enter email: ");
	email=in.next();
	System.out.println("Enter password: ");
	password=in.next();
	String S=checkLogin(email, password);
	System.out.println(S);
	if(S.equals("Welcome"))
		return 1;
	else
		return 0;
	}
	else if(choice==2) {
		String email,password,name;
		long mobno;char gen;
		System.out.println("Enter name:");
		name=in.next();
		System.out.println("Enter email:");
		email=in.next();
		System.out.println("Enter Password:");
		password=in.next();
		System.out.println("Enter Mobile number");
		mobno=in.nextLong();
		System.out.println("Enter Mobile gender");
		gen=in.next().charAt(0);
		String S=newLogin(name, password, email, mobno,gen);
		System.out.println(S);
		if(S.equals("Sign Up Successful!"))
			return 1;
		else
			return 0;
		
	}
	else if(choice ==3) {
		String email,password;
		System.out.println("Enter email: ");
		email=in.next();
		System.out.println("Enter passwrod: ");
		password=in.next();
		String S=deleteLogin(email,password);
		System.out.println(S);
		return 0;
		}
	return -1;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<3;i++) {
		Client obj=new Client();
		int a=obj.login();
		}
		
		for(int i=0;i<Customer.custs.size();i++)
			System.out.println(Customer.custs.get(i).cust_id);
	}
	
}
