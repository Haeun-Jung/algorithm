/*
"OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다.
O는 문제를 맞은 것이고, X는 문제를 틀린 것이다.
문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다.
예를 들어, 10번 문제의 점수는 3이 된다.
"OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8958_OX퀴즈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());			// 테스트케이스 개수
		
		for (int tc = 1; tc <= T; tc++) {
			int total = 0;									// 점수
			int num = 1;									// 연속된 O의 개수
			String str = br.readLine();						// 문자열
			
			// 문자열 탐색
			for (int k = 0; k < str.length(); k++) {
				// 맞았을 경우
				if (str.charAt(k) == 'O') {
					// 연속으로 맞았을 경우
					if (k > 0 && str.charAt(k-1) == 'O') {
						total += ++num;
					}
					else {
						num = 1;
						total += num;
					}
				}
			}
			// 출력
			System.out.println(total);
		}
	}
}

/*
입력
5
OOXXOXXOOO
OOXXOOXXOO
OXOXOXOXOXOXOX
OOOOOOOOOO
OOOOXOOOOXOOOOX

출력
10
9
7
55
30
*/
