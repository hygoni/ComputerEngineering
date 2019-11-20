import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import library.Pair;

public class Week10_Dijkstra {
	static final int INF = Integer.MAX_VALUE;
	static Map<String, Boolean> visited = new HashMap<String, Boolean>();
	static Map<String, LinkedList<Pair>> graph = new HashMap<String, LinkedList<Pair>>();
	public static void dijkstra(String start, String end) {
		Map<String, Integer> dist = new HashMap<String, Integer>();
		Map<String, String> prev = new HashMap<String, String>();
		Iterator<String> iter = graph.keySet().iterator();
		while(iter.hasNext()) {
			String v = iter.next();
			dist.put(v, INF);
		}
		dist.put(start, 0);
		
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		q.add(new Pair(start, 0));
		
		while(!q.isEmpty()) {
			Pair now = q.poll();
			if(dist.get(now.v) > now.cost) {
				continue;
			}
			Iterator<Pair> iterPair = graph.get(now.v).iterator();
			while(iterPair.hasNext()) {
				Pair next = iterPair.next();
				if(dist.get(next.v) > dist.get(now.v) + next.cost) {
					dist.put(next.v, dist.get(now.v) + next.cost);
					prev.put(next.v, now.v);
					q.add(new Pair(next.v, dist.get(next.v)));
				}
			}
		}
		
		String previous = end;
		Deque<String> stack = new LinkedList<String>();
		while(previous != null) {
			stack.push(previous);
			previous = prev.get(previous);
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
		System.out.println(dist.get(end));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			String v = st.nextToken();
			graph.put(v, new LinkedList<Pair>());
		}

		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			String e = st.nextToken();
			int cost = Integer.parseInt(st.nextToken());
			graph.get(s).add(new Pair(e, cost));
		}

		String start = br.readLine();
		String end = br.readLine();
		dijkstra(start, end);
		br.close();
	}
}
