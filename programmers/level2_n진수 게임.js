function solution(n, t, m, p) {
  let answer = "";
  let str = "";

  // 연속된 숫자를 n진법으로 변환, 대문자로 변환하여 str 문자열에 저장
  for (let i = 0; i < t * m; i++) {
    str += i.toString(n).toUpperCase();
  }

  for (let i = 0; i < t * m; i++) {
    // 만일 answer의 길이가 튜브가 말해야 하는 숫자 t 값과 같다면 반복문 빠져나가기
    if (answer.length === t) break;
    // p번째를 따로 뽑아서 answer 문자열에 해당 str[i] 값 저장
    if (i % m === p - 1) answer += str[i];
  }
  return answer;
}
