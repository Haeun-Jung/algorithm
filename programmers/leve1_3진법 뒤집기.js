function solution(n) {
  // 입력받은 수를 3진법으로 변환하여 num변수에 저장
  let num = n.toString(3);
  // 3진법으로 변환된 수를 앞뒤 반전시켜 다시 num변수에 저장
  num = num.split("").reverse().join("");

  // num변수를 정수로 변환하여 return하기
  return Number.parseInt(num, 3);
}
