import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_D3_4789_성공적인공연기획 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// 테스트케이스 개수
		
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();				      // 문자열
			int cnt = 0;							              // 고용해야될 사람
			int total = 0;							            // 박수치는 사람
			for (int i = 0; i < str.length(); i++) {
				int n = str.charAt(i) - '0';
				if (n != 0) {
					// 조건이 만족하지 않으면 고용하기
					if (total < i) {
						int num = i-total;
						total += n + num;
						cnt += num;
					}
					// 조건을 만족할 때 박수치기
					else total += n;
				}
			}
			// 출력
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}
}

/*
입력
4
11111
09
110011
1

출력
#1 0
#2 1
#3 2
#4 0
*/
