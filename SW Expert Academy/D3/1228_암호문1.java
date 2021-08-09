import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        for (int tc = 1; tc <= 10; tc++) {
            int N = sc.nextInt();                   // 원본 암호문의 길이
            String[] arr = new String[N];           // 원본 암호문
             
            // 원본 암호문 채우기
            for (int i = 0; i < N; i++) {
                arr[i] = sc.next();
            }
             
            int chN = sc.nextInt();             // 명령어의 개수
            String trash = "";                  // 제외되는 암호
            for (int cnt = 0; cnt < chN; cnt++) {
                // 명령어 시작
                String start = sc.next();
                // 시작 인덱스
                int index = sc.nextInt();
                // 삽입할 개수
                int chCount = sc.nextInt();
                    // 암호문에 삽입
                    for (int i = index; i < index + chCount; i++) {
                        if (i < N) {
                            // 기존 배열 따로 보관
                            String temp[] = new String[N];
                            for (int idx = i; idx < N; idx++) {
                                temp[idx] = arr[idx];
                            }
                            // 삽입
                            arr[i] = sc.next();
                            // 밀린 값 다시 저장
                            for (int idx = i + 1; idx < N; idx++) {
                                arr[idx] = temp[idx-1];
                            }
                        }
                        else trash = sc.next();
                    }
            }
            // 출력
            System.out.printf("#%d ", tc);
            for (int i = 0; i < 10; i++) {
                System.out.printf("%s ", arr[i]);
            }
            System.out.println();
        }
        sc.close();
    }
}

/*
테스트케이스 1개일 때

입력
11
449047 855428 425117 532416 358612
929816 313459 311433 472478 589139 568205
7
I 1 5 400905 139831 966064 336948 119288
I 8 6 436704 702451 762737 557561 810021 771706
I 3 8 389953 706628 552108 238749 661021 498160 493414 377808
I 13 4 237017 301569 243869 252994
I 3 4 408347 618608 822798 370982
I 8 2 424216 356268
I 4 10 512816 992679 693002 835918 768525 949227 628969 521945 839380 479976

출력
#1 449047 400905 139831 408347 512816 992679 693002 835918 768525 949227
*/