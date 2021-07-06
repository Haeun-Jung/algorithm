function solution(n) {
  let answer = "";
  // 주어진 수를 3으로 나눈 나머지가 0일 때 4
  // 나머지가 1일 때 1
  // 나머지가 2일 때 2
  const arr = [4, 1, 2];

  while (n) {
    answer = arr[n % 3] + answer;
    // 나머지가 0이면 몫에서 -1
    n = n % 3 === 0 ? n / 3 - 1 : Math.floor(n / 3);
  }
  return answer;
}
