import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_D2_1859_백만장자프로젝트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		// 테스트케이스의 수
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());	// N일
			long total = 0;
			
			// N일 동안의 매매가 입력 받기
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] days = new int[N];
			for (int i = 0; i < N; i++) {
				days[i] = Integer.parseInt(st.nextToken());
			}
			
			// 마지막 날부터 사재기 계산
			int max = days[N-1];
			for (int i = N-2; i >= 0; i--) {
				if (days[i] < max) {
					total += max - days[i];
				} else {
					max = days[i];
				}
				
			}
			
			// 출력
			System.out.printf("#%d %d\n", tc, total);
		}
	}
}

/*
입력
3
3
10 7 6
3
3 5 9
5
1 1 3 1 2

출력
#1 0
#2 10
#3 5
*/
