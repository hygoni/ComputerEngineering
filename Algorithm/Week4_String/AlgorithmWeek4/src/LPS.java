import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LPS {
	
	public static int LPS(String word) {
		int maxLen = 0;
		word = word.replace(" ", "").toLowerCase();
		boolean d[][] = new boolean[word.length()][word.length()];
		
		//len = 1
		for(int i = 0; i < word.length(); i++) {
			d[i][i] = true;
			if(maxLen < 1) {
				maxLen = 1;
			}
		}
		
		//len = 2
		for(int i = 0; i < word.length() - 1; i++) {
			int j = i + 1;
			int len = j-i+1;
			d[i][j] = word.charAt(i) == word.charAt(j);
			if(d[i][j] && (maxLen < len)) {
				maxLen = len;
			}
		}
		
		//len >= 3
		for(int k = 3; k <= word.length(); k++) {
			for(int i = 0; i < word.length() - k + 1; i++) {
				int j = i + k - 1;
				d[i][j] = d[i+1][j-1] && word.charAt(i) == word.charAt(j);
				int len = j-i+1;
				if(d[i][j] && (maxLen < len)) {
					maxLen = len;
				}
			}
		}	
		return maxLen;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = br.readLine();
		bw.write(LPS(line) + "\n");
		br.close();
		bw.close();
	}
}
