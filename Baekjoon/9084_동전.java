/**
 * 동전의 종류가 주어질 때에 주어진 금액을 만드는 모든 방법을 세는 프로그램을 작성하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9084_동전 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		// 테스트케이스의 개수
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());	// N가지 동전
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int[] coin = new int[N];					// N가지 동전의 각 금액
			for (int i = 0; i < N; i++) coin[i] = Integer.parseInt(st.nextToken());
			
			int M = Integer.parseInt(br.readLine());	// 만들어야할 금액
			
			int[] dp = new int[M+1];
			dp[0] = 1;
			
			// dp
			for (int i = 0; i < N; i++) {
				for (int j = coin[i]; j <= M; j++) {
					dp[j] += dp[j - coin[i]];
				}
			}
			
			// 출력
			System.out.println(dp[M]);
		}
	}
}

/*
입력
3
2
1 2
1000
3
1 5 10
100
2
5 7
22

출력
501
121
1
*/
