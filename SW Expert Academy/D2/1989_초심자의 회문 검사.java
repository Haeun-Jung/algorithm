import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();   // 테스트 케이스
        
        // 테스트 케이스만큼 순회
        for (int i = 1; i <= T; i++) {
            // 단어 입력 받기
            String msg = sc.next();
            // 입력 받은 단어를 거꾸로 하였을 때 기존 단어와 같을 시 1, 다를 시 0
            int num = msg.equals(new StringBuilder(msg).reverse().toString()) ? 1 : 0;
            System.out.printf("#%d %d\n", i, num);
        }
    }
}