
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

class Pair implements Comparable<Pair> {
	String v;
	Integer cost;

	public Pair(String v, Integer cost) {
		this.v = v;
		this.cost = cost;
	}
	
	@Override
	public boolean equals(Object o) {
		Pair other = (Pair) o;
		return this.v.equals(other.v);
	}
	
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.cost, o.cost);
	}

}
public class Drone {
	static final int INF = Integer.MAX_VALUE;
	static Map<String, Boolean> visited = new HashMap<String, Boolean>();
	static Map<String, LinkedList<Pair>> graph = new HashMap<String, LinkedList<Pair>>();
	static Map<String, Integer> delay = new HashMap<String, Integer>();
	public static int dijkstra(String start, String end) {
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
			Iterator<Pair> iterPair = graph.get(now.v).iterator();
			while(iterPair.hasNext()) {
				Pair next = iterPair.next();
				if(dist.get(next.v) > dist.get(now.v) + next.cost + delay.get(now.v)) {
					dist.put(next.v, dist.get(now.v) + next.cost + delay.get(now.v));
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
		return (dist.get(end));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		//인접리스트 생성
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			String v = st.nextToken();
			graph.put(v, new LinkedList<Pair>());
		}
		
		//노드에서의 충전 시간 저장
		for(int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			String node = st.nextToken();
			int delayTime = Integer.parseInt(st.nextToken());
			delay.put(node, delayTime);
		}
		
		//간선 저장
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			String e = st.nextToken();
			int cost = Integer.parseInt(st.nextToken());
			graph.get(s).add(new Pair(e, cost));
		}

		String start = br.readLine();
		String end = br.readLine();
		int dist = dijkstra(start, end);
		System.out.println(dist - delay.get(start)); //시작정점에서는 딜레이가 없으므로 그만큼 빼준다.
		br.close();
	}
}
