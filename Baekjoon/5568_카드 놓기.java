/**
 * 상근이는 카드 n(4 ≤ n ≤ 10)장을 바닥에 나란히 놓고 놀고있다. 각 카드에는 1이상 99이하의 정수가 적혀져 있다. 상근이는 이 카드 중에서 k(2 ≤ k ≤ 4)장을 선택하고, 가로로 나란히 정수를 만들기로 했다. 
 * 상근이가 만들 수 있는 정수는 모두 몇 가지일까?
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_5568_카드놓기 {
	
	public static int n, k;
	public static int[] arr, result;
	public static boolean[] checked;
	public static HashSet<String> hs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());	// 카드 n장
		k = Integer.parseInt(br.readLine());	// k장 선택
		arr = new int[n];						// 카드에 쓰여진 수
		result = new int[n];					// 카드 뽑기
		checked = new boolean[n];				// 방문 체크
		hs = new HashSet<>();					// 중복 제거
		
		for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
		
		perm(0);
		// 출력
		System.out.println(hs.size());
	}
	
	// 순열
	public static void perm(int num) {
		// 기저조건
		if (num == k) {
			String str = "";
			for (int i = 0; i < n; i++) {
				str += result[i];
			}
			// 중복 제거
			hs.add(str);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (checked[i]) continue;
			result[num] = arr[i];
			checked[i] = true;
			perm(num + 1);
			checked[i] = false;
		}
	}
}

/*
입력
4
2
1
2
12
1

출력
7
*/
