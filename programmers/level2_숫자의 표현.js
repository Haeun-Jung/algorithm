function solution(n) {
  let answer = 1;
  for (let i = 1; i <= Math.floor(n / 2); i++) {
    let k = i;
    let sum = 0;
    // sum 값이 n보다 크거나 같을 때까지 k++(연속된 자연수이므로)
    while (sum < n) {
      sum += k++;
    } // 만일 sum 값과 n이 같다면 answer++(방법 + 1)
    if (sum === n) {
      answer++;
    }
  }
  return answer;
}
