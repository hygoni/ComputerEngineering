import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MrDriller {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int map[][] = new int[m][n]; //map[y][x]
		int d[][] = new int[m][n];
		
		for(int y = 0; y < m; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x = 0; x < n; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			d[0][i] = map[0][i];
		}
		
		int dx[] = {1, -1, 0};
		for(int i = 1; i < m; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < 3; k++) {
					int x = dx[k] + j;
					if(0 <= x && x < n) {
						d[i][j] = Math.max(d[i][j], d[i-1][x]);
					}
				}
				d[i][j] += map[i][j];
			}
		}
		
		int answer = 0;
		for(int i = 0; i < n; i++) {
			answer = Math.max(answer, d[m-1][i]);
		}
		
		System.out.println(answer);
		br.close();
	}
}
