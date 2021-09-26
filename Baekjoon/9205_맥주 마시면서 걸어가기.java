/**
 * 송도에 사는 상근이와 친구들은 송도에서 열리는 펜타포트 락 페스티벌에 가려고 한다.
 * 올해는 맥주를 마시면서 걸어가기로 했다. 출발은 상근이네 집에서 하고, 맥주 한 박스를 들고 출발한다.
 * 맥주 한 박스에는 맥주가 20개 들어있다. 목이 마르면 안되기 때문에 50미터에 한 병씩 마시려고 한다.
 * 즉, 50미터를 가려면 그 직전에 맥주 한 병을 마셔야 한다.
 *
 * 상근이의 집에서 페스티벌이 열리는 곳은 매우 먼 거리이다. 따라서, 맥주를 더 구매해야 할 수도 있다.
 * 미리 인터넷으로 조사를 해보니 다행히도 맥주를 파는 편의점이 있다.
 * 편의점에 들렸을 때, 빈 병은 버리고 새 맥주 병을 살 수 있다.
 * 하지만, 박스에 들어있는 맥주는 20병을 넘을 수 없다.
 * 편의점을 나선 직후에도 50미터를 가기 전에 맥주 한 병을 마셔야 한다.
 * 
 * 편의점, 상근이네 집, 펜타포트 락 페스티벌의 좌표가 주어진다.
 * 상근이와 친구들이 행복하게 페스티벌에 도착할 수 있는지 구하는 프로그램을 작성하시오.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9205_맥주마시면서걸어가기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		// 테스트케이스의 수
		
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());	// 편의점의 수
			int[] x = new int[n+2];
			int[] y = new int[n+2];
			int[][] map = new int[n+2][n+2];
			
			// 좌표 입력 받기
			for (int i = 0; i < n+2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < n+2; i++) {
				// 자기자신
				map[i][i] = 1;
				for (int j = i+1; j < n+2; j++) {
					int d = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
					// 50 * 20이내, 도착 가능
					if (d <= 50 * 20) {
						map[i][j] = map[j][i] = 1;
					}
				}
			}
			
			// 플로이드-와샬
			// 경유지
			for (int k = 0; k < n+2; k++) {
				// 출발지
				for (int i = 0; i < n+2; i++) {
					// 도착지
					for (int j = 0; j < n+2; j++) {
						if (map[i][k] == 1 && map[k][j] == 1) map[i][j] = 1;
					}
				}
			}
			
			// 출력
			System.out.println(map[0][n+1] == 1 ? "happy" : "sad");
		}
	}
}

/*
입력
2
2
0 0
1000 0
1000 1000
2000 1000
2
0 0
1000 0
2000 1000
2000 2000

출력
happy
sad
*/
