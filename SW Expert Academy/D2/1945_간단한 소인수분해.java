import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();	// 테스트 케이스
 		
        for (int tc = 1; tc <= T; tc++) {
         	int N = sc.nextInt();   // 정수 입력 받기
            int a = 0, b = 0, c = 0, d = 0, e = 0;
            // N이 1 될때까지 반복
            while (N != 1) {
                // 만일 N이 11로 나누어 떨어진다면 N을 11로 나누고 e+1
            	if (N % 11 == 0) {
                    N /= 11;
                    e++;
                }
                // 만일 N이 7로 나누어 떨어진다면 N을 7로 나누고 d+1
                else if (N % 7 == 0) {
                    N /= 7;
                    d++;
                }
                // 만일 N이 5로 나누어 떨어진다면 N을 5로 나누고 c+1
                else if (N % 5 == 0) {
                    N /= 5;
                    c++;
                }
                // 만일 N이 3로 나누어 떨어진다면 N을 3로 나누고 b+1
                else if (N % 3 == 0) {
                    N /= 3;
                    b++;
                }
                // 만일 N이 2로 나누어 떨어진다면 N을 2로 나누고 a+1
                else {
                    N /= 2;
                    a++;
                }
            }
            System.out.printf("#%d %d %d %d %d %d\n", tc, a, b, c, d, e);
        }
    }
}

/*
입력
10  
6791400
1646400
1425600
8575
185625
6480
1185408
6561
25
330750

출력
#1 3 2 2 3 1
#2 6 1 2 3 0
#3 6 4 2 0 1
#4 0 0 2 3 0
#5 0 3 4 0 1
#6 4 4 1 0 0
#7 7 3 0 3 0
#8 0 8 0 0 0
#9 0 0 2 0 0
#10 1 3 3 2 0
*/