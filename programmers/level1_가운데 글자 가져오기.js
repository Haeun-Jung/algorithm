function solution(s) {
  let answer = "";
  let len = s.length;
  let half = len / 2;

  // 단어 s의 길이가 짝수라면
  // s의 중간단어 2개 추출
  if (len % 2 === 0) {
    answer = s.slice(half - 1, half + 1);
  }
  // 단어 s의 길이가 홀수라면
  // s의 중간단어 1개 추출
  else {
    answer = s.slice(Math.floor(half), Math.floor(half) + 1);
  }
  return answer;
}
