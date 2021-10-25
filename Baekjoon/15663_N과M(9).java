/**
 * N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * N개의 자연수 중에서 M개를 고른 수열
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_15663_N과M9 {
	private static int N, M;
	private static int[] arr, result;
	private static boolean[] checked;
	private static StringBuilder sb = new StringBuilder();
	private static HashSet<String> hs = new HashSet<>();
	
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
		comb(0);
		System.out.println(sb);
	}
	
	// 순열
	private static void comb(int cnt) {
		if (cnt == M) {
			if (!hs.contains(toStr())) {
				for (int i = 0; i < M; i++) {
					sb.append(result[i]).append(" ");
					
				}
				sb.append("\n");
				hs.add(toStr());
			}
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (checked[i]) continue;
			result[cnt] = arr[i];
			checked[i] = true;
			comb(cnt+1);
			checked[i] = false;
		}
	}
	
	public static String toStr() {
		String str = "";
		for (int i = 0; i < M; i++) {
			str += result[i];
		}
		return str;
	}
}

/*
입력
4 2
9 7 9 1

출력
1 7
1 9
7 1
7 9
9 1
9 7
9 9
*/
