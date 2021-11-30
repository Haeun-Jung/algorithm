/**
 * 두 문자열 A와 B가 주어진다. 이때, A의 길이는 B의 길이보다 작거나 같다. 이제 A의 길이가 B의 길이와 같아질 때 까지 다음과 같은 연산을 할 수 있다.
 *
 * A의 앞에 아무 알파벳이나 추가한다.
 * A의 뒤에 아무 알파벳이나 추가한다.
 * 이때, A와 B의 길이가 같으면서, A와 B의 차이를 최소로 하는 프로그램을 작성하시오.
 */
import java.util.Scanner;

public class BOJ_1120_문자열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 두 문자열
        String A = sc.next();
        String B = sc.next();
        // A 길이
        int Alen = A.length();
        
        for (int i = 0; i <= B.length() - A.length(); i++) {
            int cnt = 0;
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt(i + j))
                    cnt++;
            }
            // 최솟값 갱신
            Alen = cnt < Alen ? cnt : Alen;
        }
        // 출력
        System.out.println(Alen);
        sc.close();
	}
}

/*
입력
adaabc aababbc

출력
2
*/
