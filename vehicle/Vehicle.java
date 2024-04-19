package vehicle;

public abstract class Vehicle {
	protected String vehicleNumber;
		
	public abstract boolean bookVehicle(long customId);
	
	public abstract boolean cancelBooking(long customId);
}
