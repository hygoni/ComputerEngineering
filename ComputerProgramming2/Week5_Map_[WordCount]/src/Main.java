import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static final String FILE_NOT_FOUND = "파일을 찾을 수 없습니다!";
	static final String IO_EXCEPTION = "입출력에 문제가 있습니다!";

	public static void log(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) {
		File file = new File("input.txt");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			HashMap<String, Integer> map = new HashMap<String, Integer>();

			//단어의 수를 세어서 map에 저장한다. (key : 단어, value : 개수)
			while(line != null) {
				StringTokenizer st = new StringTokenizer(line);
				while(st.hasMoreTokens()) {
					String key = st.nextToken();
					if(!map.containsKey(key)){
						map.put(key, 1);
					} else {
						map.put(key, map.get(key) + 1);
					}
				}
				line = br.readLine();
			}

			//최댓값과 최솟값을 찾는다.
			int max = 0;
			int min = Integer.MAX_VALUE;
			List<Integer> valueList = new ArrayList<Integer>(map.values());
			Iterator<Integer> iterInt = valueList.iterator();
			while(iterInt.hasNext()) {
				int val = iterInt.next();
				if(max < val) {
					max = val;
				}
				if(min > val) {
					min = val;
				}
			}


			//value가 max, min에 해당하는 key들을 리스트에 넣는다.
			LinkedList<String> maxList = new LinkedList<String>();
			LinkedList<String> minList = new LinkedList<String>();
			Set<String> keySet = map.keySet();
			for(String key : keySet) {
				int val = map.get(key);
				if(val == min) {
					minList.add(key);
				}
				if(val == max) {
					maxList.add(key);
				}
			}

			//결과를 출력하기 위해 문자스트림을 연다.
			file = new File("output.txt");
			PrintWriter pw = new PrintWriter(new FileWriter(file));
			StringBuilder sb = new StringBuilder();

			//max 리스트를 출력한다.
			Iterator<String> iterStr = maxList.iterator();
			sb.append("max key : [");
			while(iterStr.hasNext()) {
				sb.append(iterStr.next()).append(", ");
			}
			sb.delete(sb.length()-2, sb.length()); //마지막 콤마 (", ")는 지워준다.
			sb.append("] / ").append(Integer.toString(max));
			System.out.println(sb.toString());

			//min 리스트를 출력한다.
			iterStr = minList.iterator();
			sb = new StringBuilder();
			sb.append("min key : [");
			while(iterStr.hasNext()) {
				sb.append(iterStr.next()).append(", ");
			}
			sb.delete(sb.length()-2, sb.length()); //마지막 콤마 (", ")는 지워준다.
			sb.append("] / ").append(Integer.toString(min));
			System.out.println(sb.toString());

			//모든 key, value를 파일에 출력한다.
			iterStr = map.keySet().iterator();
			sb = new StringBuilder();
			while(iterStr.hasNext()) {
				String key = iterStr.next();
				int val = map.get(key);
				sb.append(String.format("%s=%s", key, val)).append(", ");
			}
			sb.delete(sb.length()-2, sb.length()); //마지막 콤마 (", ")는 지워준다.
			//자원 반환
			pw.write(sb.toString());
			pw.flush();
			pw.close();

		} catch (FileNotFoundException e) {
			log(FILE_NOT_FOUND);
		} catch (IOException e) {
			log(IO_EXCEPTION);
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					log(IO_EXCEPTION);
				}
			}
		}
	}
}
