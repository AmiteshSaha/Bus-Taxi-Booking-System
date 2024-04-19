package vehicle;

import java.util.Random;

public class Taxi extends Vehicle{
	int capacity;
	String companyName;
	int speed;
	String driverName;
	long driverContact;
	int[] bookingTimes;
	long[] customers;
	int[] numOfCustomers;
	int maxTime;
	int[] ETAs;
	int numberOfBookings;
	
	Taxi(int cap, String compName, int speed, String driverName, long driverContact){
		capacity = cap;
		companyName = compName;
		this.speed = speed;
		this.driverName = driverName;
		this.driverContact = driverContact;
		bookingTimes = new int[10];
		ETAs = new int[10];
		numberOfBookings = 0;
	}
	
	Taxi(String compName, int speed, String driverName, long driverContact){
		capacity = 5;
		companyName = compName;
		this.speed = speed;
		this.driverName = driverName;
		this.driverContact = driverContact;
		bookingTimes = new int[10];
		ETAs = new int[10];
		numberOfBookings = 0;
	}
	
	private class Route{
		String source;
		String destination;
		int startTime;
		int distance;
		int ETA;
		
		Route(String source, String destination, int time){
			this.source = source;
			this.destination = destination;
			this.startTime = time;
			Random rand = new Random();
			distance = rand.nextInt(100);
			ETA = time + (distance/speed);
		}
	}
	
	private Route setRoute(String source, String destination, int time) {
		Route route = new Route(source, destination, time);
		return route;
	}
	
	public boolean isTaxiAvailable(int time) {
		for(int i = 0; i < numberOfBookings; i++) {
			if(time >= bookingTimes[i] && time < ETAs[i]) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isTaxiAvailable(long cap) {
		if(cap > capacity) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean bookVehicle(long customId, String source, String destination, int time, int cap) {
		Route route = setRoute(source, destination, time);
		if(route.ETA - route.startTime > maxTime) {
			return false;
		}else {
			if(isTaxiAvailable((time))){
				if(isTaxiAvailable((long)(cap))) {
					bookingTimes[numberOfBookings] = time;
					ETAs[numberOfBookings] = route.ETA;
					numOfCustomers[numberOfBookings] = cap;
					customers[numberOfBookings] = customId;
					numberOfBookings++;
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean cancelBooking(long customId) {
		int ind = getCustomerId(customers, customId);
		if(ind != -1) {
			for(int i = ind; i < numberOfBookings; i++) {
				bookingTimes[i] = bookingTimes[i+1];
				ETAs[i] = ETAs[i+1];
				numOfCustomers[i] = numOfCustomers[i+1];
				customers[i] = customers[i+1];
			}
			bookingTimes[numberOfBookings-1] = 0;
			ETAs[numberOfBookings-1] = 0;
			numOfCustomers[numberOfBookings-1] = 0;
			customers[numberOfBookings-1] = 0;
			numberOfBookings--;
			return true;
		}
		return false;
	}
	
	private int getCustomerId(long[] customs, long customId) {
		for(int i = 0; i < customs.length; i++) {
			if(customs[i] == customId) {
				return i;
			}
		}
		return -1;
	}
}
