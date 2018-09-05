package source;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
	
	int T, F, N, B, R, C;
	ArrayList<Ride> rides;
	ArrayList<Vehicle> vehicles;
	IScheduler s;

    public Controller(IScheduler s) {
    	rides = new ArrayList<>();
    	vehicles = new ArrayList<>();
    	this.s = s;
    }
	
	public void run(String arg) throws IOException {
		IO io = new IO();
		io.read(arg, rides, vehicles, T, F, N, B, R, C);;
		s.assignRides(rides, vehicles, T, F, N, B, R, C);
		io.write(arg, vehicles);
	}
	
}
