public class Philosophers {
	public static void main(String[] args) {
		Chopstick[] sticks = new Chopstick[5];
		for(int i = 0; i < sticks.length; i++) {
			sticks[i] = new Chopstick(i);
		}
		
		Thread[] philosophers = new Thread[5];
		for(int i = 0; i < philosophers.length; i++) {
			philosophers[i] = new Thread(new PhilosopherRunnable("철학자 " + (i+1), sticks[i % 5], sticks[(i+1) % 5]));
			philosophers[i].start();
		}
	}
}