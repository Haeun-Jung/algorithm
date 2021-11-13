/**
 * 먼저 아래와 같이 25개의 칸으로 이루어진 빙고판에 1부터 25까지 자연수를 한 칸에 하나씩 쓴다.
 * 다음은 사회자가 부르는 수를 차례로 지워나간다.
 * 차례로 수를 지워가다가 같은 가로줄, 세로줄 또는 대각선 위에 있는 5개의 모든 수가 지워지는 경우 그 줄에 선을 긋는다.
 * 이러한 선이 세 개 이상 그어지는 순간 "빙고"라고 외치는데, 가장 먼저 외치는 사람이 게임의 승자가 된다.
 *
 * 사회자가 몇 번째 수를 부른 후 철수가 "빙고"를 외치게 되는지 출력한다.
 */

import java.util.Scanner;

public class BOJ_2578_빙고{
	private static int line = 0, num = 0;
	private static int originCol = 0, originRow = 0, originLtoR = 0, originRtoL = 0;
	private static int[][] bingo;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		bingo = new int[5][5];
		// 빙고 채우기
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = sc.nextInt();
			}
		}
		
		int k = 1;
		outer: for (k = 1; k <= 25; k++) {
			// 사회자가 부른 수
			num = sc.nextInt();
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					// 사회자가 부른 수 지우기
					if (bingo[i][j] == num) {
						bingo[i][j] = 0;
						// 빙고 몇 줄인지 확인
						check();
						// 빙고 3줄이상이면 반복문 탈출
						if (line >= 3) break outer;
					}
				}
			}
		}
		// 몇번째에서 빙고가 3줄이상이 되었는지 출력
		System.out.println(k);
		
	}
	
	// 빙고가 몇줄인지 체크
	private static void check() {
		// 가로 빙고
		int newCnt = 0;
		for (int i = 0; i < 5; i++) {
			int cnt = 0;
			for (int j = 0; j < 5; j++) {
				if (bingo[i][j] == 0) cnt++;
			}
			if (cnt == 5) newCnt++;
		}
		// 이전에 세었던 가로 빙고 개수와 다르다면, 새로 추가된 빙고 더하기
		if (newCnt != originCol) {
			line += newCnt - originCol;
			originCol = newCnt;
		}
		
		// 세로 빙고
		newCnt = 0;
		for (int j = 0; j < 5; j++) {
			int cnt = 0;
			for (int i = 0; i < 5; i++) {
				if (bingo[i][j] == 0) cnt++;
			}
			if (cnt == 5) newCnt++;
		}
		// 이전에 세었던 가로 빙고 개수와 다르다면, 새로 추가된 빙고 더하기
		if (newCnt != originRow) {
			line += newCnt - originRow;
			originRow = newCnt;
		}
		
		// 대각선 빙고
		// 양쪽 대각선을 모두다 세었다면 반복문 생략
		if (originLtoR == 0 || originRtoL == 0) {
			int cnt1 = 0;
			int cnt2 = 0;
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (originLtoR != 1) {
						if (i == j) {
							if (bingo[i][j] == 0) cnt1++;
						}
					}
					if (originRtoL != 1) {
						if (i + j == 4) {
							if (bingo[i][j] == 0) cnt2++;
						}
					}

				}
			}
			if (cnt1 == 5) {
				originLtoR++;
				line++;
			}
			if (cnt2 == 5) {
				originRtoL++;
				line++;
			}
		}
	}
}

/*
입력
11 12 2 24 10
16 1 13 3 25
6 20 5 21 17
19 4 8 14 9
22 15 7 23 18
5 10 7 16 2
4 22 8 17 13
3 18 1 6 25
12 19 23 14 21
11 24 9 20 15

출력
15
*/
