package source;

import java.util.ArrayList;
import java.util.Collection;

public interface IScheduler {
	
	/*
	 * a well formed scheduler should return collection of vehicles with the rides assigned
	 * to each vehicle
	 */
	public Collection<Vehicle> assignRides(ArrayList<Ride> rides, ArrayList<Vehicle> vehicles, int T, int F, int N, int B, int R, int C);

}
