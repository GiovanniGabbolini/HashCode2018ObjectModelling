package source;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import source.*;
class VehicleStateConsistentAfterRideAssignment {

	@Test
	void test() {
		Vehicle v;
		Ride r;
		
		// test a ride that can begin at the moment of the earliest start
		v = new Vehicle();		
		r = new Ride(new Coordinate(1, 2), new Coordinate(1, 4), 3, 8);
		v.assignRide(r, 0);
		assertTrue(!v.isFree(0));
		assertTrue(!v.isFree(1));
		assertTrue(!v.isFree(2));
		assertTrue(!v.isFree(3));
		assertTrue(!v.isFree(4));
		assertTrue(v.isFree(5));
		
		// test a ride that can begin after the moment of the earliest start
		v = new Vehicle();		
		r = new Ride(new Coordinate(1, 2), new Coordinate(1, 4), 0, 8);
		v.assignRide(r, 0);
		assertTrue(!v.isFree(0));
		assertTrue(!v.isFree(1));
		assertTrue(!v.isFree(2));
		assertTrue(!v.isFree(3));
		assertTrue(!v.isFree(4));
		assertTrue(v.isFree(5));
		
	}

}
