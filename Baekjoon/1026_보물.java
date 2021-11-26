/**
 * 길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.
 * S = A[0] × B[0] + ... + A[N-1] × B[N-1]
 * S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 단, B에 있는 수는 재배열하면 안 된다.
 * S의 최솟값을 출력하는 프로그램을 작성하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1026_보물 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 길이 N
		int[] A = new int[N];
		int[] B = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) B[i] = Integer.parseInt(st.nextToken());

		// 정렬
		Arrays.sort(A);
		Arrays.sort(B);
		
		// S의 최솟값 구하기
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += A[i] * B[N-i-1];
		}
		// 출력
		System.out.println(sum);
	}
}

/*
입력
5
1 1 1 6 0
2 7 8 3 1

출력
18
*/
