package source;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

public class IO{

	private static final IO io = new IO();

    public static IO getInstance() {
        return io;
    }

    private IO() {}
	
	void read(String arg, Collection<Ride> rides, Collection<Vehicle> vehicles, int T, int F, int N, int B,
			int R, int C) throws IOException {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(0);
		Files.lines(Paths.get(arg)).forEachOrdered(
				s -> {
					String[] parts = s.split(" ");
					if(al.get(0) == 0) {
						al.add(Integer.parseInt(parts[0]));
						al.add(Integer.parseInt(parts[1]));
						al.add(Integer.parseInt(parts[2]));
						al.add(Integer.parseInt(parts[3]));
						al.add(Integer.parseInt(parts[4]));
						al.add(Integer.parseInt(parts[5]));
						for(int i = 0; i < al.get(3); i++)
							vehicles.add(new Vehicle());
					}
					else {
						Ride r = new Ride(new Coordinate(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])),
											new Coordinate(Integer.parseInt(parts[2]), Integer.parseInt(parts[3])),
											Integer.parseInt(parts[4]), Integer.parseInt(parts[5]));
						rides.add(r);
					}
					al.add(0, al.get(0) + 1);;
				});
		R = al.get(1);
		C = al.get(2);
		F = al.get(3);
		N = al.get(4);
		B = al.get(5);
		T = al.get(6);
	}	

	void write(String arg, Collection<Vehicle> vehicles) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(arg, "UTF-8");
		String r = "";
		for(Vehicle v : vehicles)
			r += v.getAssignedRides() + "\n";
		writer.print(r);
		writer.close();
	}
	
	
}
