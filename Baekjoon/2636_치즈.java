/**
 *  입력으로 사각형 모양의 판의 크기와 한 조각의 치즈가 판 위에 주어졌을 때, 
 *  공기 중에서 치즈가 모두 녹아 없어지는 데 걸리는 시간과 
 *  모두 녹기 한 시간 전에 남아있는 치즈조각이 놓여 있는 칸의 개수를 구하는 프로그램을 작성하시오.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {
	static int R, C, cheeseCount;				// 행, 열, 치즈갯수
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());	// 세로
		C = Integer.parseInt(st.nextToken());	// 가로
		map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) cheeseCount++;
			}
		}
		// bfs 방식으로 치즈 녹이기
		int last = 0, time = 0;
		while (cheeseCount != 0) {
			last = cheeseCount;
			time++;
			changeAir();
		}
		System.out.println(time);
		System.out.println(last);
	}
	
	/**
	 * 맵의 데이터를 하나씩 접근하면서 치즈(1)인 부분을 공기(0)으로 변경한다.
	 * BFS 이용
	 */
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static void changeAir() {
		boolean[][] visited = new boolean[R][C];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0});
		visited[0][0] = true;
		
		while (!q.isEmpty()) {
			int[] data = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = data[0] + dr[d];
				int nc = data[1] + dc[d];
				// 범위체크
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				// 방문체크 확인
				if (visited[nr][nc]) continue;
				
				// 방문체크하기
				visited[nr][nc] = true;
				// 0이나 1인 경우
				if (map[nr][nc] == 0) {
					q.offer(new int[] {nr, nc});
					continue;
				}
				// 1인 경우 - 치즈인 경우
				map[nr][nc] = 0;
				cheeseCount--;
			}
		}
	}
}

/*
입력
13 12
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 1 1 0 0 0
0 1 1 1 0 0 0 1 1 0 0 0
0 1 1 1 1 1 1 0 0 0 0 0
0 1 1 1 1 1 0 1 1 0 0 0
0 1 1 1 1 0 0 1 1 0 0 0
0 0 1 1 0 0 0 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0

출력
3
5
*/
