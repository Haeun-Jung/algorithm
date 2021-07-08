function solution(A, B) {
  let answer = 0;

  // A 배열을 내림차순으로 정렬
  A.sort((a, b) => b - a);
  // B 배열을 오름차순으로 정렬
  B.sort((a, b) => a - b);

  // A 배열을 순회하면서
  for (let i of A) {
    // B 배열에서 가장 큰 값을 max 변수에 저장
    let max = B[B.length - 1];
    // 만일 i 값보다 max 값이 크다면 answer+1
    // B 배열의 마지막 원소(가장 큰 값) pop
    if (i < max) {
      answer++;
      B.pop();
    }
  }
  return answer;
}
