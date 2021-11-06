import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	public static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		// 테스트 케이스 개수
		
		for (int tc = 1; tc <= T; tc++) {
			// 중복체크
			HashSet<Integer> hs = new HashSet<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());	// N명
			int M = Integer.parseInt(st.nextToken());	// 관계 수
			parents = new int[N+1];
			int total = 0;
			
			for (int i = 1; i <= N; i++) {
				parents[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				// 같은 무리로 만들기
				union(a, b);
			}
			
			for (int i = 1; i <= N; i++) {
				if (hs.add(find(i))) total++;
			}
			// 출력
			System.out.printf("#%d %d\n", tc, total);
		}
	}
	
	// 대표 찾기
	public static int find(int a) {
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	// 대표 합치기
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
}

/*
입력
2
6 5
1 2
2 5
5 1
3 4
4 6
6 8
1 2
2 5
5 1
3 4
4 6
5 4
2 4
2 3

출력
#1 2
#2 1
*/
