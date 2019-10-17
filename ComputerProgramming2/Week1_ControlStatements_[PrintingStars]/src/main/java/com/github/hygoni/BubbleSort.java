package com.github.hygoni;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BubbleSort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st;
		int[] array;
		
		System.out.println("정렬 전 숫자 :");
		st = new StringTokenizer(br.readLine());
		array = new int[st.countTokens()];
		
		//숫자를 배열로 저장
		for(int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		//버블정렬 (오름차순)
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length-i-1; j++) {
				if(array[j] > array[j+1]) { //두 원소가 정렬되어있지 않다면
					//값을 교환
					int tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
				}
			}

		}
		
		System.out.println("정렬된 결과:");
		for(int i = 0; i < array.length; i++) {
			bw.write(array[i] + " ");
		}
		bw.flush();
		
		br.close();
		bw.close();
	}
}

