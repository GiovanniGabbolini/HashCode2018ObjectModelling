package source;

public class Ride {
	
	boolean completed;
	Coordinate si, fi;
	int es, lf, code;
	
	public Ride(Coordinate si, Coordinate fi, int es, int lf, int c) {
		this.completed = false;
		this.si = si;
		this.fi = fi;
		this.es = es;
		this.lf = lf;
		this.code = c;
	}
	
	public boolean isCompleted() {
		return completed;
	}

	public Coordinate getSi() {
		return si;
	}

	public Coordinate getFi() {
		return fi;
	}

	public int getEs() {
		return es;
	}

	public int getLf() {
		return lf;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Ride))
	        return false;
		else
			return this.code == ((Ride) obj).code;
	}
}
