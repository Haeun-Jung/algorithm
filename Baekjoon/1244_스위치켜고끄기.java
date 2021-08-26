/*
1부터 연속적으로 번호가 붙어있는 스위치들이 있다. 스위치는 켜져 있거나 꺼져있는 상태이다.
‘1’은 스위치가 켜져 있음을, ‘0’은 꺼져 있음을 나타낸다.
학생 몇 명을 뽑아서, 학생들에게 1 이상이고 스위치 개수 이하인 자연수를 하나씩 나누어주었다.
학생들은 자신의 성별과 받은 수에 따라 아래와 같은 방식으로 스위치를 조작하게 된다.

남학생은 스위치 번호가 자기가 받은 수의 배수이면, 그 스위치의 상태를 바꾼다.
즉, 스위치가 켜져 있으면 끄고, 꺼져 있으면 켠다.

여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서, 그 구간에 속한 스위치의 상태를 모두 바꾼다.
이때 구간에 속한 스위치 개수는 항상 홀수가 된다.

입력으로 스위치들의 처음 상태가 주어지고, 각 학생의 성별과 받은 수가 주어진다.
학생들은 입력되는 순서대로 자기의 성별과 받은 수에 따라 스위치의 상태를 바꾸었을 때, 스위치들의 마지막 상태를 출력하는 프로그램을 작성하시오.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244_스위치켜고끄기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());			// 스위치 개수
		int[] button = new int[N+1];
		
		// 스위치의 상태
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			button[i] = Integer.parseInt(st.nextToken());
		}
		
		int student = Integer.parseInt(br.readLine());		// 학생 수
		for (int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int who = Integer.parseInt(st.nextToken());		// 성별
			
			// 남자일 때
			if (who == 1) {
				int num = Integer.parseInt(st.nextToken());	// 받은 수
				// 받은 수의 배수 번호들의 상태 변경
				for (int k = num; k <= N; k += num) {
					button[k] = button[k] == 0 ? 1 : 0;
				}
			}
			
			// 여자일 때
			else {
				int num = Integer.parseInt(st.nextToken());	// 받은 수
				int cnt = 1;
				// 받은 위치 상태 변경
				button[num] = button[num] == 0 ? 1 : 0;
				while (num-cnt > 0 && num+cnt <= N) {
					// 왼쪽 오른쪽의 상태가 같다면 상태 변경
					if (button[num-cnt] == button[num+cnt]) {
						button[num-cnt] = button[num-cnt] == 0 ? 1 : 0;
						button[num+cnt] = button[num+cnt] == 0 ? 1 : 0;
					} else break;
					cnt++;
				}
			}
		}
		// 출력
		for (int i = 1; i <= N; i++) {
			System.out.print(button[i] + " ");
			if (i % 20 == 0) System.out.println();
		}
	}
}

/*
입력
8
0 1 0 1 0 0 0 1
2
1 3
2 3

출력
1 0 0 0 1 1 0 1
*/
