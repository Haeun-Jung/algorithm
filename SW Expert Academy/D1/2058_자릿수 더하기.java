import java.util.Scanner;
class Solution {
 	   public static void main(String[] args) {
           Scanner sc = new Scanner(System.in);
           int n = sc.nextInt();    // 자연수 입력 받기
           int sum = 0;             // 합계를 구할 변수

           while (n > 0) {
               sum += n % 10;       // 일의 자릿수를 sum 변수에 더하기
               n /= 10;             // n을 10으로 나누기
           }
           System.out.println(sum);
       }
}

/*
입력
6789

출력
30
*/