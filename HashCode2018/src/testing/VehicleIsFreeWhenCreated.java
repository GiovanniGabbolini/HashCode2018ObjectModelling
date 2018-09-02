package testing;

import static org.junit.jupiter.api.Assertions.*;
import source.*;

import org.junit.jupiter.api.Test;

class VehicleIsFreeWhenCreated {

	@Test
	void test() {
		 Vehicle v = new Vehicle();
		 assertTrue(v.isFree(0));
	}

}
