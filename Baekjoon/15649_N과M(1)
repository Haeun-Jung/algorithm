/**
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 */

import java.util.Scanner;

public class BOJ_15649_N과M1 {
	private static int N, M;
	private static int[] result;
	private static boolean[] checked;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();						// N까지의 자연수
		M = sc.nextInt();						// M개
		result = new int[M];
		checked = new boolean[N+1];
		perm(0);
		sc.close();
	}
	
	private static void perm(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (checked[i]) continue;
			result[cnt] = i;
			checked[i] = true;
			perm(cnt+1);
			checked[i] = false;
		}
	}
}

/*
입력
4 2

출력
1 2
1 3
1 4
2 1
2 3
2 4
3 1
3 2
3 4
4 1
4 2
4 3
*/
