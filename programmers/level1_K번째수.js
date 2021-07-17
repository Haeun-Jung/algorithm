function solution(array, commands) {
  let answer = [];
  let arr;

  // commands 배열을 순회
  for (let i of commands) {
    // array 배열에서 원하는 위치를 slice
    arr = array.slice(i[0] - 1, i[1]);
    // arr을 오름차순으로 정렬
    arr.sort((a, b) => a - b);
    // arr 배열에서 특정 위치의 요소를 answer 배열에 push
    answer.push(arr[i[2] - 1]);
  }
  return answer;
}
