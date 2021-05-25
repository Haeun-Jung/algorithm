function solution(s, n) {
  let answer = "";

  for (let i = 0; i < s.length; i++) {
    // 해당 값 s[i]이 공백이면 그대로 answer 값에 더하기
    if (s[i] === " ") {
      answer += " ";
    }
    // 해당 값 s[i]이 문자라면
    else {
      // s[i]를 대문자로 변환, 아스키 코드 값으로 변환 후에 n을 더한 값이 90(Z)을 넘어간다면 1, 넘어가지 않는다면 2
      // 1. s[i]의 아스키 코드 값에 n을 더한 값에 26(알파벳 총 갯수)를 빼고 다시 문자로 변환하여 answer 값에 더하기
      // 2. s[i]의 아스키 코드 값에 n을 더한 값을 다시 문자로 변환하여 answer 값에 더하기
      answer +=
        s[i].toUpperCase().charCodeAt() + n > 90
          ? String.fromCharCode(s[i].charCodeAt() + n - 26)
          : String.fromCharCode(s[i].charCodeAt() + n);
    }
  }
  return answer;
}
