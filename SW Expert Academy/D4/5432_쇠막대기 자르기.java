import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); 					// 테스트케이스
		
		for (int tc = 1; tc <= T; tc++) {
			char[] arr = sc.next().toCharArray();
			int sum = 0;						// 쇠막대기 합계
			Stack<Character> stack= new Stack<Character>();
			
			// 배열을 순회하면서
			for (int i = 0; i < arr.length; i++) {
				// 만일 레이저가 나왔다면, 지금까지 있던 막대 개수를 sum에 더하고
				// 다음 값으로 이동
				if (arr[i] == '(' && arr[i+1] == ')') {
					if (!stack.isEmpty()) {
						sum += stack.size();
					}
					i++;
				}
				// 만일 막대기의 길이가 끝났다면, 합계 +1
				// stack에서 해당 막대기 pop
				else if (arr[i] == ')') {
					sum++;
					stack.pop();
				}
				// 막대기가 시작한다면 stack에 push
				else {
					stack.push(arr[i]);
				}
			}
			// 출력
			System.out.printf("#%d %d\n", tc, sum);
		}
		sc.close();
	}
}
/*
입력
2
()(((()())(())()))(())
(((()(()()))(())()))(()())

출력
#1 17
#2 24
*/