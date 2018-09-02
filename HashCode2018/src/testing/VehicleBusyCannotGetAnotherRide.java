package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import source.Coordinate;
import source.Ride;
import source.Vehicle;

class VehicleBusyCannotGetAnotherRide {

	@Test
	void exceptionTesting() {
	    assertThrows(IllegalArgumentException.class,
	            ()->{
	            	Ride r = new Ride(new Coordinate(0, 0), new Coordinate(1, 2), 0, 5);
	            	Ride r1 = new Ride(new Coordinate(0, 0), new Coordinate(1, 2), 0, 5);
	    	 		Vehicle v = new Vehicle();
	    	 		v.assignRide(r, 0);
	    	 		v.assignRide(r, 1);
	            }, "Veichle is busy, cannot get another ride at this time instant");
	}

}
