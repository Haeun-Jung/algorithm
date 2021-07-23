import java.util.Scanner;

public class Solution {
 	public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
        String msg = sc.next();	// 문자열 입력 받기
        
        // 문자열을 숫자로 변환시켜 아스키코드 값을 빼고 ' '과 함께 출력
        for (int i = 0; i < msg.length(); i++) {
            System.out.print(((int) msg.charAt(i) - 64) + " ");
        }
    }
}

/*
입력
ABCDEFGHIJKLMNOPQRSTUVWXYZ

출력
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26
*/