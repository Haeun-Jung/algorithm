function majorityElement(nums) {
  // nums 배열을 오름차순으로 정렬
  nums.sort((a, b) => a - b);
  let len = nums.length;
  let max = -1;
  let cnt = 0;
  let answer;

  // for문으로 nums 배열 탐색
  for (let i = 0; i < len; i++) {
    // 만일 해당 값 nums[i]와 다음 값 nums[i+1]이 다르다면
    if (nums[i] !== nums[i + 1]) {
      // 갯수 + 1
      cnt++;
      // max 값과 cnt 값 중 큰 값을 max 변수에 저장
      max = Math.max(max, cnt);
      // 다음 값은 새로운 값이므로 cnt 값 리셋
      cnt = 0;
      // max 값이 nums 배열 길이의 반보다 크다면
      if (max > len / 2) {
        // 해당 값 nums[i]를 answer에 저장
        answer = nums[i];
        // for문 빠져나가기
        break;
      }
    } // 만일 해당 값 nums[i]와 다음 값 nums[i+1]이 같다면
    else {
      // 갯수 + 1
      cnt++;
    }
  }
  return answer;
}
