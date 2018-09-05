package source;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RideCannotBeAssignedBeforeItsEarliestStart {

	@Test
	void exceptionTesting() {
	    assertThrows(IllegalArgumentException.class,
	            ()->{
	            	Ride r = new Ride(new Coordinate(0, 0), new Coordinate(1, 2), 1, 5, 0);
	    	 		Vehicle v = new Vehicle(0);
	    	 		v.assignRide(r, 0);
	            }, "A ride cannot be assigned before its earliest start");
	}

}
