function findDisappearedNumbers(nums) {
  // nums 배열의 요소와 비교할 같은 길이의 arr 배열 선언
  let arr = new Array(len).fill(false);
  let len = nums.length;
  let answer = [];

  for (let i = 0; i < len; i++) {
    // nums[i] 값을 지칭하는 인덱스로 arr 배열 값을 true로 저장
    arr[nums[i] - 1] = true;
  }

  for (let i = 0; i < len; i++) {
    // arr[i] 값이 nums 배열에 존재하지 않는다면
    if (arr[i] === false) {
      // answer 배열에 해당 인덱스 +1 값을 push
      answer.push(i + 1);
    }
  }
  return answer;
}
