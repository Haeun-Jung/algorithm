public class Solution {
 	public static void main(String[] args) {
     	Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();	// 테스트 케이스
        
        for (int i = 1; i <= T; i++) {
         	int N = sc.nextInt();	// 정수 입력 받기
            int result = 0;			// 누적된 값을 담을 변수

            // 1부터 N까지의 숫자에서
            // 홀수는 더하고 짝수는 빼기 
            for (int j = 1; j <= N; j++) {
                if (j % 2 == 0) result -= j;
                else result += j;
            }
            System.out.printf("#%d %d\n", i, result);
        }
    }   
}