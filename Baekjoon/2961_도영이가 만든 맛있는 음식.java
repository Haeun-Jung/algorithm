/**
 * 도영이는 짜파구리 요리사로 명성을 날렸었다. 이번에는 이전에 없었던 새로운 요리에 도전을 해보려고 한다.
 *
 * 지금 도영이의 앞에는 재료가 N개 있다. 도영이는 각 재료의 신맛 S와 쓴맛 B를 알고 있다.
 * 여러 재료를 이용해서 요리할 때, 그 음식의 신맛은 사용한 재료의 신맛의 곱이고, 쓴맛은 합이다.
 *
 * 시거나 쓴 음식을 좋아하는 사람은 많지 않다.
 * 도영이는 재료를 적절히 섞어서 요리의 신맛과 쓴맛의 차이를 작게 만들려고 한다.
 * 또, 물을 요리라고 할 수는 없기 때문에, 재료는 적어도 하나 사용해야 한다.
 * 
 * 재료의 신맛과 쓴맛이 주어졌을 때, 신맛과 쓴맛의 차이가 가장 작은 요리를 만드는 프로그램을 작성하시오.
 */

import java.util.Scanner;

public class BOJ_2961_도영이가만든맛있는음식 {
	
	private static int N, min;
	private static int Sresult, Bresult;
	private static int[] S, B;
	private static boolean[] flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();					// 재료의 개수
		S = new int[N];						// 신맛
		B = new int[N];						// 쓴맛
		flag = new boolean[N];
		Sresult = 1;
		Bresult = 0;
		min = Integer.MAX_VALUE;			// 최소값
		
		for (int i = 0; i < N; i++) {
			 S[i] = sc.nextInt();
			 B[i] = sc.nextInt();
		}
		
		solve(0);
		System.out.print(min);				// 출력
		sc.close();
	}
	
	private static void solve(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				if (flag[i]) {
					if (min > Math.abs(Sresult - Bresult)) min = Math.abs(Sresult - Bresult);
				}
			}
			return;
		}
		else {
			flag[cnt] = true;
			Sresult *= S[cnt];
			Bresult += B[cnt];
			solve(cnt+1);
			flag[cnt] = false;
			Sresult /= S[cnt];
			Bresult -= B[cnt];
			solve(cnt+1);
			}
	}
}

/*
입력
1
3 10

출력
7
*/
