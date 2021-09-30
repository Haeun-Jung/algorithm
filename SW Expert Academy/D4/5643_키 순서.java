import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_D4_5643_키순서 {
	
	public static int N, cnt;
	public static int[][] compare;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		// 테스트 케이스의 수
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());		  // 학생들의 수
			int M = Integer.parseInt(br.readLine());	// 두 학생의 키를 비교한 횟수
			compare = new int[N+1][N+1];				      // 키를 비교한 배열
			int num = 0;								              // 자신의 키가 몇번째인지 아는 학생 수
			
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());	// 작은 학생
				int b = Integer.parseInt(st.nextToken());	// 큰 학생
				compare[a][b] = 1;
			}
			
			for (int i = 1; i <= N; i++) {
				cnt = 0;								        // 비교 횟수
				bfs(i);
				if (cnt == N-1) num++;					// 본인을 제외한 모든 학생을 다 비교했다면	
			}
			
			// 출력
			System.out.printf("#%d %d\n", tc, num);
		}
	}
	
	// bfs
	public static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		queue.offer(n);
		visited[n] = true;
		
		// 키 큰 사람 찾기
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && compare[temp][i] == 1) {
					cnt++;
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		
		visited = new boolean[N+1];
		queue.offer(n);
		visited[n] = true;
		
		// 키 작은 사람 찾기
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && compare[i][temp] == 1) {
					cnt++;
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
	}
}
