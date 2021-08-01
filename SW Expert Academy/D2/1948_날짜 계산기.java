import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();		// 테스트케이스
        int[] date = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};	// 달별로 날짜를 담은 배열
        
        for (int tc = 1; tc <= T; tc++) {
            int first_month = sc.nextInt();			// 첫번째 달
            int first_date = sc.nextInt();			  // 첫번째 날짜
            int second_month = sc.nextInt();	// 두번째 달
            int second_date = sc.nextInt();	      // 두번째 날짜
            int diff = 0;								// 두날짜의 차이
            
            // 만일 같은 달이라면 날짜만 계산
            if (first_month == second_month) diff = second_date - first_date;
            // 만일 다른 달이라면
            else {
                // 사이에 존재하는 날짜 더하기
                for (int i = first_month + 1; i < second_month; i++) {
                    diff += date[i];
                }
                // 첫번째 달의 남은 날짜 더하기
                diff += date[first_month] - first_date;
                // 두번째 날의 진행날짜 더하기
                diff += second_date;
            }
            System.out.printf("#%d %d\n", tc, diff + 1);
        }
    }
}

/*
입력
3 
3 1 3 31
5 5 8 15
7 17 12 24 

출력
#1 31
#2 103
#3 161
*/