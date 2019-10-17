package com.github.hygoni;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Stars {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //버퍼에 담아서 한 번에 출력해야 속도가 빨라지므로 버퍼 사용
		int h, tries = 1;
		
		//삼각형
		System.out.println("input line numbers:");
		h = input.nextInt();
		System.out.println(String.format("---[%d]---", tries++));
		for(int i = 1; i <= h; i++) {
			for(int j = 0; j < i; j++) {
				bw.write("*");
			} 
			bw.write("\n");
		}
		bw.flush();
		
		//역삼각형
		System.out.println("input line numbers:");
		h = input.nextInt();
		System.out.println(String.format("---[%d]---", tries++));
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < i; j++) {
				bw.write(" ");
			}
			for(int j = h - 1 - i; j >= 0; j--) {
				bw.write("*");
			}
			bw.write("\n");
		}
		bw.flush();
		
		//다이아몬드
		System.out.println("input line numbers:");
		h = input.nextInt();
		System.out.println(String.format("---[%d]---", tries++));
		for(int i = 1; i <= h / 2 + 1; i++) {
			for(int j = 0; j <= h / 2 - i; j++) {
				bw.write(" ");
			}
			for(int j = 0; j < 2*i-1; j++) {
				bw.write("*");
			}
			bw.write("\n");
		}
		for(int i = 1; i <= h / 2; i++) {
			for(int j = 0; j < i; j++) {
				bw.write(" ");
			}
			for(int j = 0; j < h-2*i; j++) {
				bw.write("*");
			}
			bw.write("\n");
		}
		bw.flush();
		
		input.close();
		bw.close();
	}

}

