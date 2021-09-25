import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_5215_햄버거다이어트_DP {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		// 테스트케이스의 수
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());	// 재료의 수
			int L = Integer.parseInt(st.nextToken());	// 제한 칼로리
			
			int[] score = new int[N+1];
			int[] cal = new int[N+1];
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] dp = new int[N+1][L+1];
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= L; j++) {
					if (cal[i] <= j) dp[i][j] = Math.max(dp[i-1][j], score[i] + dp[i-1][j-cal[i]]);
					else dp[i][j] = dp[i-1][j];
				}
			}
			// 출력
			System.out.printf("#%d %d\n", tc, dp[N][L]);
		}
	}
}

/*
입력
1
5 1000
100 200
300 500
250 300
500 1000
400 400

출력
#1 750
*/
