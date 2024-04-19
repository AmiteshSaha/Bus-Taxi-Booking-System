package USER;
import java.util.*;

public class Client extends Login{
	Scanner in=new Scanner(System.in);
	public int login() {
	int choice=0;
	System.out.println("Enter Choice: 1-> Sign In,  2->Sign Up,  3->Delete Account");
	choice=in.nextInt();
	if(choice==1) {
	String email,password;
	System.out.print("Enter email: ");
	email=in.nextLine();
	System.out.print("Enter passwrod: ");
	password=in.nextLine();
	String S=checkLogin(email, password);
	System.out.println(S);
	if(S.equals("Welcome"))
		return 1;
	else
		return 0;
	}
	else if(choice==2) {
		String email,password,name;
		long mobno;
		System.out.println("Enter name:");
		name=in.nextLine();
		System.out.println("Enter email:");
		email=in.nextLine();
		System.out.println("Enter Password:");
		password=in.nextLine();
		System.out.println("Enter Mobile number");
		mobno=in.nextLong();
		String S=newLogin(name, password, email, mobno);
		System.out.println(S);
		if(S.equals("Sign Up Successful!"))
			return 1;
		else
			return 0;
		
	}
	else if(choice ==3) {
		String email,password;
		System.out.print("Enter email: ");
		email=in.nextLine();
		System.out.print("Enter passwrod: ");
		password=in.nextLine();
		String S=deleteLogin(email,password);
		System.out.println(S);
		return 0;
	}
	in.close();
	return -1;
	}
}
