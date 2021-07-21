function solution(n) {
  // 자연수 n을 문자열로 변환
  let temp = String(n);
  let arr = [];

  // temp 문자열을 배열로 나누어 내림차순으로 정렬
  arr = temp.split("").sort((a, b) => b - a);
  // 정렬된 arr 배열을 join하여 문자열로 변환
  let str = arr.join("");

  // 문자열 str을 10진수로 변환하여 반환
  return parseInt(str, 10);
}
