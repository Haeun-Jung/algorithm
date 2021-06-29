function solution(clothes) {
  let answer = 1;
  // 중복되는 의상을 처리하기 위한 객체 선언
  let obj = {};

  clothes.forEach(function (element) {
    // 중복되는 key 값이 존재하면 + 1
    if (obj[element[1]] >= 1) {
      obj[element[1]]++;
    }
    // 처음 등장하는 의상일 때 1로 초기화
    else {
      obj[element[1]] = 1;
    }
  });

  // 의상을 안 입는 경우를 고려해 + 1
  for (let i in obj) {
    answer *= obj[i] + 1;
  }
  // 아무것도 안 입는 경우를 제외 - 1
  return answer - 1;
}
