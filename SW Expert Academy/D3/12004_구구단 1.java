import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();		// 테스트케이스
        
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();		 // 정수
            String flag = "No";			// 곱으로 표현될 수 있는지 판단하기 위한 문자열(기본 No)
            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    if (i * j == N) {		// 만일 곱으로 표현될 수 있다면
                        flag = "Yes";		// flag를 Yes로 저장
                        break;				// 반복문 나오기
                    }
                }
            }
            System.out.printf("#%d %s\n", tc, flag);
        }
    }
}
        
/*
입력
4
10
11
50
81

출력
#1 Yes
#2 No
#3 No
#4 Yes
*/