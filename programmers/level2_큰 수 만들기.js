function solution(number, k) {
  let result = [];

  for (let i = 0; i < number.length; i++) {
    // 갯수 k나 number 문자열을 다 순회하고, 항상 result 마지막 값이 number[i] 값보다 작아야 함
    while (
      k > 0 &&
      number.length > 0 &&
      result[result.length - 1] < number[i]
    ) {
      // 제거할 갯수 -1
      k--;
      // result의 마지막 값 제외
      result.pop();
    }
    // 해당 number[i] 값을 result 배열에 push
    result.push(number[i]);
  }
  // result 배열에서 number에서 k만큼 제외하고 남은 곳부터 k갯수만큼 제거
  result.splice(number.length - k, k);
  // result배열을 join시켜 반환
  return result.join("");
}
