/**
 * 세준이를 생각해준 사람은 총 N명이 있다. 사람의 번호는 1번부터 N번까지 있다. 세준이가 i번 사람에게 인사를 하면 L[i]만큼의 체력을 잃고, J[i]만큼의 기쁨을 얻는다. 세준이는 각각의 사람에게 최대 1번만 말할 수 있다.
 * 세준이의 목표는 주어진 체력내에서 최대한의 기쁨을 느끼는 것이다. 세준이의 체력은 100이고, 기쁨은 0이다. 만약 세준이의 체력이 0이나 음수가 되면, 죽어서 아무런 기쁨을 못 느낀 것이 된다. 세준이가 얻을 수 있는 최대 기쁨을 출력하는 프로그램을 작성하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1535_안녕 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 사람의 수
		int[] minus = new int[N+1];
		int[] plus = new int[N+1];
		int[][] dp = new int[N+1][101];
		
		// 잃는 체력
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) minus[i] = Integer.parseInt(st.nextToken());
		
		// 얻는 기쁨
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) plus[i] = Integer.parseInt(st.nextToken());
	
		// dp
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= 100; j++) {
				// 체력이 남아있다.
				if (j - minus[i] > 0) dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-minus[i]]+plus[i]);
				// 인사불가
				else dp[i][j] = dp[i-1][j];
			}
		}
		
		// 출력
		System.out.println(dp[N][100]);
	}
}

/*
입력
8
100 15 1 2 3 4 6 5
49 40 1 2 3 4 5 4

출력
59
*/
