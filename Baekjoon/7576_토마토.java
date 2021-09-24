/** 
 * 창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다.
 * 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
 * 하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다.
 * 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다.
 * 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
 * 
 * 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라.
 * 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
	// 4방 탐색
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int M, N, day, zero;
	public static int[][] map;
	public static boolean[][] visited;
	public static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());	// 가로 칸
		N = Integer.parseInt(st.nextToken());	// 세로 칸
		map = new int[N][M];
		visited = new boolean[N][M];
		zero = 0;
		day = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) zero++;
			}
		}
		
		// 안익은 토마토가 없다면
		if (zero == 0) System.out.println(day);
		// 안익은 토마토가 있다면
		else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						queue.offer(new int[] {i, j});
					}
				}
			}
			bfs();
			System.out.println(day);
		}
	}
	
	// bfs
	public static void bfs() {
		while (zero != 0 && !queue.isEmpty()) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];
			
			// 4방 탐색
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] != 0) continue;
				// 익은 토마토의 영향을 받음
				if (map[nx][ny] == 0 && !visited[nx][ny]) {
					queue.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
					map[nx][ny] = map[x][y]+1;
					day = map[nx][ny];
					zero--;
				}
			}
		}
		// day를 2부터 시작했으니 -1
		day = zero == 0 ? day-1 : -1;
	}
}

/*
입력
6 4
1 -1 0 0 0 0
0 -1 0 0 0 0
0 0 0 0 -1 0
0 0 0 0 -1 1

출력
6
*/
