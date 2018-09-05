package scheduling;

import java.io.IOException;
import source.Controller;

public class HashCode {

	public static void main(String[] args) throws IOException {
		boardSchedule(args);
	}
	
	public static void boardSchedule(String[] args) throws IOException {
		for(String arg : args) {
			Controller c = new Controller(new BoardScheduler((r, v, t, T, F, N, B, R, C) -> {
				if(t + v.getPosition().distance(r.getSi()) + r.getSi().distance(r.getFi()) > r.getLf())
					return Integer.MIN_VALUE;
				else {
					return ((t + v.getPosition().distance(r.getSi()) <= r.getEs()) ? B : 0) -
							v.getPosition().distance(r.getSi()) -
							((t + v.getPosition().distance(r.getSi()) < r.getEs()) ? r.getEs() - t - v.getPosition().distance(r.getSi()) : 0);
				}
			}));
			c.run(arg);
		}
	}

}
