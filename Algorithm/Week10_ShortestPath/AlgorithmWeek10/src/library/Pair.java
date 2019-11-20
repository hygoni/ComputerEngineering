package library;
public class Pair implements Comparable<Pair> {
	public String v;
	public Integer cost;

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
