function solution(s) {
  let len = s.length;
  let arr = [];

  for (let i = 0; i < len; i++) {
    let n = i + 1;
    let newStr = "";
    let count = 1;

    for (let j = 0; j < len; j += n) {
      // 현재 문자열과 다음 문자열이 같으면 count + 1
      let currentStr = s.substring(j, j + n);
      let nextStr = s.substring(j + n, j + n + n);
      if (currentStr === nextStr) {
        count++;
      }
      // 현재 문자열과 다음 문자열이 다르다면
      // 기존에 같은 문자열이 있었다면 count 수와 함께 현재 문자열을 새로운 문자열에 저장
      // 기존에 같은 문자열이 없었다면 현재 문자열을 새로운 문자열에 저장
      // count 변수 1로 초기화
      else {
        newStr += count > 1 ? count + currentStr : currentStr;
        count = 1;
      }
    }
    // 새로운 문자열의 길이를 arr 배열에 push
    arr.push(newStr.length);
  }
  // arr 배열에서 가장 값이 작은 요소를 반환
  return Math.min(...arr);
}
