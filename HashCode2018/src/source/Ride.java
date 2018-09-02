package source;

public class Ride {
	
	public boolean completed;
	public Coordinate si, fi;
	public int es, lf, code;
	static int c = 0;
	
	public Ride(Coordinate si, Coordinate fi, int es, int lf) {
		this.completed = false;
		this.si = si;
		this.fi = fi;
		this.es = es;
		this.lf = lf;
		this.code = c;
		c++;
	}
	
	public static void zeroCounter() {
		c = 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Ride))
	        return false;
		else
			return this.code == ((Ride) obj).code;
	}
}
