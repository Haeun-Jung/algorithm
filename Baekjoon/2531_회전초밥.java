/**
 * 원래 회전 초밥은 손님이 마음대로 초밥을  고르고, 먹은 초밥만큼 식대를 계산하지만, 벨트의 임의의 한 위치부터 k개의 접시를 연속해서 먹을 경우 할인된 정액 가격으로 제공한다. 
 * 각 고객에게 초밥의 종류 하나가 쓰인 쿠폰을 발행하고, 1번 행사에 참가할 경우 이 쿠폰에 적혀진 종류의 초밥 하나를 추가로 무료로 제공한다. 만약 이 번호에 적혀진 초밥이 현재 벨트 위에 없을 경우, 요리사가 새로 만들어 손님에게 제공한다.  
 * 
 * 위 할인 행사에 참여하여 가능한 한 다양한 종류의 초밥을 먹으려고 한다. 위 그림의 예를 가지고 생각해보자. k=4이고, 30번 초밥을 쿠폰으로 받았다고 가정하자. 
 * 쿠폰을 고려하지 않으면 4가지 다른 초밥을 먹을 수 있는 경우는 (9, 7, 30, 2), (30, 2, 7, 9), (2, 7, 9, 25) 세 가지 경우가 있는데, 30번 초밥을 추가로 쿠폰으로 먹을 수 있으므로 (2, 7, 9, 25)를 고르면 5가지 종류의 초밥을 먹을 수 있다. 
 * 
 * 회전 초밥 음식점의 벨트 상태, 메뉴에 있는 초밥의 가짓수, 연속해서 먹는 접시의 개수, 쿠폰 번호가 주어졌을 때, 손님이 먹을 수 있는 초밥 가짓수의 최댓값을 구하는 프로그램을 작성하시오. 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	// 접시의 수
		int d = Integer.parseInt(st.nextToken());	// 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken());	// 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken());	// 쿠폰 번호
		
		// 초밥 입력 받기
		int[] dish = new int[N];
		for (int i = 0; i < N; i++) {
			dish[i] = Integer.parseInt(br.readLine());
		}
		
		// 몇번의 초밥을 먹었는지 확인
		int [] check = new int[d+1];
		// 종류별로 몇 개를 먹었는지 확인
        int count = 0;
        
        for (int i = 0; i < k; i++) {
        	// 종류 세기
            if (check[dish[i]] == 0) count++;
            check[dish[i]]++;
        }
        
        int max = count;							// 초밥 가짓수의 최댓값
        int start = 1;
        int end = k;
        
        // 슬라이딩 윈도우
        while (true) {
            if (check[dish[start-1]] == 1) count--;
            check[dish[start-1]]--;
            
            if (check[dish[end]] == 0) count++;
            check[dish[end]]++;
            
            // 최댓값 갱신
            if (check[c] == 0) max = Math.max(max, count+1);
            else max = Math.max(max, count);
            
            start++;
            end++;
            
            if (end == N) end = 0;
            // 끝까지 확인했다면 반복문 탈출
            if (start == N) break;
        }
        // 출력
        System.out.println(max);
	}
}

/* 
입력
8 30 4 30
7
9
7
30
2
7
9
25

출력
5
*/
