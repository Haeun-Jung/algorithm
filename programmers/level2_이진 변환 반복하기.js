function solution(s) {
  const answer = [0, 0];
  transfrom(s, answer);
  return answer;
}

function transfrom(s, answer) {
  // s 값에서 0 제거
  const changeZero = s.replace(/0/g, "");
  // 회차 추가
  answer[0]++;
  // 기존 s 값의 길이에서 0을 제거한 값의 길이를 빼면 제거한 0의 갯수
  answer[1] += s.length - changeZero.length;
  // 0 제거 후 길이
  const len = changeZero.length;
  // len 값이 1이 아니라면 2진 변환해서 다시 함수 실행
  if (len !== 1) {
    transfrom(len.toString(2), answer);
  }
}
