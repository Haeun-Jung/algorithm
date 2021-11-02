/**
 * N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * N개의 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다.
 * 고른 수열은 비내림차순이어야 한다.
 * 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15666_N과M12 {
	private static int N, M;
	private static int[] arr, result;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); 				// N개의 자연수
		M = Integer.parseInt(st.nextToken());				// M개 뽑기
		arr = new int[N];
		result = new int[M];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		comb(0, 0, sb);
		// 출력
		System.out.println(sb);
	}
	
	// 중복 조합
	private static void comb(int cnt, int start, StringBuilder sb) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		int num = 0;
		for (int i = start; i < N; i++) {
			if (num == arr[i]) continue;
			
			result[cnt] = arr[i];
			comb(cnt + 1, i, sb);
			num = arr[i];
		}
	}
}

/*
입력
4 4
1 1 2 2

출력
1 1 1 1
1 1 1 2
1 1 2 2
1 2 2 2
2 2 2 2
*/
