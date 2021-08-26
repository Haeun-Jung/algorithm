/*
가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다. 
이 도화지 위에 가로, 세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이를 색종이의 변과 도화지의 변이 평행하도록 붙인다. 
이러한 방식으로 색종이를 한 장 또는 여러 장 붙인 후 색종이가 붙은 검은 영역의 둘레의 길이를 구하는 프로그램을 작성하시오.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2567_색종이2 {

	public static void main(String[] args) throws IOException {
		// 4방탐색
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 색종이 수
		int[][] paper = new int[101][101];			  // 도화지
		int total = 0;								            // 둘레의 길이
		
		// 색종이 개수만큼 붙이기
		for (int cnt = 0; cnt < N; cnt++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int i = x; i < x+10; i++) {
				for (int j = y; j < y+10; j++) {
					paper[i][j] = 1;
				}
			}
		}
		// 둘레의 길이 구하기
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (paper[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (nx < 0 || ny < 0 || nx > 100 || ny > 100) continue;
						if (paper[nx][ny] == 0) total++;
					}
				}
			}
		}
		// 출력
		System.out.println(total);
	}
}

/*
입력
4
3 7
5 2
15 7
13 14

출력
96
*/
