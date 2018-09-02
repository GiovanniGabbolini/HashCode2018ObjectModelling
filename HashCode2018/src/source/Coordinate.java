package source;

public class Coordinate {
	
	int x, y;

	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int distance(Coordinate c1) {
		return Math.abs(this.x - c1.x) + Math.abs(this.y - c1.y);
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Coordinate))
			return false;
		else
			return x == ((Coordinate)obj).x && y == ((Coordinate)obj).y;
	}
}
