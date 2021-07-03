function solution(s) {
  let answer = [];

  s.slice(2, -2) // 괄호 제거
    .split("},{") // 괄호를 기준으로 나누어 배열 생성
    .map((str) => str.split(",").map(Number)) // 요소를 숫자로 변환시켜 새로운 배열로 반환
    .sort((a, b) => a.length - b.length) // 요소의 길이를 기준으로 오름차순 정렬
    // 배열의 요소를 반복하여 작업 수행
    .forEach((arr) => {
      // 배열의 요소를 반복하여 작업 수행
      arr.forEach((value) => {
        // 만일 answer 배열에 해당 요소가 없다면
        // 해당 요소를 answer 배열에 push
        if (!answer.includes(value)) answer.push(value);
      });
    });

  return answer;
}
