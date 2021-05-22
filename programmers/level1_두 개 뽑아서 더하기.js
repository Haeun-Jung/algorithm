function solution(numbers) {
  let answer = [];
  // 이중 for문으로 numbers 값들을 더하기
  for (let i = 0; i < numbers.length - 1; i++) {
    for (let j = i + 1; j < numbers.length; j++) {
      // 서로 다른 인덱스에 있는 두개의 수를 더하기
      let k = numbers[i] + numbers[j];
      // 만일 answer배열에 k값이 없다면
      if (!answer.includes(k)) {
        // answer 배열에 k값 push
        answer.push(k);
      }
    }
  }
  // answer 배열 요소를 오름차순으로 정렬하여 반환
  return answer.sort((a, b) => a - b);
}
