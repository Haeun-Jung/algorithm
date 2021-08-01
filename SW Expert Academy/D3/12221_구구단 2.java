import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();			// 테스트케이스
        
        for (int tc = 1; tc <= T; tc++) {
            int A = sc.nextInt();					// 첫번째 수
            int B = sc.nextInt();					// 두번째 수
            int result = 0;							// 결과값
            if (A > 9 || B > 9) result = -1;	// 만일 10이상의 자연수라면 result변수에 -1 저장
            else result = A * B;				// 만일 곱셈을 할 수 있다면 A*B 값을 result변수에 저장
            System.out.printf("#%d %d\n", tc, result);
        }
    }
}

/*
입력
4
2 5
5 10
10 10
9 9

출력
#1 10
#2 -1
#3 -1
#4 81
*/