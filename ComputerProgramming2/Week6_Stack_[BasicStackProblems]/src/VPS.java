import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class VPS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			String line = br.readLine();
			Stack<Character> stack = new Stack<Character>();
			String answer = null;
			//문자열을 스택에 넣는다.
			for(int j = 0; j < line.length(); j++) {
				char ch = line.charAt(j);
				if(ch == '(') {
					stack.push(ch);
				} else {
					if(stack.size() == 0) {
						answer = "NO";
						break;
					} else {
						stack.pop();
					}
				}
			}
			
			if(answer == null) {
				if(stack.size() == 0) {
					answer = "YES";
				} else {
					answer = "NO";
				}
			}			
			sb.append(answer).append("\n");
			
		}
		System.out.println(sb);
		br.close();
	}
}