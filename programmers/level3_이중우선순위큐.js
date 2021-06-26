function solution(operations) {
  let answer = [];

  for (let i = 0; i < operations.length; i++) {
    // 명령어가 I라면
    if (operations[i][0] === "I") {
      // answer 배열에 데이터를 숫자로 변환하여 push
      answer.push(Number(operations[i].slice(2)));
      // answer 배열의 요소를 오름차순으로 저장
      answer.sort((a, b) => a - b);
    }
    // 명령어가 D라면
    else {
      // 만일 비어있는 큐라면 연산 무시
      if (operations.length === 0) continue;
      // 명령어가 최댓값 삭제라면
      else if (operations[i][2] === "1") {
        answer.pop();
      }
      // 명령어가 최솟값 삭제라면
      else {
        answer.shift();
      }
    }
  }
  if (answer.length === 0) return [0, 0];
  else return [answer[answer.length - 1], answer[0]];
}
