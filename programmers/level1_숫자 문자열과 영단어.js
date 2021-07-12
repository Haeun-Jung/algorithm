function solution(s) {
  // 영단어가 적힌 배열
  let numbers = [
    "zero",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
  ];

  for (let i = 0; i < numbers.length; i++) {
    // s 문자열을 영단어 numbers[i] 기준으로 나눈 뒤
    // 대응하는 숫자로 join 시킨 뒤 s 값에 저장
    let arr = s.split(numbers[i]);
    s = arr.join(i);
  }
  // 숫자로 변환하여 반환
  return Number(s);
}
