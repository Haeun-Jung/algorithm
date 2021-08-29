import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_D3_4698_테네스의특별한소수 {

	public static void main(String[] args) throws IOException {
		// 소수 구해놓기
		int[] arr = new int[1000001];
		for (int i = 2; i < arr.length; i++) {
			int j = 2;
			while (i * j <= 1000000) {
				arr[i*j] = 1;
				j++;
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		// 테스트케이스 개수
		
		for (int tc = 1; tc <= T; tc++) {
			int count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int D = Integer.parseInt(st.nextToken());	// 특정 숫자
			int A = Integer.parseInt(st.nextToken());	// A 이상
			int B = Integer.parseInt(st.nextToken());	// B 이하
			
			// 특별한 소수 찾기
			if (A == 1) A = 2;
			for (int i = A; i <= B; i++) {
				if (arr[i] == 1) continue;
				String str = String.valueOf(i);
				for (int j = 0; j < str.length(); j++) {
					if (str.charAt(j)-'0' == D) {
						count++;
						break;
					}
				}
			}
			// 출력
			System.out.printf("#%d %d\n", tc, count);
		}
	}
}

/*
입력
2
3 10 30
7 1 1000000

출력
#1 2
#2 43506
*/
