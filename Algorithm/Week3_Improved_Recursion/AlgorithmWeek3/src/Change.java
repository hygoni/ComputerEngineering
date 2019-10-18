import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Change {
	
	static int INF = Integer.MAX_VALUE;
	static int cache[];
	static int coins[];
	
	private static int count(int money, int cnt) {
		if(money == 0) {
			return cnt;
		}
		if(cache[money] > 0) {
			return cache[money];
		}
		int min = INF;
		for(int i = 0; i < coins.length; i++) {
			int coin = coins[i];
			if(coin > money) {
				continue;
			}	
			int result = count(money - coin, 0) + 1;
			if(result < min) {
				min = result;
			}
		}
		cache[money] = min;
		return min;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		coins = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(st.nextToken());
		}
		
		//System.out.println("Recursion");
		int money = Integer.parseInt(br.readLine());
		cache = new int[money + 1];
		double start = System.currentTimeMillis();
		bw.write(count(money, 0) + "\n");
		double end = System.currentTimeMillis();
		//bw.write("시간 : " + (end - start) / 1000 + "\n");
		br.close();
		bw.close();
	}
}
