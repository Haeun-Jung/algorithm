/**
 * 문자열 S가 주어졌을 때, S의 서로 다른 부분 문자열의 개수를 구하는 프로그램을 작성하시오.
 * 부분 문자열은 S에서 연속된 일부분을 말하며, 길이가 1보다 크거나 같아야 한다.
 * 예를 들어, ababc의 부분 문자열은 a, b, a, b, c, ab, ba, ab, bc, aba, bab, abc, abab, babc, ababc가 있고, 서로 다른것의 개수는 12개이다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_11478_서로다른부분문자열의개수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> hash = new HashSet<>();	// 중복제거
		
		String S = br.readLine();				// 문자열
		
		for (int i = 0; i < S.length(); i++) {
			String str = "";
			for (int j = i; j < S.length(); j++) {
				str += S.substring(j, j + 1);
				hash.add(str);					// 중복제거
			}
		}
		
		// 갯수 출력
		System.out.println(hash.size());
	}
}

/*
입력
ababc

출력
12
*/
