import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15655_N과M6 {
	private static int N, M;
	private static int[] arr, result;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[M];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		comb(0, 0);
		System.out.println(sb);
	}
	
	// 조합
	private static void comb(int cnt, int start) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) sb.append(result[i]).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < N; i++) {
			result[cnt] = arr[i];
			comb(cnt+1, i+1);
		}
	}
}

/*
입력
4 2
9 8 7 1

출력
1 7
1 8
1 9
7 8
7 9
8 9
*/
