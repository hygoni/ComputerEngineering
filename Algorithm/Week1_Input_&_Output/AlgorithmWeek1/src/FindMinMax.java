import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindMinMax {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int i = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] array = new int[n];
		
		for(int j = 0; j < n; j++) {
			array[j] = Integer.parseInt(st.nextToken()); //수열 저장
		}
		
		Arrays.sort(array); //배열 정렬
		System.out.println(Math.abs(array[k-1] - array[array.length-i])); //k번째로 작은 수 (array[k-1]), i번째로 큰 수 (array[array.length-i])의 차 출력		
		br.close(); //자원 반환
	}
}
