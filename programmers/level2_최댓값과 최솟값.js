function solution(s) {
  // 문자열 s를 ' ' 기준으로 나누어 배열로 저장
  let arr = s.split(" ");
  // 배열 arr에서 최솟값과 최댓값을 추출하여 반환
  return Math.min(...arr) + " " + Math.max(...arr);
}
