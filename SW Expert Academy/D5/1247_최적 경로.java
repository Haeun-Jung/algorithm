import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    private static int N, min, companyX, companyY, homeX, homeY;
    private static boolean[] checked;
    private static int[][] customer;
    private static int[][] result;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());            // 테스트케이스의 수
         
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());            // N명의 고객 좌표
            min = Integer.MAX_VALUE;                        // 최단 경로
            checked = new boolean[N];
            customer = new int[N][];
            result = new int[N][2];
            int index = 0;
             
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            // 좌표 입력
            for (int i = 0; i < N+2; i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                // 회사 좌표
                if (i == 0) {
                    companyX = x;
                    companyY = y;
                }
                // 집 좌표
                else if (i == 1) {
                    homeX = x;
                    homeY = y;
                }
                // 고객 좌표
                else {
                    customer[index++] = new int[]{x, y};
                }
            }
            perm(0);
            // 출력
            System.out.printf("#%d %d\n", tc, min);
        }
    }
 
    // 순열
    private static void perm(int cnt) {
        // 기저조건
        if (cnt == N) {
            solve();
            return;
        }
         
        // 순서 변경
        for (int i = 0; i < N; i++) {
            if (checked[i]) continue;
            result[cnt][0] = customer[i][0];
            result[cnt][1] = customer[i][1];
            checked[i] = true;
            perm(cnt+1);
            checked[i] = false;
        }
    }
     
    // 경로 구하기
    private static void solve() {
        int move = 0;
        // 회사에서 출발할 때
        move += Math.abs(companyX - result[0][0]) + Math.abs(companyY - result[0][1]);
        // 집에 도착할 때
        move += Math.abs(homeX - result[N-1][0]) + Math.abs(homeY - result[N-1][1]);
        for (int i = 0; i < N-1; i++) {
            // 고객집 다닐 때
            move += Math.abs(result[i+1][0] - result[i][0]) + Math.abs(result[i+1][1] - result[i][1]);
        }
        // 최소 경로 구하기
        if (move < min) min = move;
    }
}

/*
입력
2
5
0 0 100 100 70 40 30 10 10 5 90 70 50 20
6
88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14

출력
#1 200
#2 304
*/
