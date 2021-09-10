import java.util.Scanner;

public class SW_D3_5515_2016년요일맞추기 {

	public static void main(String[] args) {
		int[] month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();					// 테스트케이스의 수
		
		for (int tc = 1; tc <= T; tc++) {
			int m = sc.nextInt();				// 월
			int d = sc.nextInt();				// 일
			
			// 날짜 계산
			int cnt = 0;
			for (int i = 0; i < m; i++) {
				cnt += month[i];
			}
			cnt += d;
			
			// 금요일부터 시작 +4, 날짜는 1부터 시작 -1
			int resultDay = cnt%7 + (4-1);
			// 일주일 경과
			if (resultDay > 6) resultDay -= 7;
			
			// 출력
			System.out.printf("#%d %d\n", tc, resultDay);
		}
		sc.close();
	}
}

/*
입력
2
1 1
12 31

출력
#1 4
#2 5
*/
