
public class BubbleSort {
	public static void main(String[] args) {
		int[] data = {28, 26, 34, 38, 43, 6, 10};

		for(int i = 0; i < data.length; i++) {
			/*
			 * 버블정렬은 한 번 정렬할 때 마다 가장 큰 원소가 배열의 맨 끝으로 가기때문에
			 * 이를 data.length번 만큼 반복해 모든 원소를 정렬할 수 있음.
			 * */
			for(int j = 0; j < data.length - i - 1; j++) {
				/*
				 * data.length에서 i를 빼는 이유는 i개는 이미 정렬된 원소이기 때문이고
				 * 1을 빼는 이유는 index out of bounds 에러가 뜨기 때문이다. (data[j+1]때문에)
				 * */
				if(data[j] > data[j+1]) { //j번째 원소가 j+1번째 원소보다 크다면
					//data[j]와 data[j+1]을 교환
					int tmp = data[j];
					data[j] = data[j+1];
					data[j+1] = tmp;
				}
			}
		}
		
		for(int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
