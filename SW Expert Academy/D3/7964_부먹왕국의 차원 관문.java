import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_D3_7964_부먹왕국의차원관문 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());			// 테스트케이스의 수
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());		// 도시의 수
			int D = Integer.parseInt(st.nextToken());		// 이동 제한 거리
			int cnt = 0;
			
			st = new StringTokenizer(br.readLine(), " ");
			int[] city = new int[N];
			for (int i = 0; i < N; i++) city[i] = Integer.parseInt(st.nextToken());
			
			// 가장 처음 위치한 차원 관문
			int index = -1;
			for (int i = 0; i < N; i++) {
				if (city[i] == 1) break;
				index++;
			}
			if (index == -1) index = 0;
			else index = -D;
			
			// 이동 제한 거리에 맞춰 차원 관문 설치
			for (int i = 0; i < N; i++) {
				if (city[i] == 1) index = i;
				else if (Math.abs(i-index) >= D) {
					cnt++;
					index = i;
				}
			}
			// 출력
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}
}

/*
입력
3
6 2
1 0 0 0 0 1
10 2
0 0 1 0 1 0 0 0 0 1
10 1
0 0 0 0 0 0 0 0 0 0

출력
#1 2
#2 3
#3 10
*/
