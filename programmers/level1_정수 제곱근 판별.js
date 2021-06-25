function solution(n) {
  // 반복문 돌면서 제곱근 탐색
  for (let i = 1; i < n / 4; i++) {
    // 제곱근을 찾으면 (i+1)을 제곱한 값을 반환
    if (i ** 2 === n) {
      return (i + 1) ** 2;
    }
  }
  // 양의 정수의 제곱이 아니면 -1 반환
  return -1;
}
