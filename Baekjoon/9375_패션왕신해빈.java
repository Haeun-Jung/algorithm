/*
 * 해빈이는 패션에 매우 민감해서 한번 입었던 옷들의 조합을 절대 다시 입지 않는다. 예를 들어 오늘 해빈이가 안경, 코트, 상의, 신발을 입었다면, 다음날은 바지를 추가로 입거나 안경대신 렌즈를 착용하거나 해야한다. 해빈이가 가진 의상들이 주어졌을때 과연 해빈이는 알몸이 아닌 상태로 며칠동안 밖에 돌아다닐 수 있을까?
 * 
 * 첫째 줄에 테스트 케이스가 주어진다. 테스트 케이스는 최대 100이다.
 * 각 테스트 케이스의 첫째 줄에는 해빈이가 가진 의상의 수 n(0 ≤ n ≤ 30)이 주어진다.
 * 다음 n개에는 해빈이가 가진 의상의 이름과 의상의 종류가 공백으로 구분되어 주어진다. 같은 종류의 의상은 하나만 입을 수 있다.
 * 모든 문자열은 1이상 20이하의 알파벳 소문자로 이루어져있으며 같은 이름을 가진 의상은 존재하지 않는다.
 * 
 * 각 테스트 케이스에 대해 해빈이가 알몸이 아닌 상태로 의상을 입을 수 있는 경우를 출력하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_9375_패션왕신해빈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		// 테스트케이스의 수
		
		for (int tc = 1; tc <= T; tc++) {
			HashMap<String, Integer> hash = new HashMap<>();
			int n = Integer.parseInt(br.readLine());	// 의상의 수
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String cloth = st.nextToken();			// 의상의 이름
				String category = st.nextToken();		// 의상의 종류
				// 의상 종류 중복 X
				if (!hash.containsKey(category)) {
					hash.put(category, 1);
				}
				// 의상 종류 중복 O
				else hash.put(category, hash.get(category) + 1);
			}
			
			// 의상 조합 수 구하기
			int answer = 1;
			for (Integer cnt : hash.values()) answer *= cnt + 1;
			// 아예 안입는 경우를 제외하고 출력
			System.out.println(answer-1);
		}
	}
}

/*
입력
2
3
hat headgear
sunglasses eyewear
turban headgear
3
mask face
sunglasses face
makeup face

출력
5
3
*/
