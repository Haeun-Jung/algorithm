function solution(answers) {
  let answer = [];
  // 수포자가 찍는 방식
  let obj = [
    [1, 2, 3, 4, 5],
    [2, 1, 2, 3, 2, 4, 2, 5],
    [3, 3, 1, 1, 2, 2, 4, 4, 5, 5],
  ];
  // 수포자들의 점수를 담을 배열
  let cnt = [0, 0, 0];

  // 정답(answers) 배열을 순회하면서
  for (let i in answers) {
    // 1번 수포자가 맞으면 cnt[0] + 1
    if (answers[i] === obj[0][i % 5]) {
      cnt[0]++;
    }
    // 2번 수포자가 맞으면 cnt[1] + 1
    if (answers[i] === obj[1][i % 8]) {
      cnt[1]++;
    }
    // 3번 수포자가 맞으면 cnt[2] + 1
    if (answers[i] === obj[2][i % 10]) {
      cnt[2]++;
    }
  }

  // cnt 배열 요소중에서 최댓값 찾기
  let max = Math.max(...cnt);

  // cnt 배열을 순회하며 최댓값 max와 값이 같은 경우 answer 배열에 인덱스+1 값을 push
  for (let i = 0; i < cnt.length; i++) {
    if (max === cnt[i]) {
      answer.push(i + 1);
    }
  }
  return answer;
}
