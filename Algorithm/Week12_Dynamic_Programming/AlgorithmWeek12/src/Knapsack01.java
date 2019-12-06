import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Knapsack01 {
	static int n, k;
	static int weight[], value[], d[][];
	public static int pack(int capacity, int item) {
		if(item == n+1) {
			return 0;
		}
		
		int ret = d[capacity][item];
		if(ret > 0) {
			return ret;
		}
		
		ret = pack(capacity, item + 1); //not picking this item
		if(capacity >= weight[item]) {
			ret = Math.max(ret, pack(capacity - weight[item], item + 1) + value[item]);
		}
		d[capacity][item] = ret;
		return ret;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		d = new int[k+1][n+1];
		weight = new int[k+1];
		value = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			int w = Integer.parseInt(st.nextToken());
			weight[i] = w;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			int v = Integer.parseInt(st.nextToken());
			value[i] = v;
		}

		
		System.out.println(pack(k, 1));
		br.close();
	}
}
