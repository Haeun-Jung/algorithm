function solution(numbers, target) {
  let answer = 0;
  recur(0, 0);
  return answer;

  // DFS
  function recur(count, sum) {
    // numbers 요소의 모든 수를 연산하여 target 값과 같으면 answer+1
    if (count === numbers.length) {
      if (sum === target) {
        answer++;
      }
      return;
    }

    // +, - 연산 수행
    recur(count + 1, sum - numbers[count]);
    recur(count + 1, sum + numbers[count]);
  }
}
