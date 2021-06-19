function solution(s) {
  // s 값을 쪼개서 정렬시킨뒤 뒤집어 join시킨 값을 반환
  return s.split("").sort().reverse().join("");
}
