import java.util.concurrent.TimeUnit;

public class PhilosopherRunnable implements Runnable {
	String name;
	Chopstick left, right;
	boolean isFull = false;

	public PhilosopherRunnable(String name, Chopstick left, Chopstick right) {
		this.name = name;
		this.left = left;
		this.right = right;
	}

	@Override
	public void run() {
		while(!isFull) {
			try {
				if(getStick(left) && getStick(right)) {
					eat();
					returnSticks();
					think();
				} else {
					returnSticks();	
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void returnSticks() {
		if(left.lock.isHeldByCurrentThread()) {
			left.lock.unlock();
			System.out.printf("%s가 %d번 젓가락을 놓았습니다!\n", name, left.getStickNum());
		}
		if(right.lock.isHeldByCurrentThread()) {
			right.lock.unlock();
			System.out.printf("%s가 %d번 젓가락을 놓았습니다!\n", name, right.getStickNum());
		}
	}

	public boolean getStick(Chopstick stick) throws InterruptedException {
		if(stick.lock.tryLock(100, TimeUnit.MILLISECONDS)) {
			System.out.printf("%s가 %d번 젓가락을 들었습니다!\n", name, stick.getStickNum());
			return true;
		} else {
			return false;
		}
	}

	public void eat() {
		System.out.printf("%s가  스파게티를 먹는중...\n", name);
		isFull = true;
	}

	public void think() {
		try {
			System.out.printf("%s가 생각중...\n", name);
			Thread.sleep((long)(Math.random() % 100));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
