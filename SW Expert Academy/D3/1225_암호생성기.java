import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
         
        for (int tc = 1; tc <= 10; tc++) {
            // 테스트케이스 번호
            int T = sc.nextInt();   
                             
            // 큐 채우기
            for (int i = 0; i < 8; i++) {
                queue.offer(sc.nextInt());
            }
             
            // 큐에 0이 나올 시, 프로그램 종료
            while (!queue.contains(0)) {
                // 사이클
                for (int i = 1; i <= 5; i++) {
                    int n = queue.poll();
                    // 숫자가 감소할때, 0이하일경우 프로그램 종료
                    if (n-i <= 0) {
                        queue.offer(0);
                        break;
                    }
                    // 첫번째 수에서 사이클만큼 감소시켜 뒤로 이동
                    else {
                        queue.offer(n-i);
                    }
                }
            }
            // 출력
            System.out.printf("#%d ", T);
            for (int i = 0; i < 8; i++) {
                System.out.print(queue.poll() + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}

/* 
테스트케이스가 2개일 때

입력
1
9550 9556 9550 9553 9558 9551 9551 9551
2
2419 2418 2423 2415 2422 2419 2420 2415

출력
#1 6 2 2 9 4 1 3 0
#2 9 7 9 5 4 3 8 0
*/