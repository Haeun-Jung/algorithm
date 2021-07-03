function solution(absolutes, signs) {
  let result = 0;
  // 배열 하나씩 비교
  for (let i = 0; i < signs.length; i++) {
    // signs[i]에 해당하는 값이 true이면 absolutes[i]값을 result값에 더해주기
    // signs[i]에 해당하는 값이 false absolutes[i]값을 result값에 빼주기
    signs[i] ? (result += absolutes[i]) : (result -= absolutes[i]);
  }
  return result;
}
