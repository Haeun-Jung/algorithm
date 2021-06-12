function solution(n) {
  let answer = [];
  for (let i = 0; i <= n; i++) {
    // F(0) = 0
    if (i === 0) {
      answer.push(0);
    } // F(1) = 1
    else if (i === 1) {
      answer.push(1);
    } // n이 2 이상일 때
    else {
      // F(n) = F(n-1) + F(n-2)
      let sum = answer[i - 1] + answer[i - 2];
      // sum 값에서 1234567으로 나눈 나머지를 answer 배열에 push
      answer.push(sum % 1234567);
    }
  }
  let result = answer[n];
  return result;
}
