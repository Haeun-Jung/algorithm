function solution(left, right) {
  let answer = 0;

  // left부터 right까지 수의 약수의 갯수 구하기
  for (let i = left; i <= right; i++) {
    let cnt = 0;

    for (let j = 1; j <= i; j++) {
      if (i % j === 0) {
        cnt++;
      }
    }
    // 만일 약수의 갯수가 짝수라면 answer 변수에 해당 i 값 더하기
    if (cnt % 2 === 0) {
      answer += i;
    }
    // 만일 약수의 갯수가 홀수라면 answer 변수에 해당 i 값 빼기
    else {
      answer -= i;
    }
  }
  return answer;
}
