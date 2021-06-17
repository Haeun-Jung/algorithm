function solution(n, a, b) {
  let answer = 0;
  // a 값과 b 값이 같을 때까지
  while (a !== b) {
    // a 값에서 2를 나누고 올림
    a = Math.ceil(a / 2);
    // b 값에서 2를 나누고 올림
    b = Math.ceil(b / 2);
    // 라운드 + 1
    answer++;
  }
  return answer;
}
