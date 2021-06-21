function solution(priorities, location) {
  // 인쇄를 요청한 문서를 문자 타입으로 저장
  priorities[location] = priorities[location].toString();
  let answer = 0;

  // priorities 배열을 다 탐색할 때까지
  while (priorities.length) {
    // target 변수에 priorities 배열의 첫번째 요소를 저장
    let target = priorities.shift();
    let flag = true;
    // priorities 배열 요소를 탐색하며 target 값과 비교
    for (let item of priorities) {
      // 만일 해당 값 item이 target 값보다 크다면
      if (item > target) {
        // priorities 배열에 target 값을 push하고 반복문 빠져나가기
        priorities.push(target);
        flag = false;
        break;
      }
    }
    // 만일 flag 값이 false라면 다음 순회로 반복문 넘어가기
    if (flag == false) continue;
    // 순서 + 1
    answer++;
    // 만일 target의 타입이 문자열이라면
    if (typeof target == "string") {
      // answer 값 반환
      return answer;
    }
  }
  return answer;
}
