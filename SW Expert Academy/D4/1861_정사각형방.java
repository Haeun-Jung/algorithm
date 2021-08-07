import java.util.Scanner;
 
public class Solution {
    // 4방 탐색
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int N, cnt;
    public static int[][] room;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();                       // 테스트케이스의 수
         
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();                       // 방의 크기
            room = new int[N][N];
             
            // 방 채우기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    room[i][j] = sc.nextInt();
                }
            }
             
            // 시작할 방을 저장할 start 변수
            int start = Integer.MAX_VALUE;
            // 최댓값을 저장할 max 변수
            int max = Integer.MIN_VALUE;
             
            // 방을 돌면서 최댓값 찾기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 이동횟수 초기화
                    cnt = 1;
                     
                    solve(i, j);
                    // 이동횟수가  max보다 크다면 max에 저장, 시작 방을 start에 저장
                    if (max < cnt) {
                        max = cnt;
                        start = room[i][j];
                    }
                    // 이동횟수와 max값이 같다면 시작 방을 더 작은 값으로 변경
                    else if (max == cnt) {
                        if (start > room[i][j])  start = room[i][j];
                    }
                }
            }
            // 출력
            System.out.printf("#%d %d %d\n", tc, start, max);
        }
        sc.close();
    }
     
    // 이동 횟수를 반환하는 함수
    public static void solve(int x, int y) {
        // 4방 탐색
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            // 범위를 벗어나거나 다음 방이 현재 방에서 +1한 값이 아닐 때 다음 값 탐색
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || room[x][y] + 1 != room[nx][ny]) {
                // 더이상 이동할 방이 없을 때 cnt 반환
                if (d == 3) return;
                continue;
            }
            // 이동이 가능하다면 cnt+1, 다음방에서 계속 이동하기
            cnt++;
            solve(nx, ny);
        }
    }
}

/*
입력
2
2
1 2
3 4
3
9 3 4
6 1 5
7 8 2

출력
#1 1 2
#2 3 3
*/