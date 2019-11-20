package library;

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
