function solution(nums) {
  // 종류의 갯수를 파악하기 위한 배열 선언
  let kinds = [];
  // 배열을 조회하면서 종류 파악
  for (let i of nums) {
    // kinds배열에 해당 종을 가지고 있지 않으면 kinds 배열에 넣기
    if (!kinds.includes(i)) {
      kinds.push(i);
    }
  }
  // 가져갈 수 있는 n / 2 마리수가 종의 갯수보다 작거나 같을 때
  return nums.length / 2 <= kinds.length ? nums.length / 2 : kinds.length;
}
