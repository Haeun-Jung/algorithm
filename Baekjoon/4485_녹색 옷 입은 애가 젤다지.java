/**
 * 링크는 지금 도둑루피만 가득한 N x N 크기의 동굴의 제일 왼쪽 위에 있다.
 * 링크는 이 동굴의 반대편 출구, 제일 오른쪽 아래 칸인 [N-1][N-1]까지 이동해야 한다.
 * 동굴의 각 칸마다 도둑루피가 있는데, 이 칸을 지나면 해당 도둑루피의 크기만큼 소지금을 잃게 된다.
 * 링크는 잃는 금액을 최소로 하여 동굴 건너편까지 이동해야 하며, 한 번에 상하좌우 인접한 곳으로 1칸씩 이동할 수 있다.
 *
 * 링크가 잃을 수밖에 없는 최소 금액은 얼마일까?
 */

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_4485_녹색옷입은애가젤다지 {
	static int N;
	static int[][] map;
	static int[][] dist;
	static int result;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int idx = 0;
		while (true) {
			N = sc.nextInt();
			if (N == 0) {
				break;
			}
			map = new int[N][N];		// 원래 지도
			dist = new int[N][N];		// 최솟값 갱신할 배열
			idx++;						      // 테스트케이스 번호
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					dist[i][j] = Integer.MAX_VALUE;	// 최댓값으로 초기화
				}
			}
			// 출력
			System.out.println("Problem " + idx + ": " + solve());
		}
		sc.close();
	}

	// 시뮬레이션
	static int solve() {
		// 최솟값으로 자동 정렬됨, 같은 level에 있는 값들이 있을 때 자동 정렬
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(0, 0, map[0][0]));	// 시작점
		dist[0][0] = map[0][0];				      // 시작점 비용 갱신
		while (!q.isEmpty()) {
			Node node = q.poll();
			// 이미 지나온 인접한곳은 가지 않는다.
			if (dist[node.x][node.y] < node.cost)
				continue;

			// 4방탐색
			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				// 아직 갱신되지 않은 값이라면(무한대 수를 만났다면) 갱신해주기
				if (dist[nx][ny] > dist[node.x][node.y] + map[nx][ny]) {
					dist[nx][ny] = dist[node.x][node.y] + map[nx][ny];
					// 다음값도 갱신하기 위해 queue에 넣기
					q.offer(new Node(nx, ny, map[nx][ny]));
				}
			}
		}
		return dist[N - 1][N - 1];
	}

	// Node 클래스
	static class Node implements Comparable<Node> {
		// x좌표, y좌표, 비용
		int x, y;
		int cost;

		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		// 비용이 작은것부터 되어야하니 오름차순으로 정렬
		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
	}
}

/*
입력
3
5 5 4
3 9 1
3 2 7
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
7
9 0 5 1 1 5 3
4 1 2 1 6 5 3
0 7 6 1 6 8 5
1 1 7 8 3 2 3
9 4 0 7 6 4 1
5 8 3 2 4 8 3
7 4 8 4 8 3 4
0

출력
Problem 1: 20
Problem 2: 19
Problem 3: 36
*/
