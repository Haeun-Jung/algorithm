function solution(n, times) {
  // 최대 정수값을 answer 변수에 저장
  let answer = Number.MAX_SAFE_INTEGER;

  // times 배열을 오름차순으로 정렬
  times.sort((a, b) => a - b);
  let left = 0;
  // 가장 늦게 끝나는 시간
  let right = times[times.length - 1] * n;

  while (left <= right) {
    // 이분탐색을 위한 mid 값
    let mid = Math.floor(left + right);
    // 해당 시간에 각 심사대의 최대 심사 수의 합을 구할 변수
    let count = 0;

    // times 배열을 순회하면서
    for (let i = 0; i < times.length; i++) {
      // 해당 시간의 심사 수를 계산하여 count 변수에 더하기
      count += Math.floor(mid / times[i]);
    }

    // 만일 count 변수가 사람 수 n 값보다 같거나 크다면
    // answer 변수와 mid 변수 중에 작은 값을 answer 변수에 저장
    // mid의 왼쪽을 탐색
    if (count >= n) {
      answer = Math.min(answer, mid);
      right = mid - 1;
    }
    // 만일 count 변수가 사람 수 n 값보다 작다면
    // mid의 오른쪽을 탐색
    else left = mid + 1;
  }
  return answer;
}
