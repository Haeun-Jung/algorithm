import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();						// 테스트케이스
        
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();					// N개의 과자
            int K = sc.nextInt();					// K명의 사람
            int diff = N % K == 0 ? 0 : 1;		// 만일 나누어떨어진다면 차이는 0, 아니라면 1
            System.out.printf("#%d %d\n", tc, diff);
        }
    }
}

/*
입력
3
1 1
7 3
100 10  

출력
#1 0
#2 1
#3 0      
*/
