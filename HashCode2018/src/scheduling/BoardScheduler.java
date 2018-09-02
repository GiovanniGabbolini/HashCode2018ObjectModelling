package scheduling;


import java.util.ArrayList;
import java.util.Collection;
import java.util.PriorityQueue;

import source.IScheduler;
import source.Ride;
import source.Vehicle;

public class BoardScheduler implements IScheduler{
	
	public IBoardSchedulerScore i;
	
	public BoardScheduler(IBoardSchedulerScore i) {
		this.i = i;
	}
	
	@Override
	public Collection<Vehicle> assignRides(ArrayList<Ride> rides, ArrayList<Vehicle> vehicles, int T, int F, int N, int B,
			int R, int C) {
		int t = 0;
		while(t < T && !rides.isEmpty()) {
			for(Vehicle v : vehicles) 
				if(v.isFree(t)) {
					PriorityQueue<RideVehicle> q = new PriorityQueue<>();
					for(Ride r : rides)
						if(!q.isEmpty() && i.computeScore(r, v, t, T, F, N, B, R, C) > q.peek().score || q.isEmpty())
							q.add(new RideVehicle(t, v, r, B, i.computeScore(r, v, t,  T, F, N, B, R, C)));
				}
			t++;
		}
		return vehicles;
	}
	
	private static class RideVehicle implements Comparable<RideVehicle>{
		int score, timeInstant, bonus;
		public Ride ride;
		public Vehicle vehicle;
		
		public RideVehicle(int timeInstant, Vehicle vehicle, Ride ride, int bonus, int score) {
			this.timeInstant = timeInstant;
			this.bonus = bonus;
			this.ride = ride;
			this.vehicle = vehicle;
			this.score = score;
		}
		
		@Override
		public int compareTo(RideVehicle o) {
			if(score < o.score)
				return -1;
			else if (score > o.score)
				return 1;
			else
				return 0;
		}
		
	}
	
	public interface IBoardSchedulerScore {
		
		public int computeScore(Ride rides, Vehicle vehicles, int t, int T, int F, int N, int B, int R, int C);

	}

}

