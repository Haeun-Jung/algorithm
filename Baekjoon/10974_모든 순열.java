/**
 * N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.
 */
import java.util.Scanner;

public class BOJ_10974_모든순열 {
	
	public static int N;
	public static int[] arr, result;
	public static boolean[] checked;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	// 1부터 N까지의 수
		arr = new int[N+1];
		result = new int[N+1];
		checked = new boolean[N+1];
		
		for (int i = 0; i < N; i++) arr[i] = i + 1;
		perm(0);
		
		sc.close();
	}
	
	// 순열
	public static void perm(int n) {
		// 기저조건
		if (n == N) {
			// 출력
			for (int i = 0; i < N; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (checked[i]) continue;
			result[n] = arr[i];
			checked[i] = true;
			perm(n+1);
			checked[i] = false;
		}
	}
}
/*
입력
3

출력
1 2 3
1 3 2
2 1 3
2 3 1
3 1 2
3 2 1
*/
