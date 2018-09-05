package source;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class IOOutputFormatWriteConsistent {

	@Test
	void test() throws IOException {
		String path = new File("").getAbsolutePath().concat("/files/test.out");
		
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		vehicles.add(new Vehicle(0));
		vehicles.add(new Vehicle(1));
		vehicles.get(0).assignRide(new Ride(new Coordinate(0, 0), new Coordinate(1, 2), 0, 9, 0), 0);
		vehicles.get(1).assignRide(new Ride(new Coordinate(0, 0), new Coordinate(1, 2), 0, 9, 0), 0);
		vehicles.get(1).assignRide(new Ride(new Coordinate(0, 0), new Coordinate(1, 2), 0, 9, 0), 0);
		IO io = new IO();
		io.write(path, vehicles);
		
		ArrayList<Integer> al = new ArrayList<>();
		al.add(Integer.valueOf(0));
		Files.lines(Paths.get(path)).forEachOrdered(
				s -> {
					switch (al.get(0)) {
					case 0:
						assertEquals("1 0", s);
						break;
					case 1:
					default:
						assertEquals("2 1 2", s);
						break;
					}
					al.add(0, al.get(0) + 1);;
				});
		
	}

}
