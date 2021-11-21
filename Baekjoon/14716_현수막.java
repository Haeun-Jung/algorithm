/**
 * 저번 학기 영상처리 수업을 듣고 배웠던 지식을 최대한 응용 해보고 싶은 혁진이는 이 현수막에서 글자가 몇 개인지 알아보는 프로그램을 만들려 한다.
 * 혁진이는 우선 현수막에서 글자인 부분은 1, 글자가 아닌 부분은 0으로 바꾸는 필터를 적용하여 값을 만드는데 성공했다.
 * 그런데 혁진이는 이 값을 바탕으로 글자인 부분 1이 상, 하, 좌, 우, 대각선으로 인접하여 서로 연결되어 있다면 한 개의 글자라고 생각만 하였다.
 * 혁진이가 필터를 적용하여 만든 값이 입력으로 주어졌을 때, 혁진이의 생각대로 프로그램을 구현하면 글자의 개수가 몇 개인지 출력하여라.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14716_현수막 {
	
	public static int M, N, cnt;
	public static int [][] map;
	public static boolean[][] checked;
	// 8방 탐색
	public static int [] dx = {1, 1, 1, -1, -1, -1, 0, 0};
	public static int [] dy = {1, 0, -1, 1, 0, -1, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());	// 세로
		N = Integer.parseInt(st.nextToken());	// 가로
		cnt = 0;                              // 글자의 개수
		map = new int[M][N];		      // 현수막
		checked = new boolean[M][N];
		
		// 현수막 채우기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                if (map[i][j] == 1 && !checked[i][j]){
                    dfs(i, j);
                    cnt++;
                }
            }
        }
		// 출력
        System.out.println(cnt);
	}

	// dfs
	public static void dfs (int x, int y) {
		if (map[x][y] == 1 && !checked[x][y]){
			checked[x][y] = true;
			
			// 8방 탐색
            for (int d = 0; d < 8; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 범위 이탈
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                dfs(nx, ny);
            }
        }
	}
}

/*
입력
8 19
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 1 0 0 0 1 0 0 0 1 0 1 1 1 1 1 0
0 0 1 0 1 0 0 1 1 0 0 1 0 0 0 1 0 0 0
0 1 0 0 0 1 0 1 0 1 0 1 0 0 0 1 0 0 0
0 1 1 1 1 1 0 1 0 1 0 1 0 0 0 1 0 0 0
0 1 0 0 0 1 0 1 0 0 1 1 0 0 0 1 0 0 0
0 1 0 0 0 1 0 1 0 0 0 1 0 0 0 1 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0

출력
3
*/
