import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hanoi {
	static StringBuilder sb;
	public static void hanoi(int from, int to, int n, int depth) {
		if(n == 1) {
			sb.append(depth + ": ").append( (char) (from-1+'A') + " -> " + (char) (to-1+'A')).append("\n");
			return;
		}
		int another = 6 - from - to; //1 + 2 + 3 = 6
		hanoi(from, another, n-1, depth-1);
		hanoi(from, to, 1, depth);
		hanoi(another, to, n-1, depth-1);
	}
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter(new File("output.txt"));
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= n; i++) {
			double start = System.currentTimeMillis();
			sb.append(i).append(" 번째  하노이 탑\n");
			hanoi(1, 3, i, i);
			System.out.println(sb);
			sb = new StringBuilder();
			double end = System.currentTimeMillis();
			int time = (int) (end - start);
			fw.write(Integer.toString(time));
			if(i != n) {
				fw.write(", ");
			}
		}
		fw.close();
	}
}
