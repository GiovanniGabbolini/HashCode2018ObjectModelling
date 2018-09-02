package source;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
	
	static int T, F, N, B, R, C;
	static ArrayList<Ride> rides;
	static ArrayList<Vehicle> vehicles;
	
	private static final Controller c = new Controller();

    public static Controller getInstance() {
        return c;
    }

    private Controller() {
    	rides = new ArrayList<>();
    	vehicles = new ArrayList<>();
    }
	
	public void run(IScheduler s, String arg) throws IOException {
		Ride.zeroCounter();
		Vehicle.zeroCounter();
		IO.getInstance().read(arg, rides, vehicles, T, F, N, B, R, C);;
		s.assignRides(rides, vehicles, T, F, N, B, R, C);
		IO.getInstance().write(arg, vehicles);
	}
	
}
