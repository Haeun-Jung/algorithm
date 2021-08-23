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
