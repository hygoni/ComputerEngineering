import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Fibonacci {
	static BigInteger[] fibo;
	
	public static BigInteger fibo(int n) {
		if(fibo[n] != null) {
			return fibo[n];
		}
		fibo[n] = fibo(n-1).add(fibo(n-2));
		return fibo[n];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		fibo = new BigInteger[n+1];
		fibo[0] = BigInteger.ZERO;
		fibo[1] = BigInteger.ONE;
		bw.write(fibo(n) + "\n");
		br.close();
		bw.close();
	}
}
