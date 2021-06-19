function solution(n) {
  let answer = "";
  for (let i = 1; i < n + 1; i++) {
    // i가 2로 나누어 떨어지면 answer 값에 '박' 추가
    if (i % 2 === 0) {
      answer += "박";
    } // i가 2로 나누어 떨어지지 않으면 answer 값에 '수' 추가
    else {
      answer += "수";
    }
  }
  return answer;
}
