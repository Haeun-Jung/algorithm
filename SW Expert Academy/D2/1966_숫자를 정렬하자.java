import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();		//테스트케이스
        
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();		// N길이의 숫자열
            int[] arr = new int[N];	   // N길이의 배열 생성
            
            // 입력받은 값으로 arr 배열 채우기
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            // arr 배열을 오름차순으로 정렬
            Arrays.sort(arr);			  
            System.out.printf("#%d ", tc);
            
            for (int i = 0; i < N; i++) {
                System.out.printf("%d ", arr[i]);
            }
            System.out.println();
        }
    }
}

/*
입력
1
5
1 4 7 8 0

출력
#1 0 1 4 7 8
*/