import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class POS {
	
	static int min = Integer.MAX_VALUE;
	
	public static void count(int coins[], int charge, int cnt) {
		
		if(charge == 0) {
			if(cnt < min ) {
				min = cnt;
			}
		}
		
		for(int i = 0; i < coins.length; i++) {
			int d = coins[i];
			if(d > charge) {
				continue;
			}
			count(coins, charge - d, cnt+1);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int coins[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(st.nextToken());
		}
		
		int money = Integer.parseInt(br.readLine());
		count(coins, money, 0);
		bw.write(min + "\n");
		br.close();
		bw.close();
	}
}
