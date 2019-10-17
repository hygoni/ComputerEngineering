import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class GoodWord {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			String line = br.readLine();
			LinkedList<Character> list = new LinkedList<Character>();
			//문자열을 스택에 넣는다.
			for(int j = 0; j < line.length(); j++) {
				char ch = line.charAt(j);
				if(ch == 'A') {
					if(list.size() == 0) {
						list.addFirst(ch);
					} else if(list.get(0) == 'A') {
						list.removeFirst();
					} else if(list.get(0) == 'B') {
						list.addFirst(ch);
					}
				} else {
					if(list.size() == 0) {
						list.addFirst(ch);
					} else if(list.get(0) == 'B') {
						list.removeFirst();
					} else if(list.get(0) == 'A') {
						list.addFirst(ch);
					}
				}
			}
			if(list.size() == 0) {
				cnt++;
			}
		}
		System.out.println(cnt);
		br.close();
	}
}