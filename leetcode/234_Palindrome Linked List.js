function isPalindrome(head) {
  let left = "";
  let right = "";

  // head 값을 다 탐색할 때까지 반복
  while (head) {
    // left 변수에 head의 값을 추가
    left += head.val;
    // right 변수 앞 쪽에 head의 값을 추가
    right = head.val + right;
    // 다음 head 값으로 지정
    head = head.next;
  }
  // 만일 left 값과 right 값이 같다면 true 반환, 다르면 false 반환
  return left === right;
}
