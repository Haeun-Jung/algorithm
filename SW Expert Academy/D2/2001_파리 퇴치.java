import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); 			// 테스트케이스
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();		// 파리 영역의 크기
			int M = sc.nextInt(); 		// 파리채
			int[][] area = new int[N][N];
			
			// 제약사항
			if (N < 5 || N > 15) break;
			if (M < 2 || M > N) break;
			
			// 파리 영역
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					area[i][j] = sc.nextInt();
					// 제약사항
					if (area[i][j] > 30) return;
				}
			}
			
			int max = -1;				// 죽은 파리의 최대 개수
			
			// 파리채로 파리를 잡아 죽은 파리의 개수 구하기
			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					int sum = 0;
					for (int x = i; x < i + M; x++) {
						for (int y = j; y < j + M; y++) {
							sum += area[x][y];
						}
					}
					if (max < sum) max = sum;
				}
			}
			
			// 출력
			System.out.printf("#%d %d\n", tc, max);
		}
		sc.close();
	}
}

/*
입력
2
5 2
1 3 3 6 7
8 13 9 12 8
4 16 11 12 6
2 4 1 23 2
9 13 4 7 3
6 3
29 21 26 9 5 8
21 19 8 0 21 19
9 24 2 11 4 24
19 29 1 0 21 19
10 29 6 18 4 3
29 11 15 3 3 29

출력
#1 49
#2 159
*/