function solution(arr1, arr2) {
  let answer = [];
  let temp = [];
  let sum = 0;

  for (let i = 0; i < arr1.length; i++) {
    for (let j = 0; j < arr2[0].length; j++) {
      for (let k = 0; k < arr2.length; k++) {
        sum += arr1[i][k] * arr2[k][j];
      }
      // temp 배열에 sum 값 push하고 sum 값 초기화
      temp.push(sum);
      sum = 0;
    }
    // answer 배열에 temp 배열 push하고 temp 배열 초기화
    answer.push(temp);
    temp = [];
  }
  return answer;
}
