/**
 * 최근 준하가 구입한 라디오는 매우 하이테크 한데, 그 라디오에는 다음과 같은 버튼이 있다.
 *
 * 첫 번째 버튼은 주파수를 1MHz 증가시킨다.
 * 두 번째 버튼은 주파수를 1MHz 감소시킨다.
 * 나머지 N개의 버튼은 즐겨찾기 기능으로, 미리 지정된 주파수로 이동한다.
 * 준하는 몸이 안좋아 하루에 손가락을 몇 번 움직이지 못하기 때문에 우리의 도움이 필요하다.
 * 
 * 현재 주파수 A와 듣고싶은 주파수 B가 주어질 때, 주파수 A에서 B로 갈 때 눌러야 하는 가장 적은 버튼수를 구해주자.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3135_라디오 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 정수 A와 B
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		// N개
		int N = Integer.parseInt(br.readLine());
		// 최솟값
		int min = Math.abs(A-B);
		
		for (int i = 0; i < N; i++) {
			// 주파수
			int frequency = Integer.parseInt(br.readLine());
			int temp = Math.abs(B-frequency) + 1;
			// 최솟값 갱신
			if (temp < min) min = temp;
		}
		
		// 출력
		System.out.println(min);
	}
}

/*
입력
88 17
3
18
1
42

출력
2
*/
