function solution(s) {
  let answer = "";

  for (let i = 0; i < s.length; i++) {
    // 만일 첫번째 요소(s[i])이거나 바로 직전 요소(s[i-1])가 ' '라면(모든 단어의 첫문자라면)
    if (i === 0 || s[i - 1] === " ") {
      // 해당 값을 대문자로 변환시켜 answer에 더하기
      answer += s[i].toUpperCase();
    }
    // 만일 첫문자가 아니라면
    else {
      // 해당 값을 소문자로 변환시켜 answer에 더하기
      answer += s[i].toLowerCase();
    }
  }
  return answer;
}
