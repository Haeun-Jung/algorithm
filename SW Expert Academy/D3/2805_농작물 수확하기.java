import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();               // 테스트케이스
         
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();           // 농장의 크기
            if (N % 2 == 0) break;          // 농장의 크기가 짝수일시 종료
            int[][] farm = new int[N][N];
             
            // 농작물의 가치
            for (int i = 0; i < N; i++) {
                char[] num = sc.next().toCharArray();
                for (int j = 0; j < N; j++) {
                    farm[i][j] = num[j] - '0';
                }
            }
             
            int sum = 0;                    // 수익
            int left = N / 2 - 1;
            int right = N / 2 + 1;
             
            // 규칙에 따라 수익 얻기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 중앙보다 위
                    if (i < N / 2) {
                        if (left < j && right > j) {
                            sum += farm[i][j];
                        }
                    }
                    // 중앙
                    else if (i == N / 2) sum += farm[i][j];
                    // 중앙보다 아래
                    else {
                        if (left < j && right > j) {
                            sum += farm[i][j];
                        }
                    }
                }
                if (i < N / 2) {
                    left--;
                    right++;
                } else {
                    left++;
                    right--;
                }
            }
            // 출력
            System.out.printf("#%d %d\n", tc, sum);
        }
    }
}

/*
입력
1
5
14054
44250
02032
51204
52212

출력
#1 23
*/