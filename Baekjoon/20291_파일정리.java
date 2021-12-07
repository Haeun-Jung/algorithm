/**
 * 첫째 줄에 바탕화면에 있는 파일의 개수 N이 주어진다. (1 <= N <= 50,000)
 * 둘째 줄부터 N개 줄에 바탕화면에 있는 파일의 이름이 주어진다. 파일의 이름은 알파벳 소문자와 점(.)으로만 구성되어 있다. 점은 정확히 한 번 등장하며, 파일 이름의 첫 글자 또는 마지막 글자로 오지 않는다. 각 파일의 이름의 길이는 최소 3, 최대 100이다.
 *
 * 확장자의 이름과 그 확장자 파일의 개수를 한 줄에 하나씩 출력한다. 확장자가 여러 개 있는 경우 확장자 이름의 사전순으로 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public class BOJ_20291_파일정리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> hash = new HashMap<>();
		int N = Integer.parseInt(br.readLine());				// 파일의 개수
		for (int i = 0; i < N; i++) {
			String file = br.readLine();						// 파일
			int idx = 0;										// .위치
			for (int j = 0; j < file.length(); j++) {
				if (file.charAt(j) == '.') idx = j;
			}
			
			String ex = file.substring(idx + 1, file.length());	// 확장자
			// 확장자 중복 O
			if (hash.containsKey(ex)) hash.put(ex, hash.get(ex) + 1);
			// 확장자 중복 X
			else hash.put(ex, 1);
		}
		
		// 키로 정렬
		TreeMap<String, Integer> map = new TreeMap<>(hash);
		
		// 출력
		for (Entry<String, Integer> entrySet : map.entrySet()) {
			System.out.println(entrySet.getKey() + " " + entrySet.getValue());
		}
	}
}

/*
입력
8
sbrus.txt
spc.spc
acm.icpc
korea.icpc
sample.txt
hello.world
sogang.spc
example.txt

출력
icpc 2
spc 2
txt 3
world 1
*/
