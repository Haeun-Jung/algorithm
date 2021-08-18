import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Queue<String> q1 = new LinkedList<String>();
		Queue<String> q2 = new LinkedList<String>();
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); 						// 테스트케이스의 수
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); 					// N개의 카드
			String[] arr = new String[N];
			
			// 카드 채우기
			for (int i = 0; i < N; i++) {
				arr[i] = sc.next();
				// 예외처리
				if (arr[i].length() > 80) return;
			}
			
			// 카드 덱을 절반으로 나누기, 홀수는 한 장 더
			int center = arr.length % 2 == 0 ? 0 : 1;
			for (int i = 0; i < arr.length; i++) {
				if (i < arr.length / 2 + center) q1.offer(arr[i]);
				else q2.offer(arr[i]);
			}
			
			// 교대로 출력
			System.out.printf("#%d ", tc);
			while (!q1.isEmpty() || !q2.isEmpty()) {
				System.out.printf("%s ", q1.poll());
				if (!q2.isEmpty()) System.out.printf("%s ", q2.poll());
			}
			System.out.println();
 		}
	}
}

/*
입력
3
6
A B C D E F
4
JACK QUEEN KING ACE
5
ALAKIR ALEXSTRASZA DR-BOOM LORD-JARAXXUS AVIANA

출력
#1 A D B E C F
#2 JACK KING QUEEN ACE
#3 ALAKIR LORD-JARAXXUS ALEXSTRASZA AVIANA DR-BOOM
*/
