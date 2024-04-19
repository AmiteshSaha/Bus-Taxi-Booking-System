package vehicle;

public abstract class Vehicle {
	protected String vehicleNumber;
		
	public abstract boolean bookVehicle(long customId, String source, String destination, int time, int cap);
	
	public abstract boolean cancelBooking(long customId);
}
