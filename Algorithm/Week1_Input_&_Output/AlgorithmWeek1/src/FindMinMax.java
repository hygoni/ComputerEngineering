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
			array[j] = Integer.parseInt(st.nextToken()); //���� ����
		}
		
		Arrays.sort(array); //�迭 ����
		System.out.println(Math.abs(array[k-1] - array[array.length-i])); //k��°�� ���� �� (array[k-1]), i��°�� ū �� (array[array.length-i])�� �� ���		
		br.close(); //�ڿ� ��ȯ
	}
}
