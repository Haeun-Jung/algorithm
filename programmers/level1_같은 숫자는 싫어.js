function solution(arr) {
  // 정답을 담을 answer 배열 선언
  let answer = [];

  // arr배열을 돌며 같은 숫자가 연속적으로 나타나는지 확인
  for (let i = 0; i < arr.length; i++) {
    // 만약 arr[i] 값이 다음 값과 다르다면
    if (arr[i] !== arr[i + 1]) {
      // answer 배열에 해당 값 push
      answer.push(arr[i]);
    }
  }
  return answer;
}
