import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Sort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<String> list = new ArrayList<String>();
		int len = Integer.parseInt(st.nextToken());
		String ch = st.nextToken();
		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			list.add(st.nextToken());
		}
		
		if(ch.equals("A")) {
			Collections.sort(list);
		} else {
			Collections.sort(list, Collections.reverseOrder());
		}
		
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			bw.write(iter.next());
			bw.write(" ");
		}
		
		bw.flush();
		br.close();
		bw.close();
		
	}
}
