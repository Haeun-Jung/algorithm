function solution(a, b) {
  // 답을 반환할 변수
  let answer = 0;
  // 배열의 길이만큼 돌며 내적 구하기
  for (let i = 0; i < a.length; i++) {
    answer += a[i] * b[i];
  }
  return answer;
}
