import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();		// 테스트케이스
        
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();   	// 정수의 갯수
            int sum = 0;			    // 합계
            int cnt = 0;				// 평균이하의 소득을 가진 사람들의 수
            int[] arr = new int[N];	    // 정수를 담을 배열
            for (int i = 0; i < N; i++) {
                int num = sc.nextInt();
                sum += num;
                arr[i] = num;
            }
            int avg = sum / N;		// 합계 변수를 이용하여 평균 구하기
            for (int i = 0; i < N; i++) {
                if (arr[i] <= avg) cnt++;	// 만일 평균값보다 적은 소득을 가지고 있다면 cnt+1
            }
            System.out.printf("#%d %d\n", tc, cnt);
        }
    }
}

/*
입력
3
7
15 15 15 15 15 15 15
10
1 1 1 1 1 1 1 1 1 100
7
2 7 1 8 2 8 4

출력
#1 7
#2 9
#3 4
*/