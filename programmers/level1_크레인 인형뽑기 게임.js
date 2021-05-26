function solution(board, moves) {
  let answer = 0;
  // 바구니 stack
  let stack = [];

  // moves 값 하나씩 실행
  moves.forEach((pos) => {
    // 배열은 0부터 시작하므로 pos-1 값이 가리키는 열을 탐색
    for (let i = 0; i < board.length; i++) {
      // 인형을 발견하였을 때
      if (board[i][pos - 1] !== 0) {
        // tmp 변수에 해당 인형의 모양을 저장
        let tmp = board[i][pos - 1];
        // 인형을 집어 올렸으므로 해당 위치의 값을 0으로 저장
        board[i][pos - 1] = 0;
        // tmp 값이 바구니에 담긴 마지막 인형과 같다면
        if (tmp === stack[stack.length - 1]) {
          // 인형 두개가 터트려져 사라졌으므로 answer에 2를 더하기
          answer += 2;
          // 바구니에 있던 인형이 터졌으므로 pop();
          stack.pop();
        }
        // tmp 값이 바구니에 담긴 마지막 인형과 다르다면
        else {
          // 바구니에 해당 인형을 담기
          stack.push(tmp);
        }
        // 인형을 집었으므로 다음 pos로 이동
        break;
      }
    }
  });
  return answer;
}
