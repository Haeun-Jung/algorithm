/*
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
2. X가 2로 나누어 떨어지면, 2로 나눈다.
3. 1을 뺀다.

정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다.
연산을 사용하는 횟수의 최솟값을 출력하시오.
*/

import java.util.Scanner;

public class BOJ_1463_1로만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();					// 정수 X
		int[] dp = new int[X+1];
		
		for (int i = 2; i <= X; i++) {
			dp[i] = dp[i-1] + 1;
			if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3]+1);
			if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2]+1);
		}
		System.out.println(dp[X]);
		sc.close();
	}
}

/*
입력
10

출력
3

10의 경우에 10 -> 9 -> 3 -> 1 로 3번 만에 만들 수 있다.
*/
