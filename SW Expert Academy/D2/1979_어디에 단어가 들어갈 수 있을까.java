import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_D2_1979_어디에단어가들어갈수있을까 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		// 테스트케이스 수
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());	// N*N
			int K = Integer.parseInt(st.nextToken());	// 특정 길이
			int total = 0;
			int[][] board = new int[N][N];
			
			// 퍼즐
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 길이가 K인 단어 찾기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int x = i;
					int y = j;
					if (board[i][j] == 1) {
						// 가로
						if ((i > 0 && board[i-1][j] == 0) || i == 0) {
							int cnt = 0;
							while (x < N && board[x][j] != 0) {
								cnt++;
								x++;
							}
							if (cnt == K) total++;
						}
						// 세로
						if ((j > 0 && board[i][j-1] == 0) || j == 0) {
							int cnt = 0;
							while (y < N && board[i][y] != 0) {
								cnt++;
								y++;
							}
							if (cnt == K) {
								total++;
							}
						}
					}
				}
			}
			// 출력
			System.out.printf("#%d %d\n", tc, total);
		}
	}
}

/*
입력
2
5 3
0 0 1 1 1
1 1 1 1 0
0 0 1 0 0
0 1 1 1 1
1 1 1 0 1
5 3
1 0 0 1 0
1 1 0 1 1
1 0 1 1 1
0 1 1 0 1
0 1 1 1 0

출력
#1 2
#2 6
*/
