import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph {
	static LinkedList<Integer>[] graph;
	static boolean visited[];

	public static void dfs(int v) {
		visited[v] = true;
		for(int v_ : graph[v]) {
			if(visited[v_] == false) {
				dfs(v_);
			}
		}
	}

	public static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		visited[v] = true;

		while(q.isEmpty() == false) {
			v = q.poll();
			for(int v_ : graph[v]) {
				if(visited[v_] == false) {
					q.add(v_);
					visited[v_] = true;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];
		graph = new LinkedList[n+1];
		
		for(int i = 1; i <= n; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph[s].add(e);
			graph[e].add(s);
		}
		
		bfs(1);
		
		br.close();
	}
}
