import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();				// 테스트케이스
        
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();			// 문자열의 길이
            String str1 = sc.next();		// 따라 적어야 하는 문자열
            String str2 = sc.next();		// 따라 적은 문자
            int cnt = 0;						// 맞은 개수
            for (int i = 0; i < N; i++) {
                if (str1.charAt(i) == str2.charAt(i)) cnt++;
            }
            System.out.printf("#%d %d\n", tc, cnt);
        }
    }
}

/*
입력
2
16
MyNameIsSeokChan
mynameisseokchan
15
SamsungSoftware
MembershipZzang

출력
#1 11
#2 2
*/