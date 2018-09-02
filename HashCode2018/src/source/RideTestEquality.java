package source;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RideTestEquality {

	@Test
	void test() {
		Ride r1 = new Ride(new Coordinate(0, 0), new Coordinate(2, 2), 1, 10);
		Ride r2 = new Ride(new Coordinate(1, 1), new Coordinate(3, 3), 2, 12);
		Ride r3 = new Ride(new Coordinate(1, 1), new Coordinate(3, 3), 2, 12);
		assertTrue(r1.equals(r2) && !r2.equals(r3));
	}

}
