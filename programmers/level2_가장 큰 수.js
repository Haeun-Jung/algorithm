function solution(numbers) {
  // numbers 배열의 요소를 조합하여 내림차순으로 정렬 후 join
  let answer = numbers.sort((a, b) => `${b}${a}` - `${a}${b}`).join("");
  // answer의 처음 값이 0이면 0 반환, 아니면 answer 값 반환
  return answer[0] === "0" ? "0" : answer;
}
