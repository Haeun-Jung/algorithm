import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_D2_1961_숫자배열회전 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		// 테스트케이스 개수
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());	// 행렬의 크기
			int[][] arr = new int[N][N];
			// 행렬
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			String[][] result = new String[N][3];
			// 90도
			for (int y = 0; y < N; y++) {
				String num = "";
				for (int x = N-1; x >= 0; x--) {
					num += arr[x][y];
				}
				result[y][0] = num;
			}
			
			// 180도
			int cnt = 0;
			for (int x = N-1; x >= 0; x--) {
				String num = "";
				for (int y = N-1; y >= 0; y--) {
					num += arr[x][y];
				}
				result[cnt++][1] = num;
			}
			
			// 270도
			cnt = 0;
			for (int y = N-1; y >= 0; y--) {
			String num = "";
				for (int x = 0; x < N; x++) {
					num += arr[x][y];
				}
				result[cnt++][2] = num;
			}
			
			// 출력
			System.out.printf("#%d\n", tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.printf("%s ", result[i][j]);
				}
				System.out.println();
			}
		}
	}
}

/*
입력
2
3
1 2 3
4 5 6
7 8 9
6
6 9 4 7 0 5
8 9 9 2 6 5
6 8 5 4 9 8
2 2 7 7 8 4
7 5 1 9 7 9
8 9 3 9 7 6

출력
#1
741 987 369
852 654 258
963 321 147
#2
872686 679398 558496
952899 979157 069877
317594 487722 724799
997427 894586 495713
778960 562998 998259
694855 507496 686278
*/
