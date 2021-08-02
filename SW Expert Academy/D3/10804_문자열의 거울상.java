import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();			// 테스트케이스
        
        for (int tc = 1; tc <= T; tc++) {
            String str = sc.next();		 // 문자열 입력
            String reverseStr = "";		// 거울로 비출 문자열
            String newStr = "";			// 최종 문자열
            for (int i = str.length() - 1; i >= 0; i--) reverseStr += str.charAt(i);	// 기존 문자열의 순서를 반대로 바꾸기
            for (int i = 0; i < str.length(); i++) {										  // 문자열 거울로 비추기
                if (reverseStr.charAt(i) == 'p') newStr += 'q';
                else if (reverseStr.charAt(i) == 'q') newStr += 'p';
                else if (reverseStr.charAt(i) == 'd') newStr += 'b';
                else if (reverseStr.charAt(i) == 'b') newStr += 'd';
            }
            System.out.printf("#%d %s\n", tc, newStr);
        }
    }
}

/*
입력
2
bdppq
qqqqpppbbd

출력
#1 pqqbd
#2 bddqqqpppp
*/