function solution(dartResult) {
  let answer = [];
  let num = 0;

  for (let i = 0; i < dartResult.length; i++) {
    // 만일 해당 dartResult[i] 값이 숫자라면
    if (!isNaN(dartResult[i])) {
      // 만일 해당 점수가 10점이라면
      if (dartResult[i] === "1" && dartResult[i + 1] === "0") {
        // num 변수에 10 저장
        num = 10;
        // 다음 값도 같이 계산했으므로 i+1
        i++;
      }
      // 만일 0-9 점수라면
      else {
        // num 변수에 해당 dartResult[i] 값 저장
        num = dartResult[i];
      }
    }

    // 만일 Single 영역이라면 answer 배열에 num의 1제곱 값을 push
    else if (dartResult[i] === "S") {
      answer.push(num);
    }
    // 만일 Double 영역이라면 answer 배열에 num의 2제곱 값을 push
    else if (dartResult[i] === "D") {
      answer.push((num **= 2));
    }
    // 만일 Triple 영역이라면 answer 배열에 num의 3제곱 값을 push
    else if (dartResult[i] === "T") {
      answer.push((num **= 3));
    }
    // 만일 스타상이라면 answer 배열에서
    // 현재 점수(마지막)와 직전 점수(마지막 직전) 값을 각 2배로 만듬
    else if (dartResult[i] === "*") {
      answer[answer.length - 1] *= 2;
      answer[answer.length - 2] *= 2;
    }
    // 만일 아차상이라면 answer 배열에서 현재 점수(마지막) 값을 마이너스로 만듬
    else if (dartResult[i] === "#") {
      answer[answer.length - 1] *= -1;
    }
  }

  // 점수 합계를 위한 sum 변수
  let sum = 0;
  // answer 배열을 순회하면서 해당 값을 숫자로 변환시켜 sum 변수에 합산
  for (let i of answer) {
    sum += Number(i);
  }
  return sum;
}
