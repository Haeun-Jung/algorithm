function solution(s) {
  let answer = 0;
  for (let i = 0; i < s.length; i++) {
    // stack 초기화
    let stack = [];
    for (let j = 0; j < s.length; j++) {
      // stack에 값이 있다면
      if (stack !== 0) {
        // 현재 값 s[j]와 stack의 마지막 값이 올바른 괄호일 때
        if (
          (s[j] === "]" && stack[stack.length - 1] === "[") ||
          (s[j] === "}" && stack[stack.length - 1] === "{") ||
          (s[j] === ")" && stack[stack.length - 1] === "(")
        ) {
          // stack 마지막 값 pop
          stack.pop();
        } // 현재 값 s[j]와 stack의 마지막 값이 다른 괄호일 때
        else {
          // stack에 현재 값 s[j] push
          stack.push(s[j]);
        }
      } // stack이 비어있다면
      else {
        // stack에 현재 값 s[j] push
        stack.push(s[j]);
      }
    }
    // 만약 stack의 길이가 0이라면 올바른 괄호이므로 answer++
    if (stack.length === 0) answer++;
    // s 값을 왼쪽으로 회전시키기
    s = s.slice(1) + s[0];
  }
  return answer;
}
