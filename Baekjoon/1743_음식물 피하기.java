/**
 * 음식물이 통로 중간 중간에 떨어져 있다. 이러한 음식물들은 근처에 있는 것끼리 뭉치게 돼서 큰 음식물 쓰레기가 된다. 
 * 통로에 떨어진 음식물을 피해가기란 쉬운 일이 아니다. 떨어진 음식물 중에 제일 큰 음식물만은 피해 가려고 한다.  
 *
 * 첫째 줄에 통로의 세로 길이 N(1 ≤ N ≤ 100)과 가로 길이 M(1 ≤ M ≤ 100) 그리고 음식물 쓰레기의 개수 K(1 ≤ K ≤ N×M)이 주어진다.
 * 그리고 다음 K개의 줄에 음식물이 떨어진 좌표 (r, c)가 주어진다.
 * 좌표 (r, c)의 r은 위에서부터, c는 왼쪽에서부터가 기준이다. 입력으로 주어지는 좌표는 중복되지 않는다.
 * 음식물 중 가장 큰 음식물의 크기를 출력하라.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1743_음식물피하기 {
	
	public static int N, M, K, max, size;
	// 4방 탐색
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static boolean[][] map, checked;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 세로 길이
		M = Integer.parseInt(st.nextToken());	// 가로 길이
		K = Integer.parseInt(st.nextToken());	// 음식물 쓰레기의 개수
		max = Integer.MIN_VALUE;		// 가장 큰 음식물의 크기
		size = 1;		                // 비교할 음식물의 크기
		map = new boolean[N+1][M+1];
		checked = new boolean[N+1][M+1];
		
		for (int i = 0; i < K; i++) {
			// 좌표(r, c)
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = true;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] && !checked[i][j]) {
					size = 1;
					dfs(i, j);
				}
			}
		}
		// 출력
		System.out.println(max);
	}

	// dfs
	public static void dfs (int x, int y) {
		checked[x][y] = true;
		
		// 4방 탐색
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 1 || ny < 1 || nx > N || ny > M) continue;
			if (map[nx][ny] && !checked[nx][ny]) {
				size++;
				dfs(nx, ny);
			}
		}
		
		// 최댓값 갱신
		if (max < size) max = size;
	}
}

/*
입력
3 4 5
3 2
2 2
3 1
2 3
1 1

출력
4
*/
