import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class HorseRunnable implements Runnable {
	static int completed = 0;
	int num;
	int dist;
	public HorseRunnable(int num) {
		this.num = num;
		this.dist = 0;
	}
	
	@Override
	public void run() {
		while(dist <= 100) { //100m을 넘으면 골인 -> 100m를 초과해야 골인, 그 전까지는 계속 달림
			try {
				int randInt = new Random().nextInt(11);
				dist += (randInt);
				int sleepTime = 1000;
				if(new Random().nextInt(10) == 1) { //10% 확률
					sleepTime += 100;
				}
				System.out.printf("%d번 말은 지금 %dm에 있습니다.\n", num, dist);
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("%d번  말이  %d등으로 들어왔습니다.\n", num, completed+1);
		Racing.q.add(num);
		completed++;
	}
	
}
public class Racing {
	static Queue<Integer> q = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("5마리의 말이 100m 경주를 합니다.");
		System.out.print("말 번호를 고르세요.(1~5): ");
		int n = Integer.parseInt(br.readLine());
		System.out.printf("%d번 말을 고르셨습니다.\n", n);
		
		//1~5번 스레드 초기화 및 실행
		Thread[] threads = new Thread[5];
		for(int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new HorseRunnable(i+1));
			threads[i].start();
		}
		
		//모든 스레드가 끝날 때까지 대기한다.
		for(int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//결과 출력
		System.out.println("### 경기 결과 ###");
		for(int i = 0; i < threads.length; i++) {
			int num = q.poll();
			System.out.printf("[%d등] : %d번 말", i+1, num);
			if(num == n) {
				System.out.print("        <--- 당신이 고른 말");
			}
			System.out.println();
		}
	}
}
