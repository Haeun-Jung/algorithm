import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_D3_3307_최장증가부분수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		// 테스트케이스의 수
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());	// 수열의 길이
			int[] arr = new int[N];						// 수열
			int[] LIS = new int[N];						// 최장길이 찾기
			int max = 0;								// 최장 길이
			
			// 수열
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// DP
			int size = 0;	// LIS에 채워진 원소 수
			for (int i = 0; i < N; i++) {
				// 중복값이 없으므로 탐색 실패 : 음수값 ==> 삽입 위치로 환산
				int temp = Math.abs(Arrays.binarySearch(LIS, 0, size, arr[i]))-1;
				LIS[temp] = arr[i];
				
				// 추가된 위치가 맨 뒤라면 사이즈 증가
				if (temp == size) ++size;
			}
			
			// 출력
			System.out.printf("#%d %d\n", tc, size);
		}
	}
}

/*
입력
2
5
1 3 2 5 4 
6
4 2 3 1 5 6

출력
#1 3
#2 4
*/
