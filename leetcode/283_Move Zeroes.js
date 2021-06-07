function moveZeroes(nums) {
  // nums배열 뒤에서부터 for문 탐색
  // 앞에서부터 탐색하면 인덱스가 밀림
  for (let i = nums.length - 1; i >= 0; i--) {
    // 만일 해당 값 nums[i]가 0이라면
    if (nums[i] === 0) {
      // nums 배열에 0 push
      nums.push(0);
      // nums 배열에 해당 인덱스부터 1개 잘라내기
      nums.splice(i, 1);
    }
  }
  return nums;
}
