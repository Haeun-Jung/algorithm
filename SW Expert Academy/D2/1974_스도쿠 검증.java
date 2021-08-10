import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스의 수
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int[][] board = new int[9][9];
			// 겹치는 숫자가 없다면 1 
			int answer = 1;
			
			// 스도쿠 채우기
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			// 가로 세로 판단
			outer: for (int i = 0; i < 9; i++) {
				int[] arr1 = new int[9];
				int[] arr2 = new int[9];
				for (int j = 0; j < 9; j++) {
					int num1 = board[i][j];
					int num2 = board[j][i];
					// 이미 해당 숫자가 있다면 유효하지 않은 스도쿠
					if (arr1[num1-1] == 1 || arr2[num2-1] == 1) {
						answer = 0;
						break outer;
					}
					// 해당 숫자가 처음이라면 체크
					arr1[num1-1] = 1;
					arr2[num2-1] = 1;
				}
			}
			
			// 아직 스도쿠가 유효하다면
			if (answer != 0) {
				// 격자 판단
				outer: for (int d = 0; d < 9; d+=3) {
					int[] arr = new int[9];
					for (int i = d; i < 3; i++) {
						for (int j = d; j < 3; j++) {
							int num = board[i][j];
							// 이미 해당 숫자가 있다면 유효하지 않은 스도쿠
							if (arr[num-1] == 1) {
								answer = 0;
								break outer;
							}
							// 해당 숫자가 처음이라면 체크
							arr[num-1] = 1;
						}
					}
				}
			}
			// 출력
			System.out.printf("#%d %d\n", tc, answer);
		}
		sc.close();
	}
}

/*
입력
2
7 3 6 4 2 9 5 8 1
5 8 9 1 6 7 3 2 4
2 1 4 5 8 3 6 9 7
8 4 7 9 3 6 1 5 2
1 5 3 8 4 2 9 7 6
9 6 2 7 5 1 8 4 3
4 2 1 3 9 8 7 6 5
3 9 5 6 7 4 2 1 8
6 7 8 2 1 5 4 3 9

7 3 6 4 8 9 2 5 1
8 5 2 7 3 1 6 9 4
9 1 4 5 6 2 7 3 8
4 9 7 2 5 6 8 1 3
5 6 3 1 8 7 9 4 2
2 8 1 9 4 3 5 6 7
6 7 5 3 2 4 1 8 9
1 4 9 6 7 8 3 2 5
3 2 8 1 9 5 4 7 6

출력
#1 1
#2 0
*/