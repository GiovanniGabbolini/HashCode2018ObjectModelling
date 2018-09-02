package source;
import java.util.ArrayList;

public class Vehicle {

	int timeIstantFree, code;
	Coordinate position;
	ArrayList<Integer> ridesAssigned;
	static int c = 0;
	
	public Vehicle() {
		code = c;
		timeIstantFree = 0;
		position = new Coordinate(0, 0);
		ridesAssigned = new ArrayList<>();
		c++;
	}
	
	/*
	 * todo: prevent rides from being assigned multiple times
	 * 		 prevent vehicles to have time conflicting rides assigned
	 * 		 prevent rides to be assigned before their earliest start
	 * 		 maybe using exceptions
	 */
	public void assignRide(Ride ride, int timeInstant) {
		timeIstantFree = timeInstant + position.distance(ride.si) + ride.si.distance(ride.fi)
							+ ((timeInstant + position.distance(ride.si) < ride.es) ? ride.es - (timeInstant + position.distance(ride.si)) : 0);
		ridesAssigned.add(ride.code);
		ride.completed = true;
	}
	
	public boolean isFree(int timeInstant) {
		return timeInstant >= timeIstantFree;
	}
	
	public static void zeroCounter() {
		c = 0;
	}
	
	public String getAssignedRides() {
		String r = ((Integer)ridesAssigned.size()).toString();
		for(Integer i : ridesAssigned)
			r += " " + i.toString();
		return r;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Vehicle))
	        return false;
		else
			return this.code == ((Vehicle) obj).code;
	}
}
