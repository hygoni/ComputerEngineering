
public class Plane {

	private String modelName;
	private String vendor;
	private int maxPassengers;
	
	//totalPlanes는 모든 인스턴스가 공유하는 변수이므로 static 변수로 선언함.
	private static int totalPlanes = 0;
	
	
	/*
	 * 생성자
	 * */

	public Plane(String modelName, String vendor, int maxPassengers) {
		this.modelName = modelName;
		this.vendor = vendor;
		this.maxPassengers = maxPassengers;
		totalPlanes++;
	}
	
	public Plane(String modelName, String vendor) {
		this(modelName, vendor, 100);
	}
	
	public Plane(String vendor, int maxPassengers) {
		this("Noname", vendor, maxPassengers);
	}
	
	public Plane() {
		this("Noname", "Korea", 100);
	}
	
	/*
	 * Getters & Setters
	 * */
	
	public String getModelName() {
		return modelName;
	}
	
	public String getVendor() {
		return vendor;
	}
	
	public int getMaxPassengers() {
		return maxPassengers;
	}
	
	public static int getPlanes() {
		return totalPlanes;
	}
	
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
	public void setMaxPassengers(int maxPassengers) {
		this.maxPassengers = maxPassengers;
	}
	
	/*
	 * 기타 함수들
	 * */
	
	public void print() {
		System.out.printf("안녕 내 이름은 %s이야.\n", modelName);
		System.out.printf("나는 %s 회사 제품이야.\n", vendor);
		System.out.printf("나는 %d명까지 태울 수 있어!\n", maxPassengers);
	}
	
}
