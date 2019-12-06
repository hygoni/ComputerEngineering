import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Change {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int coin[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(st.nextToken());
		}
		
		int money = Integer.parseInt(br.readLine());
		int d[] = new int[money+1];
		
		for(int i = 1; i <= money; i++) {
			d[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < coin.length; i++) {
			d[coin[i]] = 1;
		}
		
		for(int i = 1; i <= money; i++) {
			for(int j = 0; j < coin.length; j++) {
				if(i >= coin[j]) {
					d[i] = Math.min(d[i], d[i-coin[j]] + 1);
				}
			}
		}
		
		System.out.println(d[money]);
		br.close();
	}
}
