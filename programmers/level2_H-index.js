function solution(citations) {
  let answer = 0;
  // 논문의 인용 횟수를 내림차순으로 정렬
  citations.sort((a, b) => b - a);

  // 논문 인용 횟수를 하나씩 탐색하면서, n회 이상 인용된 논문이 n개 보다 같거나 클 때를 구하기
  while (answer + 1 <= citations[answer]) {
    answer++;
  }
  return answer;
}
