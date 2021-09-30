import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SW_D4_1249_보급로 {
	
	public static int N;
	public static int[][] map, time;
	// 4방 탐색
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// 테스트케이스의 번호
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());	  // 지도의 크기
			map = new int[N][N];
			time = new int[N][N];					          // 소요 시간
			
			// 지도 채우기
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
					// 출발점
					if (i == 0 && j == 0) time[i][j] = 0;
					// 최댓값 지정
					else time[i][j] = 999;
				}
			}
			
			solve();
			//출력
			System.out.printf("#%d %d\n", tc, time[N-1][N-1]);
		}
	}
	
	public static void solve() {
		// 출발점
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0});
		
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int x = temp[0];
			int y = temp[1];
			// 4방탐색
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				// 최솟값 갱신
				if (time[nx][ny] > time[x][y] + map[nx][ny]) {
					q.offer(new int[] {nx, ny});
					time[nx][ny] = time[x][y] + map[nx][ny];
				}
			}
		}
	}
}

/*
입력
2
4
0100
1110
1011
1010
6
011001
010100
010011
101001
010101
111010

출력
#1 2
#2 2
*/
