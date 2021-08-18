import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int len = sc.nextInt();					// 문자열의 길이
			char[] ch = sc.next().toCharArray();			// 문자 배열
			Stack<Character> stack = new Stack<Character>();	// 스택 초기화
			
			// ch 배열을 순회하며 stack의 마지막 괄호와 현재 ch[i]의 괄호가 유효한지 판단
			for (int i = 0; i < len; i++) {
				if (stack.isEmpty()) stack.push(ch[i]);
				else if (stack.peek() == '(' && ch[i] == ')') stack.pop();
				else if (stack.peek() == '[' && ch[i] == ']') stack.pop();
				else if (stack.peek() == '{' && ch[i] == '}') stack.pop();
				else if (stack.peek() == '<' && ch[i] == '>') stack.pop();
				else stack.push(ch[i]);
			}
			System.out.printf("#%d %d\n", tc, stack.isEmpty() ? 1 : 0);
		}
		sc.close();
	}
}

/* 테스트 케이스가 1개일 때
입력
182
(({<(({{[[[[<<[[(<[[{([{{{[<[[[{<<(<[[{}[]{}{}[]]]><><>{})[]{}><>[]<>><>}][]]<>{}]>]()}()()(){}}}{}][])(){}<>()}]{}[]]>()[][][]){}]]{}[]<>><>{}[]{}<>>]]]][]{}{}[]()}}))>}<>{}()))[][]

출력
#1 1
*/
