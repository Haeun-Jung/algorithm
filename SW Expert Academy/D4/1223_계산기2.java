import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SW_D4_1223_계산기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());			// 테스트 케이스의 길이
			String str = br.readLine();							      // 문자열
			Stack<Character> operator = new Stack<>();		// 연산자를 담을 stack
			Stack<Integer> calculator = new Stack<>();		// 계산할 stack
			Queue<Character> queue = new LinkedList<>();	// 후위표기식을 위한 queue
			int answer = 0;
			
			// 후위표기식으로 변환
			for (int i = 0; i < N; i++) {
				// 만일 숫자일 때
				if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
					queue.offer(str.charAt(i));
				}
				// 연산자일 때
				else {
					// 스택이 비어있을 때 push
					if (operator.isEmpty())	operator.push(str.charAt(i));
					// 스택이 비어있지 않을 때
					else {
						// 본인보다 기존에 있던 연산자가 우선순위가 같거나 높다면
						if (operator.peek() <= str.charAt(i)) {
							// 기존 연산자 pop
							while (operator.peek() <= str.charAt(i)) {
								queue.offer(operator.pop());
								if (operator.isEmpty()) break;
							}
							// 새로운 연산자 push
							operator.push(str.charAt(i));
						}
						// 본인보다 기존에 있던 연산자가 우선순위가 낮다면 push
						else operator.push(str.charAt(i));
					}
				}
			}
			
			// 남은 연산자 삽입
			while (!operator.isEmpty()) {
				queue.offer(operator.pop());
			}
			
			// 연산
			while (!queue.isEmpty()) {
				char ch = queue.poll();
				// 만일 숫자라면
				if (ch >= 48 && ch <= 57) {
					calculator.push(ch - '0');
				}
				// 연산자라면
				else {
					int no1 = 0;
					int no2 = 0;
					// *
					if (ch == 42) {
						no1 = calculator.pop();
						no2 = calculator.pop();
						calculator.push(no1 * no2);
					}
					// +
					else if (ch == 43) {
						no1 = calculator.pop();
						no2 = calculator.pop();
						calculator.push(no1 + no2);
					}
				}
				if (queue.isEmpty()) answer = calculator.pop();
			}
			
			// 출력
			System.out.printf("#%d %d\n", tc, answer);
		}
	}
}

/*
테스트케이스가 2개일 때

입력
101
9+5*2+1+3*3*7*6*9*1*7+1+8*6+6*1*1*5*2*4*7+4*3*8*2*6+7*8*4*5+3+7+2+6+5+1+7+6+7*3*6+2+6+6*2+4+2*2+4*9*3
79
4+4*3*4*9+2+7*4*7+7*7*9*5*2+8*8+2*6*7*3*7*9*3*4+8+8*9+3+9+6+9+4*1+6*3+5+1+7+5*1

출력
#1 28134
#2 195767
*/
