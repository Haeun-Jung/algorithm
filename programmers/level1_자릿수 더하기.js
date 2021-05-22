function solution(n) {
  let answer = 0;
  // n을 문자열로 변환시켜 str 변수에 저장
  let str = String(n);
  // str 문자를 하나씩 돌며 숫자로 변환시켜 answer 변수에 더하기
  for (let i = 0; i < str.length; i++) {
    answer += Number(str[i]);
  }
  return answer;
}
