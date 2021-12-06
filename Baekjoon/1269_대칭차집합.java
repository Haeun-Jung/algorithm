/**
 * 자연수를 원소로 갖는 공집합이 아닌 두 집합 A와 B가 있다. 이때, 두 집합의 대칭 차집합의 원소의 개수를 출력하는 프로그램을 작성하시오. 두 집합 A와 B가 있을 때, (A-B)와 (B-A)의 합집합을 A와 B의 대칭 차집합이라고 한다.
 * 예를 들어, A = { 1, 2, 4 } 이고, B = { 2, 3, 4, 5, 6 } 라고 할 때,  A-B = { 1 } 이고, B-A = { 3, 5, 6 } 이므로, 대칭 차집합의 원소의 개수는 1 + 3 = 4개이다.
 *
 * 대칭 차집합의 원소의 개수를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1269_대칭차집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		HashMap<Integer, Integer> hash = new HashMap<>();
		int cnt = 0;								// 교집합의 원소의 개수
		
		int a = Integer.parseInt(st.nextToken());	// 집합 A의 원소의 개수
		int b = Integer.parseInt(st.nextToken());	// 집합 B의 원소의 개수
		
		// 집합 A
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < a; i++) hash.put(Integer.parseInt(st.nextToken()), 1);
		// 집합 B
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < b; i++) {
			int num = Integer.parseInt(st.nextToken());
			// 이미 존재하는 원소면 교집합 + 1
			if (hash.containsKey(num)) cnt++;
			else hash.put(num, 1);
		}
		
		// 출력(전체 원소 갯수에서 교집합의 갯수 제외)
		System.out.println(a + b - (cnt * 2));
	}
}

/*
입력
3 5
1 2 4
2 3 4 5 6

출력
4
*/
