function climbStairs(n) {
  // 계단을 오르는 방법 개수를 넣는 배열
  let arr = [];
  // 첫번째 계단을 오르는 방법은 1step 한가지
  arr[1] = 1;
  // 두번째 계단을 오르는 방법은 1step + 1step, 2step이므로 두가지
  arr[2] = 2;

  // 다이나믹 프로그래밍
  // 점화식 세우기
  // 세번째 계단부터는 바로 전 계단의 방법수와 전전 계단의 방법수를 더한 값과 일치
  for (let i = 3; i <= n; i++) {
    arr[i] = arr[i - 1] + arr[i - 2];
  }

  // n번째 계단을 오르는 방법 개수를 반환
  return arr[n];
}
