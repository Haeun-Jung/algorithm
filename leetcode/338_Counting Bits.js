function countBits(num) {
  let answer = [];
  for (let i = 0; i <= num; i++) {
    // i 값을 2진법으로 바꾼뒤 0을 공백으로 바꿔 1의 길이(갯수)를 answer 배열에 push
    answer.push(i.toString(2).replace(/0/g, "").length);
  }
  return answer;
}
