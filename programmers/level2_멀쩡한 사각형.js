function solution(w, h) {
  /*
    대각선이 지나가는 단위 정사각형의 개수를 구하는 공식
    w + h - (w과 h의 최대공약수)
  */

  let min = Math.min(w, h);
  // 최대공약수 변수
  let gcd = 0;

  // 반복문으로 최대공약수 구하기
  for (let i = min; i > 0; i--) {
    if (w % i === 0 && h % i === 0) {
      gcd = i;
      break;
    }
  }

  // 전체 면적에서 단위 정사각형의 개수를 빼서 반환
  return w * h - (w + h - gcd);
}
