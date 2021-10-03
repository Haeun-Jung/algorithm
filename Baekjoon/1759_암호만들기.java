/**
 * 암호는 서로 다른 L개의 알파벳 소문자들로 구성되며 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성되어 있다고 알려져 있다.
 * 또한 정렬된 문자열을 선호하는 조교들의 성향으로 미루어 보아 암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열되었을 것이라고 추측된다.
 * 즉, abc는 가능성이 있는 암호이지만 bac는 그렇지 않다.
 *
 * 새 보안 시스템에서 조교들이 암호로 사용했을 법한 문자의 종류는 C가지가 있다고 한다.
 * 이 알파벳을 입수한 민식, 영식 형제는 조교들의 방에 침투하기 위해 암호를 추측해 보려고 한다.
 * C개의 문자들이 모두 주어졌을 때, 가능성 있는 암호들을 모두 구하는 프로그램을 작성하시오.
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {
	static int L, C;
	static char[] arr;
    static boolean[] result;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());			// 서로 다른 L개의 알파벳
        C = Integer.parseInt(st.nextToken());			// 문자의 종류 C가지
        arr = new char[C];								// 주어지는 문자
        result = new boolean[C];
        
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
 
        // 오름차순으로 정렬
        Arrays.sort(arr);
        DFS(0, 0, 0, 0);
    }
 
    // DFS
    public static void DFS(int cnt, int start, int vowel, int consonant) {
    	// L개 뽑고 자음이 2개 이상, 모음이 1개 이상일 때 출력
        if (cnt == L && vowel >= 1 && consonant >= 2) {
        	for (int i = 0; i < C; i++) {
                if (result[i]) System.out.print(arr[i]);
            }
            System.out.println();
        }
 
        for (int i = start; i < C; i++) {
        	// 선택
            result[i] = true;
            // 자음과 모음 갯수를 파악해서 다음으로 넘겨준다.
            DFS(cnt + 1, i + 1, vowel + (check(arr[i]) ? 1 : 0), consonant + (check(arr[i]) ? 0 : 1));
            // 선택 해제
            result[i] = false;
        }
    }
 
    // 모음인지 확인
    public static boolean check(char ch) {
    	// 모음일 때
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        // 자음일 때
        return false;
    }
}

/*
입력
4 6
a t c i s w

출력
acis
acit
aciw
acst
acsw
actw
aist
aisw
aitw
astw
cist
cisw
citw
istw
*/
