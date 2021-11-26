/**
 * 첫 번째 줄에 정수 K가 주어진다. (1 ≤ K ≤ 100,000)
 * 이후 K개의 줄에 정수가 1개씩 주어진다. 정수는 0에서 1,000,000 사이의 값을 가지며, 정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다.
 * 정수가 "0"일 경우에 지울 수 있는 수가 있음을 보장할 수 있다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773_제로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		
		int K = Integer.parseInt(br.readLine());		// K개
		
		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());	// 정수
			
			if (num == 0) stack.pop();	                // 0이면 가장 최근 값 제거
			else stack.push(num);		        	// 0이 아니면 push
		}
		
		// 합계 구하기
		int sum = 0;
		for (int i : stack) sum += i;
		
		// 출력
		System.out.println(sum);
	}
}

/*
입력
4
3
0
4
0

출력
0
*/
