import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Superman {
	
	static int stairs[];
	static int n, m;
	static int sum = 0;
	
	public static void stairs(int k, int cnt) {
		
		if(k == 0) {
			sum++;
		}
		
		if(k < m) {
			for(int i = 1; i <= k; i++) {
				stairs(k - i, cnt+1);
			}			
		} else {
			for(int i = 1; i <= m; i++) {
				stairs(k - i, cnt+1);
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());		
		stairs(n, 0);
		
		bw.write(sum + "\n");
		br.close();
		bw.close();
	}
}
