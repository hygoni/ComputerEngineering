import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dart {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = br.readLine();
		String pattern = "[0-9]+[SDT](\\*|#)?";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(line);
		int cnt = 0;
		//Counting
		while(m.find()) {
			cnt++;
		}
		
		m = p.matcher(line);
		
		boolean isStar = false;
		boolean isAcha = false;
		int sum = 0;
		
		for(int i = 0; m.find(); i++) {
			String piece = line.substring(m.start(), m.end()); //점수의 한 조각
			Matcher findScore = Pattern.compile("[0-9]+").matcher(piece); //숫자
			Matcher findPow = Pattern.compile("[SDT]").matcher(piece); //지수
			Matcher findPrize = Pattern.compile("(\\*|#)").matcher(piece); //상
			
			findScore.find();
			int score = Integer.parseInt(piece.substring(findScore.start(), findScore.end()));
			
			findPow.find();
			String powChar = piece.substring(findPow.start(), findPow.end());
			int pow = 0;

			switch(powChar) {
			case "S":
				pow = 1;
				break;
			case "D":
				pow = 2;
				break;
			case "T":
				pow = 3;
				break;
			}
			
			score = (int) Math.pow(score, pow);
			if(isStar) {
				score *= 2;
			}
			
			
			//Check prize
			if(findPrize.find()) {
				String prize = piece.substring(findPrize.start(), findPrize.end());
				if(prize.equals("*")) {
					isStar = true;
					isAcha = false;
				} else if(prize.equals("#")) {
					isStar = false;
					isAcha = true;
				} 
			} else {
				isStar = false;
				isAcha = false;
			}
			
			if(isStar) {
				score *= 2;
			} else if(isAcha) {
				score *= -1;
			}
			sum += score;
		}
		
		
		System.out.println(sum);
		br.close();
		bw.close();
	}
}
