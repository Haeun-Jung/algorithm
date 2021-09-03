import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			HashSet<Character> circle = new HashSet<>();
			circle.add('A');
			circle.add('D');
			circle.add('O');
			circle.add('P');
			circle.add('Q');
			circle.add('R');
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String s1 = st.nextToken();
			String s2 = st.nextToken();
			String result = "SAME";
			
			if (s1.length() != s2.length()) {
				result = "DIFF";
			} else {
				for (int i = 0; i < s1.length(); i++) {
					if (s1.charAt(i) == 'B' && s2.charAt(i) == 'B') continue;
					else if (circle.contains(s1.charAt(i)) && circle.contains(s2.charAt(i))) continue;
					else if (s1.charAt(i) != 'B' && s2.charAt(i) != 'B' && !circle.contains(s1.charAt(i)) && !circle.contains(s2.charAt(i))) continue;
					else {
						result = "DIFF";
						break;
					}
				}
			}
			// 출력
			System.out.printf("#%d %s\n", tc, result);
		}
	}
}

/*
입력
5
ABCD EFGH
ABCD PBZO
PRQO OQAD
ZXCV HJKL
BBBB BBB

출력
#1 DIFF
#2 SAME
#3 SAME
#4 SAME
#5 DIFF
*/
