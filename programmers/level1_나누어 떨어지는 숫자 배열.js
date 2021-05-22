function solution(arr, divisor) {
  let answer = [];

  for (let i of arr) {
    // 만일 값 i가 divisor에 의해 나누어 떨어질 경우
    if (i % divisor === 0) {
      // answer 배열에 해당 값 i를 push
      answer.push(i);
    }
  }
  // 만일 answer 배열의 길이가 0이라면 [-1]반환
  // 만일 answer 배열의 길이가 0이 아니라면 answer 배열을 오름차순으로 정렬하여 반환
  return answer.length === 0 ? [-1] : answer.sort((a, b) => a - b);
}
