function solution(N, stages) {
  let answer = [];
  // 멈춰있는 모든 플레이어 수
  let people = stages.length;

  for (let i = 1; i <= N; i++) {
    // 해당 레벨에 멈춰있는 플레이어 수
    let tmp = stages.filter((n) => n === i).length;
    // 스테이지와 실패율을 answer 배열에 push
    answer.push([i, tmp / people]);
    // 현재 멈춰있는 플레이어 제외
    people -= tmp;
  }
  // 실패율을 기준으로 내림차순으로 정렬
  answer = answer.sort((a, b) => b[1] - a[1]);
  // 스테이지 반환
  return answer.map((a) => a[0]);
}
