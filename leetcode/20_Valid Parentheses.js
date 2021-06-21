function isValid(s) {
  const left = [];
  const valid = {
    "(": ")",
    "{": "}",
    "[": "]",
  };
  for (let i = 0; i < s.length; i++) {
    // 만일 s[i] 값이 왼쪽 요소라면 left 배열에 push
    if (s[i] === "(" || s[i] === "{" || s[i] === "[") {
      left.push(s[i]);
    } // 만일 s[i] 값과 left 배열의 마지막 값의 짝이 같지 않다면 false 반환
    else if (s[i] !== valid[left.pop()]) {
      return false;
    }
  }
  // left 배열에 값이 남아있다면 false 반환, 값이 없다면 true 반환
  return left.length ? 0 : 1;
}
