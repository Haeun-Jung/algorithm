import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2798_블랙잭 {
	private static int N, M, goal, answer;
	private static int[] player, result ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());		// 카드의 개수
		M = Integer.parseInt(st.nextToken());		// 딜러의 숫자
		goal = Integer.MAX_VALUE;					// 차이를 비교할 값
		answer = 0;									// M과 가까운 값
		player = new int[N];
		result = new int[3];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			player[i] = Integer.parseInt(st.nextToken());
		}
		comb(0, 0);
		System.out.println(answer);
	}

	// 조합
	private static void comb(int cnt, int start) {
		// 3개를 다 뽑았을 때
		if (cnt == 3) {
			int sum = 0;
			for (int num : result) sum += num;
			if (sum <= M && Math.abs(sum-M) <= goal) {
				goal = Math.abs(sum-M);
				answer = sum;
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			result[cnt] = player[i];
			comb(cnt+1, i+1);
		}
	}
}

/*
입력
5 21
5 6 7 8 9

출력
21
*/
