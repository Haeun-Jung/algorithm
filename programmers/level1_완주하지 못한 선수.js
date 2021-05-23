function solution(participant, completion) {
  // 마라톤에 참여한 선수와 완주한 선수들을 정렬시켜 순차적으로 비교하기
  participant.sort();
  completion.sort();

  // 참여한 선수 배열을 기준으로 인덱스 돌기
  for (let i in participant) {
    // 만일 i 인덱스에 위치한 참여한 선수의 이름과 완주한 선수의 이름이 다르다면
    if (completion[i] !== participant[i]) {
      // 해당 선수의 이름 반환
      return participant[i];
    }
  }
}
