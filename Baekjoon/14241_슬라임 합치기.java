/**
 * 모든 슬라임은 양수 크기를 가지고 있다. 두 슬라임 x와 y를 합쳤을 때, 합친 슬라임의 크기는 x+y가 된다. 또한, 슬라임을 합칠 때 마다 두 사람은 x*y 점수를 얻게 된다.
 * 영선이와 효빈이가 얻을 수 있는 점수의 최댓값을 구하는 프로그램을 작성하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14241_슬라임합치기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 슬라임의 개수
		int[] arr = new int[N];						// 슬라임의 크기
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		// 점수 구하기
		int sum = 0;
		for (int i = 0; i < N-1; i++) {
			for (int j = i + 1; j < N; j++) {
				sum += arr[i] * arr[j];
			}
		}
		
		// 출력
		System.out.println(sum);
	}
}

/*
입력
2
3 4

출력
12
*/
