function solution(seoul) {
  // seoul 배열의 인덱스 값을 도는 for문
  for (let i in seoul) {
    // 만약 seoul[i] 값이 'Kim'이라면
    if (seoul[i] === "Kim") {
      // 해당 인덱스 값 i를 포함하여 String을 반환
      return `김서방은 ${i}에 있다`;
    }
  }
}
