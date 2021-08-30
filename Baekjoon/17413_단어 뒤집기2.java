/*
문자열 S가 주어졌을 때, 이 문자열에서 단어만 뒤집으려고 한다.

먼저, 문자열 S는 아래와과 같은 규칙을 지킨다.

알파벳 소문자('a'-'z'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
문자열의 시작과 끝은 공백이 아니다.
'<'와 '>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<'이 먼저 등장한다. 또, 두 문자의 개수는 같다.
태그는 '<'로 시작해서 '>'로 끝나는 길이가 3 이상인 부분 문자열이고, '<'와 '>' 사이에는 알파벳 소문자와 공백만 있다.
단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열이고, 연속하는 두 단어는 공백 하나로 구분한다.
태그는 단어가 아니며, 태그와 단어 사이에는 공백이 없다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17413_단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			// 태그
			if (str.charAt(i) == '<') {
				// 닫는 괄호를 만날때까지 그대로 sb에 저장
				while (str.charAt(i) != '>') {
					sb.append(str.charAt(i));
					i++;
				}
				// 닫는 괄호 넣기
				sb.append(str.charAt(i));
			}
			// 문자열
			else {
				// 띄어쓰기나 태그나 종료때까지 stack에 값 push
				while (str.charAt(i) != ' ' && str.charAt(i) != '<' && i != str.length()-1) {
					stack.push(str.charAt(i));
					i++;
				}
				// 만일 문자열이 끝났다면 마지막 문자열도 stack에 push
				if (i == str.length() - 1) stack.push(str.charAt(i));
				// 넣는 순서의 반대로 sb에 저장
				while (!stack.isEmpty()) sb.append(stack.pop());
				// 띄어쓰기를 만났다면 공백 저장
				if (str.charAt(i) == ' ') sb.append(' ');
				// 태그를 만났다면 위치 한칸 앞으로
				else if (str.charAt(i) == '<') i--;
			}
		}
		// 출력
		System.out.println(sb);
	}
}

/*
입력
baekjoon online judge
<ab cd>ef gh<ij kl>
<   space   >space space space<    spa   c e>

출력
noojkeab enilno egduj
<ab cd>fe hg<ij kl>
<   space   >ecaps ecaps ecaps<    spa   c e>
*/
