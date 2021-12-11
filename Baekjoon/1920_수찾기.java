/**
 * 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.
 * M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// N개의 정수
		HashSet<Integer> A = new HashSet<>();		// 중복체크
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) A.add(Integer.parseInt(st.nextToken()));
		
		int M = Integer.parseInt(br.readLine());	// M개의 정수
		int[] B = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) B[i] = Integer.parseInt(st.nextToken());
		
		// 출력
		for (int i : B) {
			// 존재 O
			if (A.contains(i)) System.out.println(1); 
			// 존재 X
			else System.out.println(0);
		}
	}
}

/*
입력
5
4 1 5 2 3
5
1 3 7 9 5

출력
1
1
0
0
1
*/
