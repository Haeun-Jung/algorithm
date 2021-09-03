/*
접두사X 집합이란 집합의 어떤 한 단어가, 다른 단어의 접두어가 되지 않는 집합이다.
예를 들어, {hello}, {hello, goodbye, giant, hi}, 비어있는 집합은 모두 접두사X 집합이다.
하지만, {hello, hell}, {giant, gig, g}는 접두사X 집합이 아니다.

단어 N개로 이루어진 집합이 주어질 때, 접두사X 집합인 부분집합의 최대 크기를 출력하시오.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 단어의 개수
		String[] arr = new String[N];
		int cnt = N;
		
		// 배열 입력받기
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		// 오름차순으로 정렬
		Arrays.sort(arr);
		for (int i = 0; i < N-1; i++) {
			boolean flag = true;
			for (int j = i+1; j < N; j++) {
				// 만일 접두사X 집합이 아니라면 제외시킴
				if (arr[j].startsWith(arr[i])) flag = false;
			}
			if (!flag) cnt--;
		}
		// 출력
		System.out.println(cnt);
	}
}

/*
입력
6
hello
hi
h
run
rerun
running

출력
4
*/
