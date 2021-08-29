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
