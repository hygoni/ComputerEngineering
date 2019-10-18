import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class QuickSort {
	static int m;
	static int cnt;
	static int isAscending;
	public static void quickSort(String[] arr, int low, int high) {
		if(cnt == m) {
			return;
		}
		if(low < high) {
			int p = partition(arr, low, high);
			quickSort(arr, low, p-1);
			quickSort(arr, p+1, high);
		}
	}

	public static int partition(String[] arr, int low, int high) {
		cnt++;
		String pivot = arr[high];
		int i = low;
		for(int j = low; j <= high - 1; j++) {
			if(isAscending * arr[j].compareTo(pivot) <= 0) {
				String tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++; //이 부분 참고
			}
		}
		String tmp = arr[i];
		arr[i] = arr[high];
		arr[high] = tmp;
		return i;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		String ch = st.nextToken(); // Asc or Desc
		String[] arr = new String[n];
		isAscending = (ch.equals("D")) ? -1 : 1;
		cnt = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = st.nextToken();
		}
		
		quickSort(arr, 0, n-1);
		
		for(int i = 0; i < arr.length; i++) {
			bw.write(arr[i]);
			bw.write(" ");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}
