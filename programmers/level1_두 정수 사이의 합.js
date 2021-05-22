function solution(a, b) {
  let answer = 0;
  // a, b 값 중 최솟값부터 시작하여 a, b값 중 최댓값까지 for문 반복
  for (let i = Math.min(a, b); i <= Math.max(a, b); i++) {
    // answer 값에 a, b 사이의 값들을 더하기
    answer += i;
  }

  return answer;
}
