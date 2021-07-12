function solution(numbers, hand) {
  let answer = "";
  // 가운데 키패드
  let center = [2, 5, 8, 11];
  // 왼손 엄지손가락은 * 키패드에서 시작
  let recentL = 10;
  // 오른손 엄지손가락은 # 키패드에서 시작
  let recentR = 12;
  // 왼손과 오른손의 위치를 비교하기 위한 변수
  let distL = 0;
  let distR = 0;

  for (let i = 0; i < numbers.length; i++) {
    // 현재 키패드 값
    let val = numbers[i];

    // 만일 숫자 0을 입력했다면 현재 위치는 11
    if (numbers[i] === 0) val = 11;

    // 만일 왼쪽 키패드를 입력했다면
    // 왼손으로 누르기 answer 값에 'L' 추가
    // 왼손의 위치는 현재 키패드 val 값
    if (val === 1 || val === 4 || val === 7) {
      answer += "L";
      recentL = val;
    }

    // 만일 오른쪽 키패드를 입력했다면
    // 오른손으로 누르기 answer 값에 'R' 추가
    // 오른손의 위치는 현재 키패드 val 값
    else if (val === 3 || val === 6 || val === 9) {
      answer += "R";
      recentR = val;
    }

    // 만일 가운데 키패드를 입력했다면
    // 최근 왼손과 오른손의 위치에서 현재 키패드의 위치 계산
    else {
      distL =
        center.indexOf(recentL) !== -1
          ? Math.abs(val - recentL) / 3
          : Math.abs(val - 1 - recentL) / 3 + 1;
      distR =
        center.indexOf(recentR) !== -1
          ? Math.abs(val - recentR) / 3
          : Math.abs(val + 1 - recentR) / 3 + 1;

      // 만일 왼손 거리와 오른손 거리가 같다면
      if (distL === distR) {
        // 만일 왼손잡이라면
        if (hand === "left") {
          answer += "L";
          recentL = val;
        }
        // 만일 오른손잡이라면
        else {
          answer += "R";
          recentR = val;
        }
      }

      // 만일 왼손이 오른손보다 가깝다면
      else if (distL < distR) {
        answer += "L";
        recentL = val;
      }
      // 만일 오른손이 왼손보다 가깝다면
      else {
        answer += "R";
        recentR = val;
      }
    }
  }
  return answer;
}
