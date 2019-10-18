import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Fibonacci {
	
	static long[] fibo;
	
	public static long fibo(int n) {
		if(n == 0 | n == 1) {
			return n;
		}

		if(fibo[n] != 0) {
			return fibo[n];
		}
		
		return fibo(n-1) + fibo(n-2);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		fibo = new long[n+1];
		
		bw.write(fibo(n) + "\n");
		br.close();
		bw.close();
	}
}
