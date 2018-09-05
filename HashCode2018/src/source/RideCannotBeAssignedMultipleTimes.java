package source;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class RideCannotBeAssignedMultipleTimes {

	@Test
	void exceptionTesting() {
	    assertThrows(IllegalArgumentException.class,
	            ()->{
	            	Ride r = new Ride(new Coordinate(0, 0), new Coordinate(1, 2), 0, 5, 0);
	    	 		Vehicle v = new Vehicle(0);
	    	 		v.assignRide(r, 0);
	    	 		v.assignRide(r, 1);
	            }, "Ride already completed, cannot be assigned to another Vehicle");
	}

}
