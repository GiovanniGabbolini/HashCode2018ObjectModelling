package source;
import java.util.ArrayList;

public class Vehicle {

	int timeIstantFree, code;
	Coordinate position;
	ArrayList<Ride> ridesAssigned;
	static int c = 0;
	
	public Vehicle() {
		code = c;
		timeIstantFree = 0;
		position = new Coordinate(0, 0);
		ridesAssigned = new ArrayList<>();
		c++;
	}
	
	public void assignRide(Ride ride, int timeInstant) throws IllegalArgumentException{
		if(ride.completed) 
			throw new IllegalArgumentException("Ride already completed, cannot be assigned to another Vehicle");
		else if(!this.isFree(timeInstant))
			throw new IllegalArgumentException("Veichle is busy, cannot get another ride at this time instant");
		else if(ride.es > timeInstant)
			throw new IllegalArgumentException("A ride cannot be assigned before its earliest start");
		else{
			timeIstantFree = timeInstant + position.distance(ride.si) + ride.si.distance(ride.fi)
							+ ((timeInstant + position.distance(ride.si) < ride.es) ? ride.es - (timeInstant + position.distance(ride.si)) : 0);
			ridesAssigned.add(ride);
			ride.completed = true;
		}
	}
	
	public boolean isFree(int timeInstant) {
		return timeInstant >= timeIstantFree;
	}
	
	static void zeroCounter() {
		c = 0;
	}
	
	String getAssignedRides() {
		String r = ((Integer)ridesAssigned.size()).toString();
		for(Ride i : ridesAssigned)
			r += " " + String.valueOf(i.code);
		return r;
	}
	
	public Coordinate getPosition() {
		return position;
	}

	public ArrayList<Ride> getRidesAssigned() {
		return ridesAssigned;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Vehicle))
	        return false;
		else
			return this.code == ((Vehicle) obj).code;
	}
}
