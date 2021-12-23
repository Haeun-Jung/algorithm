/**
 * N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다. 이 수열의 i번째 수부터 j번째 수까지의 합 A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수를 구하는 프로그램을 작성하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003_수들의합2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.valueOf(st.nextToken());	// N개 수열
		int M = Integer.valueOf(st.nextToken());	// 목표값 M
		
		// 수열
		int[] A = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
		
		int start = 0, end = 0, cnt = 0, sum = 0;
		
		// 투 포인터
		while (start < N) {
			// 합이 목표값을 넘거나, end가 수열의 범위를 넘는다면
			if (sum > M || end == N) {
				// A[start]값 제외
				sum -= A[start];
				// start 오른쪽 + 1
				start++;
			}
			// 합이 목표값을 안 넘고, end가 수열의 범위안에 있을 때
			else {
				// A[end]값 더하기
				sum += A[end];
				// end 오른쪽 + 1
				end++;
			}
            
			// 목표값 달성
			if (sum == M) cnt++;
		}
		
		// 출력
		System.out.println(cnt);
	}
}

/*
입력
4 2
1 1 1 1

출력
3
*/
