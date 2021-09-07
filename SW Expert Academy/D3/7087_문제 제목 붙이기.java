import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW_D3_7087_문제제목붙이기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		// 테스트케이스 수
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());	// 사용 가능한 제목 수
			char[] arr = new char[N];
			// 제목 맨 앞 글자 추출
			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine().charAt(0);
			}
			
			// 오름차순으로 정렬
			Arrays.sort(arr);
			int total = 0;
			int index = -1;
			// A가 중복되는 경우 검사해야할 마지막 인덱스 저장
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != 'A') break;
				index++;
			}
			
			// 만일 첫번째 제목이 A로 시작한다면 다음 요소도 탐색
			if (arr[0] == 'A') {
				for (int i = index; i < N; i++) {
					// 중복되는 경우 skip
					if (i+1 < N && arr[i] == arr[i+1]) continue;
					// 규칙이 성립하면 total + 1
					else if (i+1 < N && arr[i]+1 == arr[i+1]) {
						total++;
					}
					// 규칙에 어긋나는 경우 마지막 요소 1개 더하고 반복문 탈출
					else {
						total++;
						break;
					}
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
5
Air
Dad
Ear
Blue
Ace
3
Snow_White
A_Problem
Another_Problem
2
Good_Problem
Better_Problem

출력
#1 2
#2 1
#3 0
*/
