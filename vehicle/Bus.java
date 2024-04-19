package vehicle;

public class Bus extends Vehicle{
	int capacity;          // the Capacity of the bus or the number of total seats the bus has;
	int availableSeats;    // the number of available seats;
	String source;		   // The point from which the bus starts its journey.	
	String destination;	   // The point where the bus ends its journey
	int time;              // The time at which the bus starts its journey from its source. Measured in hours past 00:00;
	long[] customers;	   // Maintains a list of customers by their Ids ;
	int numberOfCustomers; // The number of customers who have currently booked the bus;
	
	Bus(int cap, String source, String dest, int time, String vnumber){
		this.vehicleNumber = vnumber;
		capacity = cap;
		availableSeats = cap;
		this.source = source;
		destination = dest;
		this.time = time;
		customers = new long[cap];
		numberOfCustomers = 0;
	}
	
	@Override
	public boolean bookVehicle(long customId) {
		if(availableSeats > 0) {
			customers[numberOfCustomers] =  customId;
			numberOfCustomers++;
			availableSeats--;
			return true;
		}
		return false;
	}
	
	@Override
	public boolean cancelBooking(long customId) {
		int ind = getCustomerId(customers, customId);
		if(ind != -1) {
			for(int i = ind; i < customers.length-1; i++) {
				customers[i] = customers[i+1];
			}
			customers[capacity-1] = 0;
			numberOfCustomers--;
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
	
	public long[] getCustomers() {
		return customers;
	}
	
	public void finishTrip() {
		for(int i = 0; i < customers.length; i++) {
			customers[i] = 0;
		}
		availableSeats = capacity;
		numberOfCustomers = 0;
	}
	
	public String getSource() {
		return source;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public int getTime() {
		return time;
	}
}
