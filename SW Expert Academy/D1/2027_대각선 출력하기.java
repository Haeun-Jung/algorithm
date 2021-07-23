public class Solution {
	public static void main(String[] args) {

       	for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                // i와 j의 위치가 같을 때만 #넣고 나머지는 +로 채우기
                if (i == j) System.out.print('#');
                else System.out.print('+');
            }
            // 줄 바꿈
            System.out.println();
        }
    }
}

/*

출력
#++++
+#+++
++#++
+++#+
++++#

*/