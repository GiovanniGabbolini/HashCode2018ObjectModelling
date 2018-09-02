package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import source.Coordinate;

class CoordinatesTestEquality {

	@Test
	void test() {
		Coordinate c1 = new Coordinate(0, 0);
		Coordinate c2 = new Coordinate(0, 0);
		Coordinate c3 = new Coordinate(1, 1);
		assertTrue(c1.equals(c2) && !c1.equals(c3));
	}

}
