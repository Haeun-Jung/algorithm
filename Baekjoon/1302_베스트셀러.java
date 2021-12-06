/**
 * 오늘 하루 동안 팔린 책의 제목이 입력으로 들어왔을 때, 가장 많이 팔린 책의 제목을 출력하는 프로그램을 작성하시오.
 * 만약 가장 많이 팔린 책이 여러 개일 경우에는 사전 순으로 가장 앞서는 제목을 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class BOJ_1302_베스트셀러 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> hash = new HashMap<>();
		int N = Integer.parseInt(br.readLine());	// 오늘 하루동안 팔린 책의 개수
		int max = 0;
		String[] books = new String[N];
		String answer = "";							// 가장 많이 팔린 책의 제목
		
		// 책 입력 받기
		for (int i = 0; i < N; i++) {
			books[i] = br.readLine();
		}
		
		// 사전순 정렬
		Arrays.sort(books);
		
		for (int i = 0; i < N; i++) {
			String book = books[i];
			// 책 중복 O
			if (hash.containsKey(book)) hash.put(book, hash.get(book) + 1);
			// 책 중복 X
			else hash.put(book, 1);
			
			// 가장 많이 팔린 책 갱신
			if (hash.get(book) > max) {
				max = hash.get(book);
				answer = book;
			}
		}
		
		// 출력
		System.out.println(answer);
	}
}

/*
입력
5
top
top
top
top
kimtop

출력
top
*/
