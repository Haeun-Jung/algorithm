import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        for (int tc = 1; tc <= 10; tc++) {
            int N = sc.nextInt();                   // 정점의 총 수
            int answer = 1;
            String left = "";                       // 왼쪽 자식
            String right = "";                      // 오른쪽 자식
             
            for (int i = 0; i < N; i++) {
                String num = sc.next();             // 정점 번호
                String cal = sc.next();             // 연산 or 자식
                // 만일 자식노드가 더 존재한다면
                if (!right.equals(String.valueOf(N)) && !left.equals(String.valueOf(N))) {
                    // 만일 cal이 연산이 아니라면 연산 불가능
                    if (!cal.equals("+") && !cal.equals("-") && !cal.equals("*") && !cal.equals("/")) {
                        answer = 0;
                    }
                    // 자식노드 입력 받기
                    left = sc.next();
                    if (!left.equals(String.valueOf(N))) right = sc.next();
                }
                // 자식노드가 더이상 없다면
                else {
                    // 만일 cal이 연산이라면 연산 불가능
                    if (cal.equals("+") || cal.equals("-") || cal.equals("*") || cal.equals("/")) {
                        answer = 0;
                    }
                }
            }
            // 출력
            // 총 노드가 짝수개라면 연산이 불가능
            if (N % 2 == 0 || answer == 0) {
                answer = 0;
                System.out.printf("#%d %d\n", tc, answer);
            }
            else {
                System.out.printf("#%d %d\n", tc, answer);
            }
        }
        sc.close();
    }
}