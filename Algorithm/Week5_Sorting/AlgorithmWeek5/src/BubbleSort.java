import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BubbleSort {
	public static void bubbleSort(String arr[], int m, int isAscending) {
		int cnt = 0;
		for(int i = arr.length-1; i >= 0; i--) {
			if(cnt == m) {
				break;
			}
			cnt++;
			for(int j = 0; j < i; j++) {
				//isAscending : 오름차순이면 1, 내림차순이면 -1로, compareTo가 들어간 식의 부등호를 역전시키는 역할
				if(isAscending * arr[j].compareTo(arr[j+1]) > 0) {
					String tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String ch = st.nextToken(); // Asc or Desc
		String[] arr = new String[n];
		int isAscending = 1;
		if(ch.equals("D")) {
			isAscending = -1;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = st.nextToken();
		}
		
		bubbleSort(arr, m, isAscending);
		for(int i = 0; i < arr.length; i++) {
			bw.write(arr[i]);
			bw.write(" ");
		}
		
		bw.flush();
		br.close();
		bw.close();
		
	}
}
