/**
 * 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
 * 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
 * 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
 * N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1158_요세푸스 {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();						// N명
		int K = sc.nextInt();						// K번째
		int[] result = new int[N];			// 제거되는 순서를 담을 배열
		
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		int index = 0;
		// queue 요소가 없을 때까지
		while (!queue.isEmpty()) {
			int cnt = K;
			// 제거되기 직전 사람까지 queue에서 poll한 값을 다시 offer
			while (cnt-- > 1) {
				queue.offer(queue.poll());
			}
			// 제거되는 사람을 result 배열에 담기
			result[index] = queue.poll();
			index++;
		}
		
		// 출력
		System.out.print("<");
		for (int i = 0; i < result.length; i++) {
			if (i < result.length - 1) System.out.print(result[i] + ", ");
			else System.out.print(result[i] + ">");
		}
		sc.close();
	}
}

/*
입력
7 3

출력
<3, 6, 2, 7, 5, 1, 4>
*/
