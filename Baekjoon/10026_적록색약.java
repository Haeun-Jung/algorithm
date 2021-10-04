/**
 * 크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다.
 * 그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있다.
 * 또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다. (색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)
 * 
 * 예를 들어, 그림이 아래와 같은 경우에
 * RRRBB
 * GGBBB
 * BBBRR
 * BBRRR
 * RRRRR
 * 적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1) 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)
 * 그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// DFS
public class BOJ_10026_적록색약 {
	// 4방탐색
	static int[] dx = {0, 0, -1 ,1};
	static int[] dy = {1, -1, 0, 0};
	static char[][] picture;
	static int answer, N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());			// 크기 N*N
		picture = new char[N][N];						// 그림
		char[][] yesRG = new char[N][N];				// 적록색약인 사람
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				picture[i][j] = s.charAt(j);
				// 적록색약은 초록을 빨강으로 통일
				if (picture[i][j] == 'G') yesRG[i][j] = 'R';
				else yesRG[i][j] = picture[i][j];
			}
		}
		
		// 적록색약이 아닌 사람
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 체크하지 않은 요소라면
				if (picture[i][j] != '0') {
					dfs(i,j);
					answer++;
				}
			}
		}
		// 적록색약이 아닌 사람 출력
		System.out.print(answer + " ");
		
		answer =0;
		// 적록색약인 사람 탐색
		picture = yesRG;
		// 적록색약인 사람
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 체크하지 않은 요소라면
				if (picture[i][j] != '0') {
					dfs(i,j);
					answer++;
				}
			}
		}
		// 적록색약인 사람 출력
		System.out.println(answer);
	}
	
	// DFS
	static void dfs(int x, int y) {
		char ch = picture[x][y];
		picture[x][y] = '0';
		
		// 4방 탐색
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if (picture[nx][ny] == ch) {
				dfs(nx,ny);
			}
		}
	}
}

/*
입력
5
RRRBB
GGBBB
BBBRR
BBRRR
RRRRR

출력
4 3
*/
