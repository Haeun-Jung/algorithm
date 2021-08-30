import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_D3_7236_저수지의물의총깊이구하기 {

	public static void main(String[] args) throws IOException {
		int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
		int[] dy = {0, -1, 0, 1, -1, 1, -1, 1};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		// 테스트케이스
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());	// 저수지 크기
			int max = Integer.MIN_VALUE;
			char[][] area = new char[N][N];
			
			// 저수지
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					area[i][j] = st.nextToken().charAt(0);
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 저수지라면
					if (area[i][j] == 'W') {
						int total = 0;
						int cnt = 0;
						// 8방 탐색
						for (int d = 0; d < 8; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							if (nx < 0 || ny < 0 || nx >= N || ny >= N || area[nx][ny] == 'G') continue;
							cnt++;
						}
						// 주변에 저수지가 없을 때
						if (cnt == 0) total = 1;
						else total = cnt;
						// 최대값 찾기
						if (total > max) max = total;
					}
				}
			}
      // 출력
			System.out.printf("#%d %d\n", tc, max);
		}
	}
}

/*
입력
4
6
G W G G W W
G W G G W G
W W W W G W
W G W W W G
G W W W W G
G W W G W G
5
G W G G W
G W G G W
W W W W G
W G W W W
G W W W W
3
G G W
G W W
W W W
3
G G G
G W G
G G G

출력
#1 7
#2 7
#3 5
#4 1
*/
