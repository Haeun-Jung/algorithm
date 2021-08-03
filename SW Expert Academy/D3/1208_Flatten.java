import java.util.Scanner;
import java.util.Arrays;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        for (int tc = 1; tc <= 10; tc++) {
            int cnt = sc.nextInt();             // 덤프 횟수
            int[] arr = new int[100];           // 상자를 담을 배열
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();          
            }
            while (cnt-- > 0) {  
                Arrays.sort(arr);               // 오름차순으로 정렬
                arr[99]--;                      // 최댓값은 -1
                arr[0]++;                       // 최솟값은 +1
            }
            Arrays.sort(arr);
            System.out.printf("#%d %d\n", tc, arr[99] - arr[0]);
        }
    }
}

/*
테스트케이스 1개, 가로길이 10이라고 가정

입력
5
42 68 35 1 70 25 79 59 63 65

출력
#1 68
*/