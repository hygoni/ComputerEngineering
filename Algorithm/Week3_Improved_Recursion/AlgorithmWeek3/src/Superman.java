import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Superman {

	static BigInteger stairs[];
	public static BigInteger stairs(int n, int max) {
		if(!stairs[n].equals(BigInteger.ZERO)) {
			return stairs[n]; 
		} 
		for(int i = 1; i <= n; i++) {
			if(i < max) {
				for(int j = 1; j <= i; j++) {
					stairs[i] = stairs[i].add(stairs(i-j, max));
				}
			} else {
				for(int j = 1; j <= max; j++) {
					stairs[i] = stairs[i].add(stairs(i-j, max));
				}
			}
		}
		return stairs[n];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());	
		stairs = new BigInteger[n+1];
		stairs[0] = BigInteger.ONE;
		for(int i = 1; i <= n; i++) {
			stairs[i] = BigInteger.ZERO;
		}

		bw.write(stairs(n, m) + "\n");
		br.close();
		bw.close();
	}
}
