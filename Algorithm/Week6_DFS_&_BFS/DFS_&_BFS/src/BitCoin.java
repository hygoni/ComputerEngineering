import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BitCoin {
	static HashMap<String, SortedSet<String>>graph;
	static HashMap<String, Boolean> visited;
	static HashMap<String, Integer> time;

	public static void bfs(String v) {
		Queue<String> q = new LinkedList<String>();
		visited.put(v, true);
		q.add(v);
		while(!q.isEmpty()){
			v = q.poll();
			int timeVal = time.getOrDefault(v, 0);
			for(String v_ : graph.get(v)) {
				if(!visited.get(v_)) {
					visited.put(v_, true);
					q.add(v_);
					time.put(v_, timeVal+1);
				}
			}

		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int vertexes = Integer.parseInt(st.nextToken());
		int edges = Integer.parseInt(st.nextToken());
		graph = new HashMap<String, SortedSet<String>>();
		visited = new HashMap<String, Boolean>();
		time = new HashMap<String, Integer>();
		st = new StringTokenizer(br.readLine());

		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			graph.put(token, new TreeSet<String>());
			visited.put(token, false);
		}

		for(int i = 0; i < edges; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			String e = st.nextToken();
			graph.get(s).add(e);
			graph.get(e).add(s);
		}

		String name = br.readLine();
		bfs(name);
		int maxTime = 0;
		for(String key : time.keySet()) {
			maxTime = Math.max(maxTime, time.get(key));
		}
		System.out.println(maxTime);
		br.close();
	}
}
