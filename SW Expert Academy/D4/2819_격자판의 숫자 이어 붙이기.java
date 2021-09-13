import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SW_D4_2819_격자판의숫자이어붙이기 {
	// 4방탐색
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int[][] board;
	public static HashSet<String> hs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// 테스트케이스의 수
		
		for (int tc = 1; tc <= T; tc++) {
			// 중복체크
			hs = new HashSet<>();
			board = new int[4][4];
			
			// 격자판 채우기
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 4; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					dfs(i, j, 1, board[i][j] + "");
				}
			}
			
			// 출력
			System.out.printf("#%d %d\n", tc, hs.size());
		}
	}
	
	// dfs
	public static void dfs(int x, int y, int len, String str) {
		// 7자리수가 만들어지면 HashSet에 저장하고 return
		if (len == 7) {
			hs.add(str);
			return;
		}
		
		// 4방탐색, dfs로 7자리수 만들기
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) continue;
			dfs(nx, ny, len+1, str+board[nx][ny]);
		}
	}
}

/*
입력
1
1 1 1 1
1 1 1 2
1 1 2 1
1 1 1 1

출력
#1 23
*/
