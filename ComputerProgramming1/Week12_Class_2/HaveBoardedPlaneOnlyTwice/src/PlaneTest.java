
public class PlaneTest {
	public static void main(String args[]) {
		
		Plane[] planes = new Plane[6]; //Plane 객체의 참조변수 배열 생성
		
		/* 각각의 참조변수 초기화 */
		planes[0] = new Plane("Hygon-2000", "Home", 10000);
		planes[1] = new Plane("Hygon-2014", "BMS", 50000);
		planes[2] = new Plane("Hygon-2019", "CNU", 10000);
		planes[3] = new Plane("IloveTravel", "Earth");
		planes[4] = new Plane("IloveGoogle", 100);
		planes[5] = new Plane();
		
		/* 총 비행기 수 출력 */
		System.out.println("총 비행기 수 : " + Plane.getPlanes());
		
		/* 각각의 비행기 정보 출력 */
		for(Plane plane : planes) {
			plane.print();
		}
	}
}
