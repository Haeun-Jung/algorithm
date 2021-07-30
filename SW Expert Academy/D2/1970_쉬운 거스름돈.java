import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();		// 테스트케이스
        
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();	// 거스름돈
            int[] arr = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };	// 돈 종류를 배열로 저장
            System.out.printf("#%d\n", tc);
            for (int i : arr) {
                System.out.printf("%d ", N/i);	// 거스름돈 N이 해당 돈으로 나누어지는만큼 출력
                N %= i;								// 거스름돈 N 변수에 해당 돈으로 나눈 나머지를 저장
            }
            System.out.println();
        }
    }
}

/*
입력
2 
32850
160     

출력
#1
0 3 0 2 1 3 1 0
#2
0 0 0 0 0 1 1 1
*/