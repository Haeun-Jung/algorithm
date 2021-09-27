/**
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * 고른 수열은 오름차순이어야 한다.
 */

import java.util.Scanner;

public class BOJ_15650_N과M2 {
	private static int N, M;
	private static int[] result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();						// N까지의 자연수
		M = sc.nextInt();						// M개
		result = new int[M];
		comb(0,1);
		sc.close();
	}
	
	// 조합
	private static void comb(int cnt, int start) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i <= N; i++) {
			result[cnt] = i;
			comb(cnt+1, i+1);
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
2 3
2 4
3 4
*/
