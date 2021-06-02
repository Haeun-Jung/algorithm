function twoSum(nums, target) {
  // 이중 for문으로 두 값의 합 구하기
  for (let i = 0; i < nums.length - 1; i++) {
    for (let j = i + 1; j < nums.length; j++) {
      // 두 값의 합이 target과 일치한다면 인덱스 값 반환
      if (nums[i] + nums[j] === target) {
        return [i, j];
      }
    }
  }
}
