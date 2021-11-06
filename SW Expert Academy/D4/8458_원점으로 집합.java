import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		// 테스트케이스의 수
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());	// 정수 N
			int[] arr = new int[N];
			int cnt = 0;								// 이동횟수
			
			// 점 입력받기
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				arr[i] = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
			}
			
			int max = 0;								// 원점과 가장 먼 곳
			int check = arr[0] % 2;						// 첫번째 요소 홀/짝 판별
			for (int i = 0; i < N; i++) {
				// 홀/짝이 다르다면 모든점 이동시키기 불가능
				if (arr[i] % 2 != check) cnt = -1;
				// 가장 먼 곳 갱신
				max = Math.max(max, arr[i]);
			}
			
			// 모든 점을 이동시킬 수 있다면
			if (cnt != -1) {
				int sum = 0;
				while (sum < max || (sum - max) % 2 != 0) {
					sum += ++cnt;
				}
			}
			
			// 출력
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}
}

/*
입력
3
2
0 0
0 0
2
-6 0
3 3
2
-5 0
2 1

출력
#1 0
#2 3
#3 5
*/
