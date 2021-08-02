import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();       //테스트케이스
         
        for (int tc = 1; tc <= T; tc++) {
            char[] bit = sc.next().toCharArray();   // 입력받은 데이터를 Char 배열로 저장
            char ch = '0';                              // 초기값
            int cnt = 0;                                // 수정 횟수
            for (int i = 0; i < bit.length; i++) {
                // 만일 값이 동일하지 않을 때 수정+1
                if (ch != bit[i]) {
                    ch = bit[i];
                    cnt++;
                }
            }
            System.out.printf("#%d %d\n", tc, cnt);
        }
    }
}

/*
입력
2
0011
100

출력
#1 1
#2 2
*/