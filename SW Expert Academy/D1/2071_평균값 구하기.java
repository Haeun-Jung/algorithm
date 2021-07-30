import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();   // 테스트케이스

        for (int tc = 1; tc <= T; tc++) {
         	int sum = 0;
             // 10개의 수를 입력 받아 sum 변수에 더하기
            for (int j = 0; j < 10; j++) {
                sum += sc.nextInt();    
            }
            // 합계 sum을 10으로 나누어 평균내기(소수점 첫째자리에서 반올림)
            System.out.printf("#%d %.0f\n", tc, sum/10.0);
        }
    }
}

/*
입력
3
3 17 1 39 8 41 2 32 99 2
22 8 5 123 7 2 63 7 3 46
6 63 2 3 58 76 21 33 8 1   

출력
#1 24
#2 29
#3 27
*/