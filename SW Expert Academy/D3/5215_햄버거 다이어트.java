import java.util.Scanner;
 
public class Solution {
    private static int N, L, max;
    private static int[] score, cal;
    private static boolean[] checked;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();                   // 테스트케이스 개수
         
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();                   // 재료의 수
            L = sc.nextInt();                   // 제한 칼로리
            max = Integer.MIN_VALUE;
            score = new int[N];                 // 점수
            cal = new int[N];                   // 칼로리
            checked = new boolean[N];
             
            for (int i = 0; i < N; i++) {
                score[i] = sc.nextInt();
                cal[i] = sc.nextInt();
            }
            solve(0);
            System.out.printf("#%d %d\n", tc, max);
        }
        sc.close();
    }   
     
    // 부분집합의 합
    private static void solve(int cnt) {
        if (cnt == N) {
            int sumS = 0;
            int sumC = 0;
            for (int i = 0; i < N; i++) {
                if (checked[i]) {
                    sumS += score[i];
                    sumC += cal[i];
                }
            }
            if (sumC <= L && sumS > max) max = sumS;
            return;
        }
        checked[cnt] = true;
        solve(cnt+1);
        checked[cnt] = false;
        solve(cnt+1);
    }
}

/*
입력
1
5 1000
100 200
300 500
250 300
500 1000
400 400


출력
#1 750
*/
