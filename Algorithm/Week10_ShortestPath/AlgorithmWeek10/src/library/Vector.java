package library;

public class Vector implements Comparable<Vector>{
	public int v;
	public int cost;
	public int h;

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