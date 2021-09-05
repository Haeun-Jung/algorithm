import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		// 테스트케이스 개수
		
		for (int tc = 1; tc <= T; tc++) {
			// 제일 긴 문자열의 길이 구하기
			String[] str = new String[5];
			int len = 0;
			for (int i = 0; i < 5; i++) {
				str[i] = br.readLine();
				if (str[i].length() > len) len = str[i].length();
			}
			
			// 문자열 저장
			char[][] word = new char[5][len];
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < len; j++) {
					if (j >= str[i].length()) word[i][j] = '^';
					else word[i][j] = str[i].charAt(j);
				}
			}
			
			// 세로로 읽기
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < len; j++) {
				for (int i = 0; i < 5; i++) {
					if (word[i][j] == '^') continue;
					sb.append(word[i][j]);
				}
			}
			
			// 출력
			System.out.printf("#%d %s\n", tc, sb);
		}
	}
}

/*
입력
2
ABCDE
abcde
01234
FGHIJ
fghij
AABCDD
afzz
09121
a8EWg6
P5h3kx

출력
#1 Aa0FfBb1GgCc2HhDd3IiEe4Jj
#2 Aa0aPAf985Bz1EhCz2W3D1gkD6x
*/
