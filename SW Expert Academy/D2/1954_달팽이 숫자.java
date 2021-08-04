import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// 달팽이 회전
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();			// 테스트케이스
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); 		// 달팽이의 크기
			int[][] arr = new int[N][N];
			int x = 0;
			int y = 0;
			int d = 0;

			for (int num = 1; num <= N * N; num++) {
				arr[x][y] = num;
				
				// 다음 요소
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				// 다음 요소가 배열의 범위를 벗어났을 때
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] != 0) {
					// 방향 틀기
					d++;				
					if (d > 3) d = 0;
					
					// 다음 요소로 이동
					x = x + dx[d];
					y = y + dy[d];
					continue;
				}
				// 다음 요소로 이동
				x = nx;
				y = ny;
			}
			
			System.out.printf("#%d\n", tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.printf("%d ", arr[i][j]);
				}
				System.out.println();
			}
		}
	}
}

/*
입력
2    
3   
4

출력
#1
1 2 3
8 9 4
7 6 5
#2
1 2 3 4
12 13 14 5
11 16 15 6
10 9 8 7
*/