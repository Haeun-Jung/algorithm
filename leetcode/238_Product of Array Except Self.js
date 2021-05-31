function productExceptSelf(nums) {
  let result = [];
  let n = 1;

  // nums 배열을 순차적으로 탐색
  for (let i = 0; i < nums.length; i++) {
    // 자신의 값을 곱하기 전 n의 값을 result[i]에 저장
    result[i] = n;
    // n값에 자신의 값 nums[i] 곱하기
    n *= nums[i];
  }

  // n값 초기화
  n = 1;
  // nums 배열을 역순으로 탐색
  for (let i = nums.length - 1; i >= 0; i--) {
    // 기존 result[i]값에 자신의 값을 곱하기 전 n의 값을 곱하여 저장
    result[i] *= n;
    // n값에 자신의 값 nums[i] 곱하기
    n *= nums[i];
  }
  return result;
}
