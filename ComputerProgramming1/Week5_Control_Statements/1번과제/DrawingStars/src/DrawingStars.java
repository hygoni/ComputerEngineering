
public class DrawingStars {
	
	//절댓값 함수, num < 0이면 -num, num >= 0이면 num 반환
	private static int abs(int num) {
		return (num < 0) ? -num : num;
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 9; i++) { //아홉줄
			
			//점 출력 : abs(4-i)개 : 4, 3, 2, 1, 2, 3, 4개
			for(int j = 0; j < abs(4-i); j++) {
				System.out.print(" ");
			}
			
			//별 출력 : 9- 2*abs(4-i) : 1, 3, 5, 7, 9, 7, 5, 3, 1개
			for(int j = 0; j < 9 - 2*abs(4-i); j+=1) {
				System.out.print("*");
			}
			
			//엔터 출력
			System.out.println("");
		}
	}

}
  