package USER;
import java.util.*;

import vehicle.Bus;
import vehicle.Taxi;

public class Landing extends Client{
	Bus[] buses;
	Taxi[] taxis;
	boolean loginStatus;
	String customId;
	
	Landing(Bus[] bus, Taxi[] taxi){
		buses = new Bus[bus.length];
		taxis = new Taxi[taxi.length];
		buses = bus;
		taxis = taxi;
		loginStatus = false;
	}
	
	public void loginClient() {
		Client client = new Client();
		String a;
		do {
			a = client.login();
		}while(a.equals("-1"));
		loginStatus = true;
		customId = a;
	}
	
	public ArrayList<Bus> searchBuses(String source, String destination) {
		ArrayList<Bus> ans = new ArrayList<Bus>();
		for(int i = 0; i < buses.length; i++) {
			if(buses[i].getSource().equalsIgnoreCase(source) && buses[i].getDestination().equalsIgnoreCase(destination)) {
				ans.add(buses[i]);
			}
		}
		return ans;
	}
	
	public ArrayList<Bus> searchBuses() {
		ArrayList<Bus> ans = new ArrayList<Bus>();
		for(int i = 0; i < buses.length; i++) {
				ans.add(buses[i]);
		}
		return ans;
	}
	
	public ArrayList<Taxi> searchTaxis(int time){
		ArrayList<Taxi> ans = new ArrayList<Taxi>();
		for(int i = 0; i < taxis.length; i++) {
			if(taxis[i].isTaxiAvailable(time)) {
				ans.add(taxis[i]);
			}
		}
		return ans;
	}
	
	public ArrayList<Taxi> searchTaxis(){
		ArrayList<Taxi> ans = new ArrayList<Taxi>();
		for(int i = 0; i < taxis.length; i++) {
				ans.add(taxis[i]);
		}
		return ans;
	}
	
	public boolean bookBus(String vNumber, String source, String destination, int time) {
		if(loginStatus == true) {
			for(int i = 0; i < buses.length; i++) {
				if(buses[i].vehicleNumber.equals(vNumber)) {
					return buses[i].bookVehicle(customId, source, destination, time, 1);
				}
			}
			return false;
		}
		System.out.println("You must login to book a vehicle!");
		return false;
	}
	
	public boolean bookTaxi(String vNumber, String source, String destination, int time) {
		if(loginStatus == true) {
			for(int i = 0; i < taxis.length; i++) {
				if(taxis[i].vehicleNumber.equals(vNumber)) {
					return taxis[i].bookVehicle(customId, source, destination, time, 1);
				}
			}
		}
		System.out.println("You must login to book a taxi!");
		return false;
	}
	
	public boolean cancelBookings(String vNumber) {
		if(loginStatus == true) {
			for(int i = 0; i < buses.length; i++) {
				if(buses[i].vehicleNumber.equals(vNumber)) {
					return buses[i].cancelBooking(customId);
				}
			}
			for(int i = 0; i < taxis.length; i++) {
				if(taxis[i].vehicleNumber.equals(vNumber)) {
					return taxis[i].cancelBooking(customId);
				}
			}	
		}
		System.out.println("You must login to cancel a booking!");
		return false;
	}
	
	public boolean multipleBooking(String vNumber, int num) {
		if(loginStatus == true) {
			Bus b;
			int ind = -1;
			for(int i = 0; i < buses.length; i++) {
				if(buses[i].vehicleNumber.equals(vNumber)) {
					ind = i;
					break;
				}
			}
			b = buses[ind];
			String[] ids = new String[num];
			for(int i = 0; i < num; i++) {
				ids[i] = customId;
			}
			return b.addMultipleCustomers(b.getSource(), b.getDestination(), b.getTime(), ids);
		}
		System.out.println("You must login to book a bus!");
		return false;
	}
	
	public boolean multipleCancelations(int num, String vNumber) {
		if(loginStatus) {
			Bus b;
			int ind = -1;
			for(int i = 0; i < buses.length; i++) {
				if(buses[i].vehicleNumber.equals(vNumber)) {
					ind = i;
					break;
				}
			}
			if(ind != -1) {
				b = buses[ind];
				String[] ids = new String[num];
				for(int i = 0; i < num; i++) {
					ids[i] = customId;
				}
				return b.cancelMultipleCustomers(ids);
			}
			
		}
		System.out.println("You must login to cancel a booking!");
		return false;
	}
	
	public boolean logout() {
		customId = null;
		loginStatus = false;
		return true;
	}
	
}
