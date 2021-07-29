import java.util.Scanner;

public class Solution {
 public static void main(String args[]) {
     Scanner sc = new Scanner(System.in);
     int T = sc.nextInt();      // 테스트케이스

     for (int tc = 1; tc <= T; tc++) {
         int sum = 0;
         for (int i = 0; i < 10; i++) {
             int num = sc.nextInt();
             if (num % 2 == 1) sum += num;  // 홀수면 sum변수에 해당 값 더하기
         }
         System.out.printf("#%d %d\n", tc, sum);
     }
 }
}