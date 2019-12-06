import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxSum {
	static int d[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		int d[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		d[0] = arr[0];
		int answer = d[0];
		for(int i = 1; i < n; i++) {
			d[i] = Math.max(d[i-1] + arr[i], arr[i]);
			answer = Math.max(answer, d[i]);
		}
		
		System.out.println(answer);
		br.close();
	}
}
