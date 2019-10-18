
public class IsMoreThanTenMinutes_ {
	
	public static void main(String[] args) {
		
		final int LIGHT_SPEED = 300_000; // km/s
		final int DISTANCE_FROM_EARTH_TO_SUN = 150_000_000;
		final int TIME_SPENT = DISTANCE_FROM_EARTH_TO_SUN / LIGHT_SPEED; //시간 = 거리/속도

		
		final int seconds = TIME_SPENT % 60;
		final int minutes = TIME_SPENT / 60; 
		
		System.out.printf("빛이 태양에서 출발하여 지구까지 오는 시간 : %d분 %d초\n", minutes, seconds);
		System.out.println("질문 : 태양에서 출발하여 지구까지 오는 시간은 10분이 넘는다");
		System.out.println("대답 : " + (TIME_SPENT > 600));
	}
	
	
}
