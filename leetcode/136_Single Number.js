function singleNumber(nums) {
  // 중복되는 값을 잡기 위한 배열
  let arr = [];
  for (let i of nums) {
    // 만일 arr 배열에 해당 값 i 가 없다면
    if (!arr.includes(i)) {
      // arr 배열에 i값 push
      arr.push(i);
    }
    // 만일 arr 배열에 해당 값 i 가 있다면
    else {
      // 값이 중복이므로 arr 배열에서 해당 값을 제거
      arr.splice(arr.indexOf(i), 1);
    }
  }
  // 중복된 수를 제거하고 남은 arr 배열의 첫번째 값을 반환
  return arr[0];
}
