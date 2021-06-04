function findDuplicate(nums) {
  // 중복된 값을 찾을 배열
  let arr = [];
  for (let i = 0; i < nums.length; i++) {
    // arr 배열에 해당 nums[i]값이 없다면 push
    if (!arr.includes(nums[i])) {
      arr.push(nums[i]);
    } // arr 배열에 해당 nums[i]값이 있다면 중복이므로 nums[i]값 반환
    else {
      return nums[i];
    }
  }
}
