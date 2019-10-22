import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {
	public static boolean isValidPalindrome(String str, int s, int e){
		int len = e-s;
		if(len == 1) {
			return true;
		} else if(len == 2) {
			return (str.charAt(s) == str.charAt(e));
		} else {
			if(str.charAt(s) == str.charAt(e)) {
				return isValidPalindrome(str, s+1, e-1);
			} else {
				return false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			if(isValidPalindrome(str, 0, str.length()-1)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		br.close();
	}
}
