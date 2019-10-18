import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Factorial {
	static BigInteger[] factorial;
	public static BigInteger factorial(int n) {
		if(factorial[n] != null) {
			return factorial[n];
		}
		factorial[n] = factorial(n-1).multiply(new BigInteger(Integer.toString(n)));
		return factorial[n];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
		int n = Integer.parseInt(br.readLine());
		factorial = new BigInteger[n+1];
		factorial[1] = BigInteger.ONE;
		bw.write(factorial(n) + "\n");
		br.close();
		bw.close();
	}
}
