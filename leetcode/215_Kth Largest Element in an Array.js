function findKthLargest(nums, k) {
  // nums 배열을 내림차순으로 정렬하여 인덱스를 기준으로 k-1번째 값 반환
  return nums.sort((a, b) => b - a)[k - 1];
}
