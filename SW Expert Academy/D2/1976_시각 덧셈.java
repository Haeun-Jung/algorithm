import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();	// 테스트케이스
        
        for (int tc = 1; tc <= T; tc++) {
            int first_hour = sc.nextInt();		// 첫번째 시간
            int first_min = sc.nextInt();		// 첫번째 분 
            int second_hour = sc.nextInt();	// 두번째 시간
            int second_min = sc.nextInt();	 // 두번째 분
            int total_hour = first_hour + second_hour;	// 총 시간
            int total_min = first_min + second_min;		// 총 분
            if (total_min > 60) {								// 만일 총 분이 60분을 넘긴다면 시간 +1, 분 - 60
                total_min -= 60;
                total_hour++;
            }
            if (total_hour > 12) total_hour -= 12;		// 만일 총 시간이 12를 넘어간다면 -12
            System.out.printf("#%d %d %d\n", tc, total_hour, total_min);
        }
    }
}

/*
입력
3 
3 17 1 39
8 22 5 10
6 53 2 12   

출력
#1 4 56
#2 1 32
#3 9 5
*/