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
		for(int i = 0; i < buses.length; i++) {
			if(buses[i].vehicleNumber.equals(vNumber)) {
				return buses[i].bookVehicle(customId, source, destination, time, 1);
			}
		}
		return false;
	}
	
	public boolean bookTaxi(String vNumber, String source, String destination, int time) {
		for(int i = 0; i < taxis.length; i++) {
			if(taxis[i].vehicleNumber.equals(vNumber)) {
				return taxis[i].bookVehicle(customId, source, destination, time, 1);
			}
		}
		return false;
	}
	
	public boolean cancelBooking(String vNumber) {
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
		return false;
	}
	
	
	
}
