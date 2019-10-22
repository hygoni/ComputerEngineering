import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class DFS {
	static HashMap<String, SortedSet<String>>graph;
	static HashMap<String, Boolean> visited;
	static StringBuilder sb;
	
	public static void dfs(String v) {
		visited.put(v, true);
		sb.append(v).append(" ");
		for(String v_ : graph.get(v)) {
			if(!visited.get(v_)) {
				dfs(v_);
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
		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
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
		dfs(name);
		System.out.println(sb);
		br.close();
	}
}
