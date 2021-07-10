function solution(s) {
  // 팰린드롬의 길이를 탐색하기 위한 반복문
  for (let i = s.length; i >= 0; i--) {
    // 첫 인덱스부터 판별하기 위한 반복문
    for (let j = 0; j <= s.length - i; j++) {
      // 만일 s 문자열에서 j 인덱스부터 j + i 인덱스까지의 값이 팰린드롬이면 길이를 나타내는 i 값 반환
      if (isPalin(s.substring(j, j + i))) {
        return i;
      }
    }
  }
  // 팰린드롬이 없다면
  return 0;
}

// 팰린드롬 판별 함수
function isPalin(string) {
  // string 값을 순회하면서 팰린드롬인지 판별
  for (let i = 0; i < string.length / 2; i++) {
    // 만일 앞뒤를 뒤집어도 같은 수가 아니라면 false 반환
    if (string[i] !== string[string.length - i - 1]) {
      return false;
    }
  }
  // 앞뒤를 다 뒤집어도 같은 문자열이므로 true 반환
  return true;
}
