import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_D6_1263_사람네트워크2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		// 테스트케이스의 수
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());	// 사람 수
			int[][] arr = new int[N+1][N+1];
			
			// 인접 행렬
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && arr[i][j] == 0) arr[i][j] = 999;
				}
			}
			
			// 플로이드 알고리즘
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					if (i == k) continue;
					for (int j = 1; j <= N; j++) {
						if (j == k || j == i) continue;
						arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
					}
				}
			}
		
			// 최솟값 구하기
			int min = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				int sum = 0;
				for (int j = 1; j <= N; j++) {
					sum += arr[i][j];
				}
				if (sum < min) min = sum;
			}
			
			// 출력
			System.out.printf("#%d %d\n", tc, min);
		}
	}
}

/*
입력
2
5 0 1 1 0 0 1 0 1 1 1 1 1 0 0 0 0 1 0 0 0 0 1 0 0 0
5 0 0 1 1 0 0 0 1 0 0 1 1 0 0 1 1 0 0 0 1 0 0 1 1 0

출력
#1 4
#2 5
*/
