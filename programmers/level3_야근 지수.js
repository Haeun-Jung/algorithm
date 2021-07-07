function solution(n, works) {
  let answer = 0;
  // 가장 많은 작업량을 max 변수에 저장
  let max = works.sort((a, b) => b - a)[0];

  // n시간을 다 소요할 때까지
  while (n > 0) {
    // 작업량 works 배열을 탐색하면서
    for (let i = 0; i < works.length; i++) {
      // 만일 max 값과 해당 값 works[i] 값이 같다면
      if (max === works[i]) {
        // 해당 작업량 works[i]이 남아있다면 값에서 -1, 남아있지 않다면 0을 빼기
        works[i] -= works[i] > 0 ? 1 : 0;
        // 1시간 소요
        n--;
      }
      // 만일 n시간을 다 소요하였다면 반복문 나오기
      if (!n) break;
    }
    // 가장 많은 작업량 max값을 -1
    max--;
    // 만일 max 값이 0이라면 반복문 나오기
    if (!max) break;
  }

  // 작업량 배열 works을 순회하면서
  for (let i of works) {
    // answer 변수에 해당 값 i를 제곱하여 더하기
    answer += i ** 2;
  }
  return answer;
}
