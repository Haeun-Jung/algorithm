function solution(progresses, speeds) {
  let answer = [];

  // 작업을 다 완료할 때까지
  while (progresses.length > 0) {
    // 각 작업의 개발 속도
    for (let i in speeds) {
      // 만일 작업 진도가 다 완료되지 않았다면
      // 해당 작업의 개발 속도 추가
      if (progresses[i] < 100) {
        progresses[i] += speeds[i];
      }
    }

    // 같이 배포되는 작업의 갯수
    let count = 0;
    // 기존 작업이 완료되어 있을 때마다
    while (progresses[0] >= 100) {
      // 배포 작업 갯수+1
      count++;
      // 배포된 작업 제외시키기
      progresses.shift();
      // 배포된 작업에 대응하는 속도 제외시키기
      speeds.shift();
    }

    // 만일 배포된 작업이 있다면
    // 배포된 작업 갯수를 answer 배열에 push
    if (count > 0) {
      answer.push(count);
    }
  }
  return answer;
}
