import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class StackTest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<String> stack = new LinkedList<String>();
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			switch(cmd) {
			case "push":
				String arg = st.nextToken();
				stack.push(arg);
				break;
			case "pop":
				if(stack.size() > 0) {
					sb.append(stack.pop()).append("\n");
				} else {
					sb.append("-1\n");
				}
				break;
			case "top":
				if(stack.size() > 0) {
					sb.append(stack.peek()).append("\n");
				} else {
					sb.append("-1\n");
				}
				break;
			case "size":
				sb.append(stack.size()).append("\n");
				break;
			case "empty":
				sb.append((stack.size() == 0) ? "1" : "0").append("\n");
				break;
			}
		}
		System.out.print(sb.toString());
		br.close();
	}
}
