function solution(arr) {
  // 만일 배열의 원소가 1개라면
  if (arr.length === 1) {
    // [-1] 반환
    return [-1];
  }
  // arr 배열에서 최솟값이 있는 위치를 찾아 제거
  arr.splice(arr.indexOf(Math.min(...arr)), 1);
  // 최솟값을 제거한 arr 배열을 반환
  return arr;
}
