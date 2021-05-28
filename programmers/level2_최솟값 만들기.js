function solution(A, B) {
  let answer = 0;
  // 배열 A를 오름차순으로 정렬
  A.sort((a, b) => a - b);
  // 배열 B를 내림차순으로 정렬
  B.sort((a, b) => b - a);
  // 배열 A, B의 값을 순차적으로 곱하여 answer 변수에 더하기
  for (let i = 0; i < A.length; i++) {
    answer += A[i] * B[i];
  }
  return answer;
}
