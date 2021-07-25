import java.util.*;

public class Solution{
    public static void main(String args[]) {
 		Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();	 // 점수의 갯수
        int[] arr = new int[count];	 // 갯수만큼 크기를 가진 배열 만들기
        
        // 입력값으로 배열 채우기
        for (int i = 0; i < count; i++) {
            arr[i] = sc.nextInt();	
        }
        Arrays.sort(arr);	                    // arr배열 정렬
        System.out.print(arr[(int) count/2]);	// 가운데 값 찾기
    }
}