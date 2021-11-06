/**
 * 그래프가 주어졌을 때, 그 그래프의 최소 스패닝 트리를 구하는 프로그램을 작성하시오.
 * 최소 스패닝 트리는, 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리를 말한다.
 * 입력으로 주어지는 그래프는 하나의 연결 그래프임이 보장된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static class Edge implements Comparable<Edge>{
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			// 오름차순
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int[] parents;	// 부모원소 관리
	
	private static void make() {
		parents = new int[V+1];
		// 모든 원소를 자신을 대표자로 만듬
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	// 대표자 찾기
	private static int find(int a) {
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	// 두 원소 합치기
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		// 이미 연결되어 있음
		if (aRoot == bRoot) return false;
		
		// 연결시키기
		parents[bRoot] = aRoot;
		return true;
	}
	
	static int V, E;
	static Edge[] edgeList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		// 테스트케이스의 수
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());		// 정점의 수
			E = Integer.parseInt(st.nextToken());		// 간선의 수
			
			// 간선 리스트 작성
			edgeList = new Edge[E];
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(start, end, weight);
			}
			// 오름차순으로 정렬
			Arrays.sort(edgeList);
			
			make();
			
			// 트리 만들기
			int cnt = 0;
			long result = 0;
			for (Edge edge : edgeList) {
				if (union(edge.start, edge.end)) {
					result += edge.weight;
					cnt++;
					// 트리 완성
					if (cnt == V-1) break;
				}
			}
			// 출력
			System.out.printf("#%d %d\n", tc, result);
		}
	}
}

/*
입력
1
3 3
1 2 1
2 3 2
1 3 3

출력
#1 3
*/
