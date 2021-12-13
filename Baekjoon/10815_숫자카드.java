/**
 * 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815_숫자카드 {
	
	public static int[] card, check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 숫자 카드 N개
		card = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) card[i] = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());	// 정수 M개
		check = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) check[i] = Integer.parseInt(st.nextToken());
		
		// 오름차순 정렬
		Arrays.sort(card);
		// 상근이가 해당 숫자 카드를 가지고 있는지 아닌지 구하기
		for (int i : check) {
			// 출력
			if (BinarySearch(i)) System.out.print(1 + " ");
			else System.out.print(0 + " ");
		}
	}
	
	// 이분탐색
	public static boolean BinarySearch (int num) {
		int left = 0;
		int right = card.length - 1;
		
		while (left <= right) {
			// 중간 index
			int mid = (left + right) / 2;
			// 상근이 카드값보다 비교하려는 카드가 더 크다면 최솟값 증가
			if (card[mid] < num) left = mid + 1;
			// 상근이 카드값보다 비교하려는 카드가 더 작다면 최댓값 감소
			else if (card[mid] > num) right = mid - 1;
			// 상근이가 해당 숫자를 가지고 있다.
			else return true;
		}
		// 상근이가 해당 숫자를 가지고 있지 않다.
		return false;
	}
}

/*
입력
5
6 3 2 10 -10
8
10 9 -5 2 3 4 5 -10

출력
1 0 0 1 1 0 0 1
*/
