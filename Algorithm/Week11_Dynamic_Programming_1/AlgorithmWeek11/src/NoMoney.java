import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Location implements Comparable<Location> {
	int x;
	int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Location o) {
		return 0;
	}
}

class Vector implements Comparable<Vector>{
	int v;
	int cost;
	int h;

	public Vector(int v, int cost, int h) {
		this.v = v;
		this.cost = cost;
		this.h = h;
	}

	@Override
	public int compareTo(Vector o) {
		return Integer.compare(this.cost + this.h, o.cost + o.h);
	}
}
public class NoMoney {
	static int w, h;
	static char map[][];
	static int dist(int a, int b) {
		int x1 = a % w;
		int y1 = a / w;
		int x2 = b % w;
		int y2 = b / w;
		return (int) Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
	}
	static final int INF = Integer.MAX_VALUE;
	static Map<String, Boolean> visited = new HashMap<String, Boolean>();
	static Map<Integer, LinkedList<Vector>> graph = new HashMap<Integer, LinkedList<Vector>>();
	public static int astar(int start, int end) {
		Map<Integer, Integer> dist = new HashMap<Integer, Integer>();
		Map<Integer, Integer> prev = new HashMap<Integer, Integer>();

		Iterator<Integer> iterV = graph.keySet().iterator();
		while(iterV.hasNext()) {
			int v = iterV.next();
			dist.put(v, INF);
		}
		dist.put(start, 0);
		
		PriorityQueue<Vector> q = new PriorityQueue<Vector>();
		q.add(new Vector(start, 0, dist(start, end)));
		
		while(!q.isEmpty()) {
			Vector now = q.poll();
			if(dist.get(now.v) > now.cost) {
				continue;
			}
			Iterator<Vector> iterVector = graph.get(now.v).iterator();
			while(iterVector.hasNext()) {
				Vector next = iterVector.next();
				if(dist.get(next.v) > dist.get(now.v) + next.cost) {
					dist.put(next.v, dist.get(now.v) + next.cost);
					prev.put(next.v, now.v);
					q.add(new Vector(next.v, dist.get(next.v), dist(next.v, end)));
				}
			}
		}
		
		//이동경로 추적
		int moneySpent = 0;
		Integer previous = end;
		while(previous != null) {
			int x = previous % w;
			int y = previous / w;
			if(map[y][x] != 'S' && map[y][x] != 'E' && map[y][x] != 'W') {
				moneySpent += map[y][x] - '0';
			}
			previous = prev.get(previous);
		}
		return moneySpent;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());
		map = new char[h][w];
		int start = 0;
		int end = 0;
		for(int i = 0; i < h; i++) {
			String line = br.readLine();
			for(int j = 0; j < w; j++) {
				graph.put(w*i+j, new LinkedList<Vector>());
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'S') {
					start = w*i+j;
				}
				if(map[i][j] == 'E') {
					end = w*i+j;
				}
			}
		}
		br.close();

		//up, down, left, right
		int dx[] = {1, -1, 0, 0};
		int dy[] = {0, 0, -1, 1};
		//Generating graph from map
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				for(int k = 0; k < 4; k++) {
					int x = j + dx[k];
					int y = i + dy[k];
					if(0 <= x && x < w && 0 <= y && y < h) {
						if(map[y][x] == 'E' || map[y][x] == 'S') {
							graph.get(w*i+j).add(new Vector(w*y+x, 0, dist(w*i+j, end)));
						} else if(map[y][x] != 'W') {
							int cost = map[y][x] - '0';
							graph.get(w*i+j).add(new Vector(w*y+x, cost, dist(w*i+j, end)));
						}
					}
				}
			}
		}
		
		int moneySpent = astar(start, end);
		if(money < moneySpent) {
			System.out.println("Not enough money!");
		} else {
			System.out.println(money - moneySpent);
		}
	}
}
