function solution(brown, yellow) {
  /*
    brown = ( 가로 + 세로 - 2 )* 2
    yellow = ( 가로 * 세로 - brown)
  */

  let sum = brown / 2 + 2;
  for (let len = 1; len * 2 <= sum; len++) {
    if (len * (sum - len) - brown === yellow) {
      return [sum - len, len];
    }
  }
}
