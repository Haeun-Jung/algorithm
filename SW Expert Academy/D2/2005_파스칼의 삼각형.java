import java.util.Scanner;

public class Solution {
 	public static void main(String[] args) {
     	Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();   // 테스트 케이스
        
        // 테스트 케이스만큼 반복
        for (int i = 1; i <= T; i++) {
            // 크기 입력 받기
        	int N = sc.nextInt();
            // 입력받은 크기만큼 arr 2차원 배열 생성
            int[][] arr = new int[N][N];
            // 생성한 2차원 배열에 값넣기
            for (int j = 0; j < N; j++) {
             	for (int k = 0; k <= j; k++) {
                    // 만일 행과 열이 같거나 열이 0이라면 1로 저장
                 	if (j == k || k == 0) arr[j][k] = 1;
                    // 그 외에는 직전 행에서 두 값을 합하여 저장
                    else arr[j][k] = arr[j-1][k-1] + arr[j-1][k];
                }
            }
            System.out.printf("#%d\n", i);
            // 2차원 배열을 출력
            for (int j = 0; j < N; j++) {
             	for (int k = 0; k <= j; k++) {
                 	System.out.print(arr[j][k] + " ");
                }
                System.out.println();
            }
        }
    }
}