import java.util.Scanner;

public class Solution {
	private static int[] kyu, in, temp;
	private static int win, lose;
	private static boolean[] checked; 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();					// 테스트 케이스 개수
		
		for (int tc = 1; tc <= T; tc++) {
			kyu = new int[9];						// 규영의 카드
			in = new int[9];						// 인영의 카드
			temp = new int[9];
			checked = new boolean[9];
			boolean[] all = new boolean[19];
			
			// 이기고 지는 경우의 수 초기화
			win = 0;
			lose = 0;
			
			// 규영
			for (int i = 0; i < 9; i++) {
				kyu[i] = sc.nextInt();
				all[kyu[i]] = true;
			}
			
			// 인영
			int index = 0;
			for (int i = 1; i < 19; i++) {
				if (!all[i]) {
					in[index++] = i;
				}
			}
			match(0);
			// 출력
			System.out.printf("#%d %d %d\n", tc, win, lose);
		}
		sc.close();
	}
	
	private static void match(int cnt) {
		// 9개를 다 뽑았다면
		if (cnt == 9) {
			// 점수 초기화
			int kScore = 0;
			int iScore = 0;
			// 서로의 카드를 비교하며 점수 산정
			for (int i = 0; i < 9; i++) {
				if (kyu[i] < temp[i]) iScore += kyu[i] + temp[i];
				else if (kyu[i] > temp[i]) kScore += kyu[i] + temp[i];
			}
			if (kScore < iScore) lose++;
			else if (kScore > iScore) win++;
			return;
		}
		
		// 9개의 카드를 탐색하면서 재귀
		for (int i = 0; i < 9; i++) {
			if (checked[i]) continue;
			temp[cnt] = in[i];
			checked[i] = true;
			match(cnt+1);
			checked[i] = false;
		}
	}
}

/*
입력
4
1 3 5 7 9 11 13 15 17
18 16 14 12 10 8 6 4 2
13 17 9 5 18 7 11 1 15
1 6 7 9 12 13 15 17 18

출력
#1 112097 250783
#2 250783 112097
#3 336560 26320
#4 346656 16224
*/