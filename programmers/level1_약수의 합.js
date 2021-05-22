function solution(n) {
  let answer = 0;
  for (let i = 1; i <= n; i++) {
    // 만일 n이 i로 나누어 떨어진다면(약수)
    if (n % i === 0) {
      // answer 변수에 해당 값 i 더하기
      answer += i;
    }
  }
  return answer;
}
