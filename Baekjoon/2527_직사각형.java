/**
 * 직사각형은 아래와 같이 왼쪽 아래 꼭짓점 좌표 (x, y)와 오른쪽 위 꼭짓점 좌표 (p, q)로 주어진다.
 * 이 문제에서 모든 직사각형은 두 꼭짓점의 좌표를 나타내는 4개의 정수 x y p q 로 표현된다. 단 항상 x<p, y<q 이다.
 *
 * 두 직사각형의 겹치는 부분이 직사각형인지, 선분인지, 점인지, 아니면 전혀 없는 지를 판별해서 해당되는 코드 문자를 출력해야 한다. 
 * 직사각형 : a
 * 선분 : b
 * 점 : c
 * 공통부분이 없음 : d
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2527_직사각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int startX1 = Integer.parseInt(st.nextToken());
			int startY1 = Integer.parseInt(st.nextToken());
			int endX1 = Integer.parseInt(st.nextToken());
			int endY1 = Integer.parseInt(st.nextToken());
			int startX2 = Integer.parseInt(st.nextToken());
			int startY2 = Integer.parseInt(st.nextToken());
			int endX2 = Integer.parseInt(st.nextToken());
			int endY2 = Integer.parseInt(st.nextToken());
			
			// 공통부분이 없음
			if (endX1 < startX2 || endY1 < startY2 || startX1 > endX2 || startY1 > endY2) System.out.println("d");
			// 점
			else if ((startX1 == endX2 && startY1 == endY2) || (endX1 == startX2 && endY1 == startY2) ||
					(startX1 == endX2 && endY1 == startY2) || (endX1 == startX2 && startY1 == endY2)) System.out.println("c");
			// 선분
			else if (startX1 == endX2 || startY1 == endY2 || endX1 == startX2 || endY1 == startY2) System.out.println("b");
			// 직사각형
			else System.out.println("a");
		}
	}
}

/*
입력
3 10 50 60 100 100 200 300
45 50 600 600 400 450 500 543
11 120 120 230 50 40 60 440
35 56 67 90 67 80 500 600

출력
d
a
a
b
*/
