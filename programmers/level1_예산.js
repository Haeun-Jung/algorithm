function solution(d, budget) {
  let answer = 0;
  // 최대한 많은 부서에 물품을 지원하기 위해 d 배열을 오름차순으로 정렬
  d.sort((a, b) => a - b);

  for (let i = 0; i < d.length; i++) {
    // 예산에서 해당 값 d[i] 빼기
    budget -= d[i];
    // 만일 예산이 - 라면
    if (budget < 0) {
      // answer 값 반환
      return answer;
    }
    // 만일 예산이 남았다면
    else {
      // 지원 가능
      answer++;
    }
  }
  return answer;
}
