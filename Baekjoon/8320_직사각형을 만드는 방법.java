/*
상근이는 변의 길이가 1인 정사각형 n개를 가지고 있다.
이 정사각형을 이용해서 만들 수 있는 직사각형의 개수는 총 몇 개일까?

두 직사각형 A와 B가 있을 때, A를 이동, 회전시켜서 B를 만들 수 없으면, 두 직사각형은 다르다고 한다.
직사각형을 만들 때, 정사각형을 변형시키거나, 한 정사각형 위에 다른 정사각형을 놓을 수 없다.
또, 직사각형은 정사각형으로 꽉 차있어야 한다.
 */

import java.util.Scanner;

public class BOJ_8320_직사각형을만드는방법 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();			// 정사각형 n개
		int total = 0;
		
		for (int i = 1; i <= n; i++) {
			// 약수구하기
			int cnt = 0;
			for (int num = 1; num <= i; num++) {
				if (i % num == 0) cnt++;
			}
			total += cnt/2;
			// 홀수면 한개 더 추가
			if (cnt % 2 != 0) total++;
		}
		// 출력
		System.out.println(total);
		sc.close();
	}
}

/*
입력
6

출력
8
*/
