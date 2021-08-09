import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();								// 테스트케이스의 수
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();							// Command의 수
			int total = 0;									// 총 이동 거리
			int move = 0;									// 현재 이동 거리
			for (int i = 0; i < N; i++) {
				int d = sc.nextInt();						// 가속 or 감속
				if (d != 0) {
					int speed = sc.nextInt();				// 가속도
					if (d == 1) move += speed;				// 가속인 경우
					else {									// 감속인 경우
						move -= speed;
						if (move < 0) move = 0;
					}
				}
				total += move;
			}
			// 출력
			System.out.printf("#%d %d\n", tc, total);
		}
		sc.close();
	}
}

/*
테스트케이스 3개일 때

입력
3
2
1 2
2 1
3
1 1
0
1 1
5
1 2
1 2
2 1
0
0

출력
#1 3
#2 4
#3 15
*/

