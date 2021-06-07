function longestConsecutive(nums) {
  // nums가 빈 배열이거나 null이라면 0 반환
  if (nums.length === 0 || nums === null) {
    return 0;
  }
  // nums 배열을 중복 없는 배열로 만들어서 저장
  const set = new Set(nums);
  // 최댓값을 찾기 위한 변수
  let max = 0;

  for (let i = 0; i < nums.length; i++) {
    // 만일 set 배열이 해당 값 nums[i]의 바로 이전 값을 가지고 있다면 다음 반복문 실행
    if (set.has(nums[i] - 1)) continue;
    // nums[i]의 바로 이전 값이 없다면 cnt는 1로 초기화
    let cnt = 1;
    // nums[i]값을 next 변수에 저장
    let next = nums[i];

    // set 배열에서 nums[i]의 바로 다음 값이 없을 때까지 cnt++ 반복
    while (set.has(++next)) {
      cnt++;
    }
    // cnt 값과 max 값 중 큰 값을 max 변수에 저장
    max = Math.max(cnt, max);
  }
  // 최댓값 반환
  return max;
}
