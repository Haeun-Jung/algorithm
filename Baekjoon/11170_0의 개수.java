/**
 * N부터 M까지의 수들을 종이에 적었을 때 종이에 적힌 0들을 세는 프로그램을 작성하라.
 */

import java.util.Scanner;

public class BOJ_11170_0의개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();		// 테스트 케이스의 수
		
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int cnt = 0;			// 0의 개수
			
			for (int j = N; j <= M; j++) {
				// 0이면 cnt + 1
				if (j == 0) {
					cnt++;
					continue;
				}
				
				// 0의 개수 세기
				int temp = j;
				while (temp > 0) {
					if (temp % 10 == 0) cnt++;
					temp /= 10;
				}
			}
			// 출력
			System.out.println(cnt);
		}
		sc.close();
	}
}

/*
입력
3
0 10
33 1005
1 4

출력
2
199
0
*/
