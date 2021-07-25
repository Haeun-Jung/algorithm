import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
 		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();	// 테스트 케이스
        
        for (int i = 1; i <= T; i++) {
         	String msg = sc.next();   // 문자열 입력 받기
            int length = 0;

            // 마디의 최대 길이 10까지 순회
            for (int j = 1; j <= 10; j++) {
                // 반복되는 첫번째 마디
                String msg1 = msg.substring(0, j);
                // 첫번째 마디와 동일한 길이의 다음 마디
                String msg2 = msg.substring(j, j+j);
                // 둘의 문자열이 동일하다면 해당 길이 j를 length 변수에 저장
                if (msg1.equals(msg2)) {
                    length = j;
                    break;  // 반복문 나오기
                }
            }
        	System.out.printf("#%d %d\n", i, length);    
        }
    }
}