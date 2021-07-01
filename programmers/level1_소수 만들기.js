function solution(nums) {
  let answer = 0;
  let temp = [];

  // 서로 다른 3개의 수를 더한 값을 temp 배열에 push
  for (let i = 0; i < nums.length - 2; i++) {
    for (let j = i + 1; j < nums.length - 1; j++) {
      for (let k = j + 1; k < nums.length; k++) {
        temp.push(nums[i] + nums[j] + nums[k]);
      }
    }
  }

  // temp 배열을 탐색하면서 소수인지 판별
  for (let i of temp) {
    // isPrime 함수를 통해 만일 해당 값 i가 소수라면 answer + 1
    if (isPrime(i)) {
      answer++;
    }
  }
  return answer;
}

// 소수 판별 함수
function isPrime(n) {
  // i는 2부터 i의 제곱이 n 값이 될 때까지 반복문 수행
  for (let i = 2; i ** 2 <= n; i++) {
    // 만일 n 값이 i 값으로 나누어 떨어진다면 false 반환
    if (n % i === 0) {
      return false;
    }
  }
  // 나누어 떨어지는 수가 없다면 소수이므로 true 반환
  return true;
}
