import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class MergeSort {
	
	static int m;
	//리스트를 절반으로 나눔
	public static List<String> mergeSort(List<String> arr, int isAscending) {
		if(arr.size() <= 1) {
			return arr;
		}
		
		List<String> left = new LinkedList<String>();
		List<String> right = new LinkedList<String>();
		
		int mid = arr.size()/2;
		for(int i = 0; i < mid; i++) {
			left.add(arr.get(i));
		}
		for(int i = mid; i < arr.size(); i++) {
			right.add(arr.get(i));
		}
		
		left = mergeSort(left, isAscending);
		right = mergeSort(right, isAscending);
		return merge(left, right, isAscending);
	}
	
	//리스트를 정렬하면서 합침
	public static List<String> merge(List<String> left, List<String> right, int isAscending) {
		m--;
		List<String> result = new LinkedList<String>();
		if(m >= 0) {
			while((left.size() != 0) && (right.size() != 0)) {
				if(isAscending * left.get(0).compareTo(right.get(0)) <= 0) {
					result.add(left.remove(0));
				} else {
					result.add(right.remove(0));
				}
			}
			while(left.size() > 0) {
				result.add(left.remove(0));
			}
			while(right.size() > 0) {
				result.add(right.remove(0));
			}
		} else {
			while(left.size() > 0) {
				result.add(left.remove(0));
			}
			while(right.size() > 0) {
				result.add(right.remove(0));
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		String ch = st.nextToken(); // Asc or Desc
		List<String> arr = new LinkedList<String>();
		int isAscending = (ch.equals("D")) ? -1 : 1;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr.add(st.nextToken());
		} 
		
		List<String> result = mergeSort(arr, isAscending);
		Iterator<String> iter = result.iterator();
		while(iter.hasNext()) {
			bw.write(iter.next());
			bw.write(" ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
