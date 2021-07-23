import java.util.Scanner;

public class Solution {
 	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();			// 정수 N 입력 받기
        
        // 정수 N의 약수 구하기
        for (int i = 1; i <= N; i++) {
         	if (N % i == 0) System.out.print(i + " ");
        }
    }
}

/*

입력
10

출력
1 2 5 10

*/