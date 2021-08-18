import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    private static int N, K, min;
    private static boolean[] A, B;
    private static int[][] arr;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());            // 테스트 케이스의 수
         
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());            // N개의 식재료
            K = N / 2;                                      // 각 음식의 K개의 재료
            arr = new int[N][N];
            A = new boolean[N];                             // A음식
            B = new boolean[N];                             // B음식
            min = Integer.MAX_VALUE;                        // 최소의 차이
             
            // 시너지 표
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            comb(0, 0);
            // 출력
            System.out.printf("#%d %d\n", tc, min);
        }
    }
     
    // 재료를 나누는 조합
    private static void comb(int cnt, int start) {
        // 기저조건
        if (cnt == K) {
            // B음식 선택
            B = new boolean[N];
            for (int i = 0; i < N; i++) {
                if (!A[i]) B[i] = true;
            }
            // 맛의 차이 구하기
            getDistance();
            return;
        }
         
        // A음식 선택
        for (int i = start; i < N; i++) {
            A[i] = true;
            comb(cnt+1, i+1);
            A[i] = false;
        }
    }
     
    // 맛의 차이 구하기
    private static void getDistance() {
        int sumA = 0;           // A음식의 맛
        int sumB = 0;           // B음식의 맛
        for (int i = 0; i < N; i++) {
            if (A[i]) {
                for (int j = 0; j < N; j++) {
                    if (i != j && A[j]) {
                        sumA += arr[i][j];
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (B[i]) {
                for (int j = 0; j < N; j++) {
                    if (i != j && B[j]) {
                        sumB += arr[i][j];
                    }
                }
            }
        }
        // A, B음식의 맛의 최소 차이 찾기
        int distance = Math.abs(sumA - sumB);
        if (distance < min) min = distance;
    }
}

/*
입력
10
4
0 5 3 8
4 0 4 1
2 5 0 3
7 2 3 0


출력
#1 2
*/
