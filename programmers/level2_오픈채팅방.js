function solution(record) {
  let answer = [];
  let strObj = {};
  // record 값을 ' '을 기준으로 나눠 배열 반환
  let newArr = record.map((str) => str.split(" "));

  for (let i = 0; i < newArr.length; i++) {
    // 만일 newArr[i]의 길이가 3이라면 해당 아이디 요소에 닉네임 저장
    if (newArr[i].length === 3) {
      strObj[newArr[i][1]] = newArr[i][2];
    }
  }

  for (let i = 0; i < newArr.length; i++) {
    // newArr[i][0] 값이 Enter라면 answer 배열에 해당 유저가 들어왔다고 push
    if (newArr[i][0] === "Enter") {
      answer.push(strObj[newArr[i][1]] + "님이 들어왔습니다.");
    }
    // newArr[i][0] 값이 Leave라면 answer 배열에 해당 유저가 나갔다고 push
    else if (newArr[i][0] === "Leave") {
      answer.push(strObj[newArr[i][1]] + "님이 나갔습니다.");
    }
  }
  return answer;
}
