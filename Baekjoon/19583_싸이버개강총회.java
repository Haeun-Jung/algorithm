/**
 * 다음과 같이 출석부를 관리하기로 결심했다.
 * 개강총회를 시작하기 전에, 학회원의 입장 확인 여부를 확인한다. 학회원의 입장 여부는 개강총회가 시작한 시간 이전에 대화를 한 적이 있는 학회원의 닉네임을 보고 체크한다. 개강총회를 시작하자마자 채팅 기록을 남긴 학회원도 제 시간에 입장이 확인된 것으로 간주한다.
 * 개강총회를 끝내고 나서, 스트리밍을 끝낼 때까지 학회원의 퇴장 확인 여부를 확인한다. 학회원의 퇴장 여부는 개강총회가 끝나고 스트리밍이 끝날 때까지 대화를 한 적이 있는 학회원의 닉네임을 보고 체크한다. 개강총회가 끝나자마자 채팅 기록을 남겼거나, 개강총회 스트리밍이 끝나자마자 채팅 기록을 남긴 학회원도 제 시간에 퇴장이 확인된 것으로 간주한다.  
 * 단, 00:00부터는 개강총회를 시작하기 전의 대기 시간이며, 개강총회 스트리밍 끝난 시간 이후로 남겨져 있는 채팅 기록은 다른 스트리밍 영상의 채팅 기록으로 간주한다.
 * 이 때, 입장부터 퇴장까지 모두 확인된 학회원은 전부 몇 명인가?
 * 
 * 첫번째 줄에는 개강총회를 시작한 시간 S, 개강총회를 끝낸 시간 E, 개강총회 스트리밍을 끝낸 시간 Q가 주어진다. (00:00 ≤ S < E < Q ≤ 23:59)
 * 두번째 줄부터는 HI-ARC에서 방송하는 스트리밍 영상의 채팅 기록들이 시간순으로 주어지는데, (시간) (학회원 닉네임)의 형태로 주어진다. 학회원의 닉네임은 알파벳 대소문자와 숫자, 그리고 특수 기호(., _, -)로만 구성된 문자열이며 최대 20글자이다.
 * 모든 채팅 기록은 개강총회가 일어난 날에 발생한 채팅 기록이다.
 * 
 * 출석이 확인된 학회원의 인원 수를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_19583_싸이버개강총회 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String S = st.nextToken();				// 개강총회 시작 시간
		String E = st.nextToken();				// 개강총회 끝낸 시간
		String Q = st.nextToken();				// 개강총회 스트리밍 끝낸 시간
		
		HashSet<String> start = new HashSet<>();// 시작때 채팅친 학회원
		HashSet<String> end = new HashSet<>();	// 끝날때 채팅친 학회원
		HashSet<String> name = new HashSet<>();	// 채팅친 학회원 명단
        String str = null;
        
        // 입력이 끝날 때까지
        while ((str = br.readLine()) != null) {
        	String[] arr = str.split(" ");
            String time = arr[0];				// 채팅 친 시간
            String who = arr[1];				// 채팅 친 학회원 이름

            // 명단에 이름 추가
            name.add(who);
            // 만일 시작하기전에 채팅을 남겼다면
            if (S.compareTo(time) >= 0) start.add(who);
            // 만일 개강총회가 끝나고 스트리밍이 끝날때까지 채팅을 남겼다면
            else if (E.compareTo(time) <= 0 && Q.compareTo(time) >= 0) end.add(who);
        }

        // 출석이 확인된 학회원
        int cnt = 0;
        for (String who : name) {
            if (start.contains(who) && end.contains(who)) {
            	cnt++;
            }
        }
        // 출력
        System.out.println(cnt);
	}
}

/*
입력
22:00 23:00 23:30
21:30 malkoring
21:33 tolelom
21:34 minjae705
21:35 hhan14
21:36 dicohy27
21:40 906bc
23:00 906bc
23:01 tolelom
23:10 minjae705
23:11 hhan14
23:20 dicohy27

출력
5
*/
