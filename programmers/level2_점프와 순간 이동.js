function solution(n) {
  let answer = 0;
  // 거리(n)가 0이 될 때까지 반복
  while (n > 0) {
    // 만일 거리(n)가 2로 나누어떨어진다면
    if (n % 2 === 0) {
      // 해당 거리를 순간이동, 건전지 사용 X
      n = n / 2;
    }
    // 만일 거리(n)가 2로 나누어 떨어지지 않는다면
    else {
      // 한 칸 점프, 건전지 사용 O
      answer++;
      n -= 1;
    }
  }
  return answer;
}
