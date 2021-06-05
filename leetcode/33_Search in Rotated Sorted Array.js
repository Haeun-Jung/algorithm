function search(nums, target) {
  // nums 배열 탐색
  for (let i = 0; i < nums.length; i++) {
    // target 값과 동일한 값이 나오면 해당 인덱스값 반환
    if (nums[i] === target) {
      return i;
    }
  }
  // target 값과 동일한 값이 없으면 -1 반환
  return -1;
}
