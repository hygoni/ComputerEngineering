import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Anagram {
	public static boolean isAnagram(String s1, String s2) {
		s2 = s2.toLowerCase();
		s1 = s1.toLowerCase();
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		for(int i = 0; i < s1.length(); i++) {
			if(arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String word1 = st.nextToken();
		String word2 = st.nextToken();
		System.out.println((isAnagram(word1, word2)) ? "True": "False");
		br.close();
		bw.close();
	}
}
