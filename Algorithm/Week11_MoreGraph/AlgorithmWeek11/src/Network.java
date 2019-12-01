
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Network {
	static int V, E;
	static final int INF = Integer.MAX_VALUE;
	//2차원 HashMap을 사용해서 좀 지저분할 수 있습니다.
	static HashMap<String, HashMap<String, Integer>> residual = new HashMap<>();
	static HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();
	static HashMap<String, String> prev = new HashMap<>();
	
	//일반적인 BFS로, 여유 용량이 있는 경우에만 정점 순회
	public static boolean bfs(String src, String dst) {
		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
		Queue<String> q = new LinkedList<String>();
		visited.put(src, true);
		q.add(src);
		
		while(!q.isEmpty()) {
			String u = q.poll();
			Iterator<String> iter = graph.get(u).keySet().iterator();
			while(iter.hasNext()) {
				String v = iter.next();
				if(!visited.getOrDefault(v, false) && residual.get(u).getOrDefault(v, 0) > 0) {
					visited.put(v, true);
					q.add(v);
					prev.put(v, u);
				}
			}
		}
		return visited.getOrDefault(dst, false);
	}
	
	public static int fordFulkerson(String src, String dst) {
		int maxFlow = 0;
		//증가 경로가 존재하는가?
		while(bfs(src, dst)) {
			int pathFlow = INF;
			for(String v = dst; !v.equals(src); v = prev.get(v)) {
				String u = prev.get(v);
				pathFlow = Math.min(pathFlow, residual.get(u).get(v));
			}
			for(String v = dst; !v.equals(src); v = prev.get(v)) {
				String u = prev.get(v);
				residual.get(u).put(v, residual.get(u).get(v) - pathFlow);
				//a->b의 유량 변화는 b->a의 유량 변화와 반대 (이 성질로 최대 유량을 찾을 수 있음.)
				residual.get(v).put(u, residual.get(v).get(u) + pathFlow);
			}
			//가능한 모든 경로에 대한 유량을 더한 것이 최대 유량임.
			maxFlow += pathFlow;
		}
		return maxFlow;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int amount = Integer.parseInt(st.nextToken());
		
		//해쉬맵같지만 인접행렬같은 해쉬맵 생성
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			String node = st.nextToken();
			residual.put(node, new HashMap<>());
			graph.put(node, new HashMap<>());
		}
		
		//간선 저장
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			String e = st.nextToken();
			int cost = Integer.parseInt(st.nextToken());
			graph.get(s).put(e, cost);
			graph.get(e).put(s, cost);
			residual.get(s).put(e, cost);
			residual.get(e).put(s, cost);
		}
		
		//최대 데이터 전송량을 구한 후 시간을 구한다. (전송량 / 전송 속도 = 시간)
		String src = br.readLine();
		String dst = br.readLine();
		double maxFlow = fordFulkerson(src, dst);
		System.out.println((int) Math.ceil(amount / maxFlow));
		
		br.close();
	}
}
