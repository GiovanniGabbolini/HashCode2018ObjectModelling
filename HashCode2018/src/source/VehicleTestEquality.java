package source;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VehicleTestEquality {

	@Test
	void test() {
		Vehicle v1 = new Vehicle();
		Vehicle v2 = new Vehicle();
		assertTrue(v1.equals(v1) && !v1.equals(v2));
	}

}
