function solution(n) {
  // n을 2진수로 변환하여 num1 변수에 저장
  let num1 = n.toString(2);
  // num1에서 1을 추출한 길이를 cnt1 변수에 저장
  let cnt1 = num1.match(/1/g).length;

  while (true) {
    // n을 증가시키며 같은 방식으로 1의 갯수를 추출
    n++;
    let num2 = n.toString(2);
    let cnt2 = num2.match(/1/g).length;
    // n에서 1을 추출한 갯수와 증가시킨 숫자의 1을 추출한 갯수가 같다면
    if (cnt1 === cnt2) {
      // 증가된 n을 반환
      return n;
    }
  }
}
