import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
	int stickNum;
	ReentrantLock lock;
	
	public Chopstick(int stickNum) {
		this.stickNum = stickNum;
		this.lock = new ReentrantLock();
	}
		

	public int getStickNum() {
		return stickNum;
	}
}