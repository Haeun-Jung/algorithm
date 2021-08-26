/*
세로 R칸, 가로 C칸으로 된 표 모양의 보드가 있다.
보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고, 좌측 상단 칸 (1행 1열) 에는 말이 놓여 있다.

말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데, 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다.
즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.

좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오. 
말이 지나는 칸은 좌측 상단의 칸도 포함된다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
	// 4방 탐색
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};
	private static int R, C, max;
	private static char[][] board;
	// 중복 방지를 위한 HashSet
	private static HashSet<Character> hs = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());		// 세로
		C = Integer.parseInt(st.nextToken());		// 가로
		board = new char[R][C];						      // 보드
		max = Integer.MIN_VALUE;
		
		// 보드 채우기
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		
		// 출발지점 알파벳 넣기
		hs.add(board[0][0]);
		// 좌측 상단부터 말이 지나는 칸 구하기
		solve(0, 0, 1);
		// 출력
		System.out.print(max);
	}
	
	// 말이 지나는 칸 구하기
	private static void solve(int x, int y, int cnt) {
    // 최대값 구하기
		if (cnt > max) max = cnt;
        
		// 4방 탐색
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			// 범위를 벗어나면 다음 값 탐색
			if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
			// 새로운 알파벳이라 HashSet에 추가가 가능하다면
			if (hs.add(board[nx][ny])) {
				// 다음 칸을 기점으로 4방 탐색
				solve(nx, ny, cnt+1);
				// 해당 알파벳 제거
				hs.remove(board[nx][ny]);
			}
		}
	}
}

/*
입력
2 4
CAAB
ADCB

출력
3
*/
