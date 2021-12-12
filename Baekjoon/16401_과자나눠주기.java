/**
 * M명의 조카가 있고 N개의 과자가 있을 때, 조카 1명에게 줄 수 있는 막대 과자의 최대 길이를 구하라.
 * 단, 막대 과자는 길이와 상관없이 여러 조각으로 나눠질 수 있지만, 과자를 하나로 합칠 수는 없다. 단, 막대 과자의 길이는 양의 정수여야 한다.
 *
 * 조카 1명에게 줄 수 있는 막대 과자의 최대 길이를 출력한다.
 * 단, 모든 조카에게 같은 길이의 막대과자를 나눠줄 수 없다면, 0을 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16401_과자나눠주기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());	// 조카의 수
		int N = Integer.parseInt(st.nextToken());	// 과자의 수
		int answer = 0;								// 최대 길이
		
		int[] snack = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) snack[i] = Integer.parseInt(st.nextToken());
		
		// 오름차순 정렬
		Arrays.sort(snack);
		
		int left = 1;
		// 가장 긴 과자
		int right = snack[N-1];
		
		// 이분탐색
		while (left <= right) {
			// 중간값
			int mid = (left + right) / 2;
			// 과자 조각
			int cnt = 0;
			
			// 과자를 몇조각으로 나눌지 계산
			for (int i = 0; i < N; i++) cnt += snack[i] / mid;
			
			// 과자 조각 수가 조카의 수보다 많다면
			// mid의 오른쪽 탐색
			if (cnt >= M) {
				answer = mid;
				left = mid + 1;
			}
			// 과자 조각 수가 조카의 수보다 적다면
			// mid의 왼쪽 탐색
			else right = mid - 1;
		}
		// 출력
		System.out.println(answer);
	}
}

/*
입력
3 10
1 2 3 4 5 6 7 8 9 10

출력
8
*/
