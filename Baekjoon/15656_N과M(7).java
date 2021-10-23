/**
 * N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.
 * N개의 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 15656_N과M7 {
	private static int N, M;
	private static int[] arr, result;
	private static boolean[] checked;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[M];
		checked = new boolean[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		perm(0);
		System.out.println(sb);
	}
	
	// 중복순열
	private static void perm(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) sb.append(result[i]).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			result[cnt] = arr[i];
			checked[i] = true;
			perm(cnt+1);
			checked[i] = false;
		}
	}
}

/*
입력
4 2
9 8 7 1

출력
1 1
1 7
1 8
1 9
7 1
7 7
7 8
7 9
8 1
8 7
8 8
8 9
9 1
9 7
9 8
9 9
*/
