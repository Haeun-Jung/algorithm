import java.util.Scanner;
public class Solution {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) {
        int T = sc.nextInt();    // 테스트케이스
        
        for (int tc = 1; tc <= T; tc++) {
            // 최댓값을 구할 변수
            int max = 0;
            
            // 10개의 정수 입력 받기
            for (int i = 0; i < 10; i++) {
                int num = sc.nextInt();
                // 만일 입력 받은 숫자 num이 max보다 크다면 max변수에 num 저장
                if (num > max) max = num;
            }
            System.out.printf("#%d %d\n", tc, max);
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
#1 99
#2 123
#3 76
*/