package source;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import source.*;

class IOInputFormatReadConsistent {

	@Test
	void test() throws IOException {
		ArrayList<Ride> rides = new ArrayList<>();
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		int T = 0, F = 0, N = 0, B = 0, R = 0, C = 0;
		String path = new File("").getAbsolutePath().concat("/files/a_example.in");
		IO.getInstance().read(path, rides, vehicles, T, F, N, B, R, C);
		
		assertTrue(
				rides.get(0).getEs() == 2 &&
				rides.get(1).getEs() == 0 &&
				rides.get(2).getEs() == 0 &&
				rides.get(0).getLf() == 9 &&
				rides.get(1).getLf() == 9 &&
				rides.get(2).getLf() == 9 &&
				rides.get(0).getSi().equals(new Coordinate(0, 0)) &&
				rides.get(1).getSi().equals(new Coordinate(1, 2)) &&
				rides.get(2).getSi().equals(new Coordinate(2, 0)) &&
				rides.get(0).getFi().equals(new Coordinate(1, 3)) &&
				rides.get(1).getFi().equals(new Coordinate(1, 0)) &&
				rides.get(2).getFi().equals(new Coordinate(2, 2)) &&
				!rides.get(0).equals(rides.get(1)) &&
				!rides.get(1).equals(rides.get(2)) &&
				rides.size() == 3 &&
				T == 10 &&
				R == 3 &&
				C == 4 &&
				F == 2 &&
				N == 3 &&
				B == 2 &&
				vehicles.size() == 2 &&
				!vehicles.get(0).equals(vehicles.get(1)) &&
				!vehicles.get(1).equals(vehicles.get(2))
				);
	}

}
