package source;

import java.io.IOException;

public class HashCode {

	public static void main(String[] args) throws IOException {
		boardSchedule(args);
	}
	
	public static void boardSchedule(String[] args) throws IOException {
		for(String arg : args) {
			
			Controller.getInstance().run(new BoardScheduler((r, v, t, T, F, N, B, R, C) -> {
				if(t + v.position.distance(r.si) + r.si.distance(r.fi) > r.lf)
					return Integer.MIN_VALUE;
				else {
					return ((t + v.position.distance(r.si) <= r.es) ? B : 0) -
							v.position.distance(r.si) -
							((t + v.position.distance(r.si) < r.es) ? r.es - t - v.position.distance(r.si) : 0);
				}
			}), arg);
			
		}
	}

}
