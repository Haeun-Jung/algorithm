import java.util.Scanner;

public class Solution {
 	public static void main(String[] args) {
     	Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();			 // 테스트 케이스 입력 받기
        
        for (int i = 1; i <= T; i++) {
            int sum = 0;				 // 합계
            int max = 0;				 //최댓값
        	int min = 10000; 		     // 최솟값
            for (int j = 0; j < 10; j++) {
                int N = sc.nextInt();	 // 정수 입력 받기
                sum += N;				 // 합계 구하기
                if( N > max ) max = N;   // 최댓값 구하기
                if( N < min ) min = N;	 // 최솟값 구하기
            }
            // 최댓값과 최솟값을 제외하여 나머지 평균값을 반올림
            System.out.printf("#%d %d\n", i, Math.round((sum-min-max)/8.0));
        }
    }    
}