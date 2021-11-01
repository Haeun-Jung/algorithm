/**
 * N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * N개의 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 15665_N과M11 {
	private static int N, M;
	private static int[] arr, result;
	private static StringBuilder sb = new StringBuilder();
	private static HashSet<String> hs = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[M];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		perm(0);
		System.out.println(sb);
	}
	
	
	// 중복 순열
	private static void perm(int cnt) {
		if (cnt == M) {
			String temp = toStr();
			if (!hs.contains(temp)) {
				for (int i = 0; i < M; i++) sb.append(result[i]).append(" ");
				sb.append("\n");
				hs.add(temp);
			}
			return;
		}
		
		for (int i = 0; i < N; i++) {
			result[cnt] = arr[i];
			perm(cnt+1);
		}
	}
	
	
	// 중복 제거를 위한 문자열 만들기
	private static String toStr() {
		String str = "";
		for (int i = 0; i < M; i++) str += result[i];
		return str;
	}
}

/*
입력
4 2
9 7 9 1

출력
1 1
1 7
1 9
7 1
7 7
7 9
9 1
9 7
9 9
*/
