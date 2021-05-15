function solution(s) {
  // 'p'와 'y'의 개수가 같은지 비교하기 위한 변수
  let num = 0;
  // 문자열 s를 소문자로 변환하여 한글자씩 탐색
  for (let i of s.toLowerCase()) {
    // 만약 문자가 'p'일 때 num++
    if (i === "p") {
      num++;
    }
    // 만약 문자가 'y'일 때 num--
    else if (i === "y") {
      num--;
    }
  }
  // 'p'와 'y'의 개수가 같다면 num은 0이므로 true를 반환
  // 'p'와 'y'의 개수가 같지 않다면 false를 반환
  return num === 0;
}
