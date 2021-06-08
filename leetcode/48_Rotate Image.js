function rotate(matrix) {
  let answer = [];
  for (let i = 0; i < matrix[0].length; i++) {
    for (let j = i + 1; j < matrix[i].length; j++) {
      // matrix[i][j] 값과 matrix[j][i] 값 바꾸기
      let temp = matrix[j][i];
      matrix[j][i] = matrix[i][j];
      matrix[i][j] = temp;
    }
  }
  // matrix[i] 배열 순서 반전시키기
  for (let i = 0; i < matrix[0].length; i++) {
    matrix[i].reverse();
  }
  return matrix;
}
