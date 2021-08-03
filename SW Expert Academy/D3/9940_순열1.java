import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();				// 테스트케이스
        
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();			// 정수의 개수
            int[] arr = new int[N+1];
            String flag = "Yes";			// 순열을 판단하기 위한 문자열
            for (int i = 1; i < N+1; i++) {
                int num = sc.nextInt();
                arr[num]++;
                if (arr[num] > 1) flag = "No";	// 순열이 아니라면 flag를 "No"로 저장
            }
            System.out.printf("#%d %s\n", tc, flag);
        }
    }
}

/*
입력
2
4
3 4 1 2
5
2 3 4 4 5

출력
#1 Yes
#2 No
*/