/**
 * 흑백 영상을 압축하여 표현하는 데이터 구조로 쿼드 트리(Quad Tree)라는 방법이 있다.
 * 흰 점을 나타내는 0과 검은 점을 나타내는 1로만 이루어진 영상(2차원 배열)에서 같은 숫자의 점들이 한 곳에 많이 몰려있으면,
 * 쿼드 트리에서는 이를 압축하여 간단히 표현할 수 있다.

 * 주어진 영상이 모두 0으로만 되어 있으면 압축 결과는 "0"이 되고, 모두 1로만 되어 있으면 압축 결과는 "1"이 된다.
 * 만약 0과 1이 섞여 있으면 전체를 한 번에 나타내지를 못하고, 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래,
 * 이렇게 4개의 영상으로 나누어 압축하게 되며,이 4개의 영역을 압축한 결과를 차례대로 괄호 안에 묶어서 표현한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1992_쿼드트리 {
	private static int[][] video;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 영상의 크기
		video = new int[N][N];
		
		// 영상 생성
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < N; j++) {
				video[i][j] = str.charAt(j) - '0';
			}
		}
		solve(0, 0, N);
		// 출력
		System.out.println(sb);
	}
	
	private static void solve(int x, int y, int num) {
		boolean flag = true;					        // 같은지 다른지 판별
		int origin = video[x][y];
		
		// 압축되는지 확인
		for (int i = x; i < x + num; i++) {
			for (int j = y; j < y + num; j++) {
				// 영역안에서 다른 수가 나온다면, 반복문 탈출
				if (origin != video[i][j]) {
					flag = false;
					break;
				}
			}
			if (!flag) break;
		}
		// 압축이 잘 되었다면 sb에 저장
		if (flag) sb.append(origin);
		// 압축이 되지 않았다면 4개의 영상으로 나누기
		else {
			sb.append("(");
			solve(x, y, num/2);						      // 왼쪽 위
			solve(x, y + num/2, num/2);				  // 오른쪽 위
			solve(x + num/2, y, num/2);				  // 왼쪽 아래
			solve(x + num/2, y + num/2, num/2);	// 오른쪽 아래
			sb.append(")");
		}
	}
}

/*
입력
8
11110000
11110000
00011100
00011100
11110000
11110000
11110011
11110011

출력
((110(0101))(0010)1(0001))
*/
