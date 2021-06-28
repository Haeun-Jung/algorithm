function solution(s) {
  // 짝지어 제거하기 위한 stack 배열
  let stack = [];

  for (let i = 0; i < s.length; i++) {
    // 만일 stack 배열이 비어있거나 같은 알파벳이 아니라면
    if (stack.length === 0 || stack[stack.length - 1] !== s[i]) {
      // stack 배열에 해당 값 s[i]를 push
      stack.push(s[i]);
    }
    // 만일 같은 알파벳이 2개 붙어있다면 해당 문자열을 제거
    else {
      stack.pop();
    }
  }

  // 만일 문자열을 모두 제거할 수 있다면 1 반환
  if (stack.length === 0) {
    return 1;
  }
  // 문자열이 남아있지만 짝지어 제거할 수 없는 문자열이라면 0 반환
  else {
    return 0;
  }
}
