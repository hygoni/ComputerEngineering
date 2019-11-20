import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Week10_BFS {
	public static void bfs(String v) {
		Queue<String> q = new LinkedList<String>();
		q.add(v);
		visited.put(v, true);
		System.out.print(v + " ");
		while(!q.isEmpty()) {
			v = q.poll();
			Iterator<String> iter = graph.get(v).iterator();
			while(iter.hasNext()) {
				String v_ = iter.next();
				if(!visited.getOrDefault(v_, false)) {
					visited.put(v_, true);
					q.add(v_);
					System.out.print(v_ + " ");
				}
			}
		}
		System.out.println();
	}
	static Map<String, Boolean> visited = new HashMap<String, Boolean>();
	static Map<String, SortedSet<String>> graph = new HashMap<String, SortedSet<String>>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			String v = st.nextToken();
			graph.put(v, new TreeSet<String>());
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			String e = st.nextToken();
			graph.get(s).add(e);
		}
		
		String start = br.readLine();
		bfs(start);
		br.close();
	}
}
