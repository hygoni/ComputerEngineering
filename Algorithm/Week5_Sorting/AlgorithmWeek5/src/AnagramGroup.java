import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class AnagramGroup {
	
	public static String sort(String s) {
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		return String.valueOf(arr);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
		
		//Map을 이용하여 anagram 그룹을 만들어서 단어를 분류함
		//O(N * M log M) N : 전체 문자열의 개수, M : 문자열의 길이
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			String anagram = sort(token.toLowerCase()); //anagram key
			if(!map.containsKey(anagram)) {
				LinkedList<String> list = new LinkedList<String>();
				list.add(token);
				map.put(anagram, list);
			} else {
				map.get(anagram).add(token);
			}
		}
		
		//Group 안의 문자열들 정렬 & Map의 key를 각 그룹의 럿 번째 요소로 변경
		//Map을 순회하면서 Map을 수정하면 ConcurrentModificationException이 발생하므로 새로운 리스트를 생성
		//O(K * L log L) = O(N log L),  K : 그룹의 수, L : 그룹별 문자열의 수
		Iterator<String> iter = new LinkedList<String>(map.keySet()).iterator();
		while(iter.hasNext()) {
			String originalKey = iter.next();
			LinkedList<String> list = map.get(originalKey);
			Collections.sort(list);
			String key = list.get(0);
			if(!map.containsKey(key)) {
				map.put(key, list);
				map.remove(originalKey);
			}
		}
		
		//정렬된 anagram 그룹 (Map) 출력
		//O(K * L) = O(N) K : 그룹의 수, L : 그룹 내 문자열의 수, N : 전체 문자열의 개수
		LinkedList<String> keyList = new LinkedList<String>(map.keySet());
		Collections.sort(keyList); //O(K log K)
		iter = keyList.iterator();
		while(iter.hasNext()) {
			Iterator<String> iterList = map.get(iter.next()).iterator();
			while(iterList.hasNext()) {
				bw.write(iterList.next());
				if(iterList.hasNext()) {
					bw.write(" ");
				}
			}
			bw.write("\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}
