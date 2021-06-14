function solution(s) {
  let answer = true;
  let n = 0;
  for (let i of s) {
    if (i === "(") {
      n++;
    } else {
      n--;
    }
    // 반복문 안에서 ')'가 더 많이 나온다면 이미 짝이 아니므로 false 반환
    if (n === -1) {
      return false;
    }
  }
  // '('와 ')'의 갯수가 같다면 answer(=true) 반환
  if (n === 0) {
    return answer;
  } // '('와 ')'의 갯수가 다르면 false 반환
  else {
    return false;
  }
}
