package vehicle;

public abstract class Vehicle {
	public String vehicleNumber;
		
	public abstract boolean bookVehicle(String customId, String source, String destination, int time, int cap);
	
	public abstract boolean cancelBooking(String customId);
}
