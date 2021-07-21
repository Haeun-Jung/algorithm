function solution(x, n) {
  let answer = [];
  let num = x;

  // n만큼 반복
  for (let i = 0; i < n; i++) {
    // answer 배열에 해당 x 값 push
    answer.push(x);
    // x씩 증가시키기
    x += num;
  }
  return answer;
}
