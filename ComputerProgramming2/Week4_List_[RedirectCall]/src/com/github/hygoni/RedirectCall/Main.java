package com.github.hygoni.RedirectCall;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		String start = st.nextToken();
		MyList list = new MyList();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String from = st.nextToken();
			String to = st.nextToken();
			Redirect redir = new Redirect(from, to); //수신전화 리다이렉트
			list.add((Object)redir);
		}
		
		String tmp = list.search(start); //start에 매칭되는 수신전화 목록을 찾음
		String end;
		boolean loop = false;
		if(tmp == null) { //tmp가 null이라면 리다이렉트할 번호가 없다는 뜻
			end = start;
		} else {
			end = tmp;
			tmp = list.search(end);
			while(!end.equals(start) && tmp != null) { //자기 자신이 나오거나 더이상 번호가 없을때까지 반복
				end = tmp;
				tmp = list.search(end);
			}
			if(end.equals(start)) { //자기 자신이 나온 경우 : 무한루프
				loop = true;
			}
		}
		
		bw.write((loop) ? "0000" : end + "\n");
		br.close();
		bw.close();
		
	}
}
