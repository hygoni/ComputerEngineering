import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;
import library.Pair;

public class Week10_BellmanFord {
	static final int INF = Integer.MAX_VALUE;
	static Map<String, Boolean> visited = new HashMap<String, Boolean>();
	static Map<String, LinkedList<Pair>> graph = new HashMap<String, LinkedList<Pair>>();
	public static void bellmanFord(String start, String end) {
		Map<String, Integer> dist = new HashMap<String, Integer>();
		Map<String, String> prev = new HashMap<String, String>();

		Iterator<String> iterV = graph.keySet().iterator();
		while(iterV.hasNext()) {
			String v = iterV.next();
			dist.put(v, INF);
		}
		dist.put(start, 0);

		boolean updated = false;
		for(int i = 0; i <= dist.keySet().size(); i++) {
			updated = false;
			iterV = graph.keySet().iterator();
			while(iterV.hasNext()) {
				String v = iterV.next();
				Iterator<Pair> iterE = graph.get(v).iterator();
				while(iterE.hasNext()) {
					Pair p = iterE.next();
					if(dist.get(v) != INF && dist.get(p.v) > dist.get(v) + p.cost) {
						dist.put(p.v, dist.get(v) + p.cost);
						prev.put(p.v, v);
						updated = true;
					}
				}
			}
		}
		if(updated) {
			System.out.println("Negative Cycle!");
		} else {
			String previous = end;
			Deque<String> stack = new LinkedList<String>();
			while(previous != null){
				stack.push(previous);
				previous = prev.get(previous);
			}
			while(!stack.isEmpty()) {
				System.out.print(stack.pop() + " ");
			}
			System.out.println();
			System.out.println(dist.get(end));			
		}
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
		bellmanFord(start, end);
		br.close();
	}
}
