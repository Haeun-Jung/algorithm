import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int n;               // 원소 개수
    static int[] parents;       // 부모 원소를 관리(트리처럼 사용)
     
    // a가 속한 집합의 대표자 찾기
    private static int find(int a) {
        if (a == parents[a]) return a;          // 자신이 대표자
        return parents[a] = find(parents[a]);   // 자신이 속한 집합의 대표자를 자신의 부모로 : path compression
    }
     
    // 두 원소를 하나의 집합으로 합치기(대표자를 이용해서 합침)
    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;       // 이미 같은 집합으로 합쳐지지 않음
         
        // 다른 집합이면 대표 통일
        parents[bRoot] = aRoot;
        return true;
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());        // 테스트 케이스의 수
         
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());       // n개의 집합
            int m = Integer.parseInt(st.nextToken());   // 연산의 개수
            parents = new int[n+1];                     // 부모 원소 관리
             
            for (int i = 1; i <= n; i++) {
                parents[i] = i;
            }
             
            for (int cnt = 1; cnt <= m; cnt++) {
                st = new StringTokenizer(br.readLine(), " ");
                int cal = Integer.parseInt(st.nextToken()); // 연산
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                 
                // 합집합일 때
                if (cal == 0) {
                    union(a, b);
                }
                // 두 원소가 같이 집합에 포함되어 있는지 확인
                else {
                    // 대표가 같다면 1 저장
                    if (find(a) == find(b)) sb.append(1);
                    // 대표가 다르다면 0 저장
                    else sb.append(0);
                }
            }
            // 출력
            System.out.printf("#%d %s\n", tc, sb);
        }
    }
}

/*
입력
1
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1

출력
#1 001
*/
