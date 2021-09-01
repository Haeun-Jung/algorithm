/*
인기 티비 프로그램 "나는 요리사 인가?"의 새 시즌이 시작한다.
이번 시즌은 기네스북에 등재될 만한 음식을 만드는 것을 목표로 진행한다.
첫 번째 에피소드에 출연하는 요리사는 전설의 요리사 김상근이고, 길이 L미터의 롤 케이크를 만들 것이다.
상근은 몇 시간동안 집중해서 케이크를 만들었고, 이제 스튜디오의 방청객 N명에게 케이크를 나누어 주려고 한다.
상근이는 롤 케이크를 펼쳐서 1미터 단위로 잘라 놓았다.
가장 왼쪽 조각이 1번, 오른쪽 조각이 L번 조각이다.
방청객은 1번부터 N번까지 번호가 매겨져 있다.
각 방청객은 종이에 자신이 원하는 조각을 적어서 낸다.
이때, 두 수 P와 K를 적어서 내며, P번 조각부터 K번 조각을 원한다는 뜻이다.
프로그램의 진행자 고창영은 1번 방청객의 종이부터 순서대로 펼쳐서 해당하는 조각에 그 사람의 번호를 적을 것이다.
이때, 이미 번호가 적혀있는 조각은 번호를 적지 못하고 넘어간다.
이런 방식을 이용해서 방청객에게 조각을 주다보니, 자신이 원래 원했던 조각을 받지 못하는 경우가 생길 수 있다.

가장 많은 케이크 조각을 받을 것으로 기대한 방청객의 번호와 실제로 가장 많은 케이크 조각을 받는 방청객의 번호를 구하는 프로그램을 작성하시오.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3985_롤케이크 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());		// 롤케이크의 길이
		int N = Integer.parseInt(br.readLine());		// 방청객의 수
		int[] cake = new int[L+1];
		int expect = Integer.MIN_VALUE;					// 가장 많은 조각을 받을것으로 기대
		int fact = Integer.MIN_VALUE;					// 실제로 가장 많은 조각을 받음
		int num = 1;									// 방청객 번호
		int size = 0;
		
		// 롤케이크 나누기
		for (int i = 0; i < N; i++, num++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());	// 시작번호
			int end = Integer.parseInt(st.nextToken());		// 끝번호
			// 번호 부여
			for (int k = start; k <= end; k++) {
				if (cake[k] != 0) continue;
				cake[k] = num;
			}
			// 가장 많은 조각을 받을것으로 기대하는 방청객 번호 구하기
			if (size < end-start+1) {
				expect = num;
				size = end-start+1;
			}
		}
		
		// 방청객별로 조각 계산
		int[] cnt = new int[N+1];
		for (int i = 1; i < L+1; i++) {
			cnt[cake[i]]++;
		}
		// 가장 많은 조각을 받은 방청객의 번호
		size = 0;
		for (int i = 1; i < N+1; i++) {
			if (size < cnt[i]) {
				fact = i;
				size = cnt[i];
			}
		}
		// 출력
		System.out.println(expect);
		System.out.println(fact);
	}
}

/*
입력
10
3
2 4
7 8
6 9

출력
3
1
*/
