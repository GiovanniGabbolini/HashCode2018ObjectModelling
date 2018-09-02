package source;

import source.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VehicleAssignedRidesDescriptionConsisten {

	@Test
	void test() {
		Ride r1 = new Ride(new Coordinate(0, 0), new Coordinate(1, 2), 0, 10);
		Ride r2 = new Ride(new Coordinate(1, 2), new Coordinate(1, 4), 3, 10);
		Vehicle v = new Vehicle();
		v.assignRide(r2, 10);
		v.assignRide(r1, 0);
		assertEquals("2 1 0", v.getAssignedRides());
		Vehicle v1 = new Vehicle();
		assertEquals("0", v1.getAssignedRides());
	}

}
