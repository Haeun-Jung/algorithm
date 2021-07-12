function solution(n, s) {
  if (n > s) return [-1];

  // s 값을 n개의 갯수로 나누어 mid 변수에 저장
  // 중간값들의 곱이 최대의 곱이 될 수 있음
  let mid = Math.floor(s / n);
  // n개만큼 배열을 만들어 mid 변수로 채우기
  let answer = new Array(n).fill(mid);

  // s 값을 n개로 나누고 남은 수들의 값 지정
  for (let i = 0; i < s % n; i++) {
    answer[answer.length - (i + 1)]++;
  }
  return answer;
}
