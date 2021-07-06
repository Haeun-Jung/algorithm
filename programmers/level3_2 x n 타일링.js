function solution(n) {
  // 피보나치 수열
  let arr = [1, 2];

  for (let i = 2; i <= n; i++) {
    arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
  }
  return arr[n - 1];
}
