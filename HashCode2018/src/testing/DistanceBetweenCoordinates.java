package testing;

import static org.junit.jupiter.api.Assertions.*;
import source.*;
import org.junit.jupiter.api.Test;

class DistanceBetweenCoordinates {

	@Test
	void test() {
		Coordinate c1 = new Coordinate(0, 0);
		Coordinate c2 = new Coordinate(2, 3);
		assertEquals(5, c1.distance(c2));
	}

}