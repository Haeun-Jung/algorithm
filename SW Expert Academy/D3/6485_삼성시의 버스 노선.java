import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		// 테스트케이스 개수
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());	// 버스 노선
			int[][] bus = new int[N][2];
			// 버스 노선 범위
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 2; j++) {
					bus[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 번호를 입력 받아 노선범위 체크
			int P = Integer.parseInt(br.readLine());
			int[] result = new int[P];
			for (int i = 0; i < P; i++) {
				int num = Integer.parseInt(br.readLine());
				int cnt = 0;
				for (int k = 0; k < N; k++) {
					if (num >= bus[k][0] && num <= bus[k][1]) cnt++;
				}
				result[i] = cnt;
			}
			
			// 출력
			System.out.printf("#%d ", tc);
			for (int i = 0; i < P; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
		}
	}
}

/*
입력
1
2
1 3
2 5
5
1
2
3
4
5

출력
#1 1 2 2 1 1
*/
