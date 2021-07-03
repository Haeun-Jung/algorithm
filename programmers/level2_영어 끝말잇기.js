function solution(n, words) {
  // 끝말잇기를 성공적으로 끝낼 시 [0, 0] 반환
  let answer = [0, 0];
  let stack = [];

  // stack 배열에 첫번째 단어 push
  stack.push(words[0]);

  // 끝말잇기 참여
  for (let i = 1; i < words.length; i++) {
    // 직전 단어
    let beforeWord = words[i - 1];
    // 현재 단어
    let currentWord = words[i];
    // 만일 stack에 현재 단어가 없고 직전 단어의 끝 단어와 현재 단어의 시작 단어가 일치할 때
    if (
      !stack.includes(currentWord) &&
      beforeWord[beforeWord.length - 1] === currentWord[0]
    ) {
      // 현재 단어를 stack에 push
      stack.push(currentWord);
    }

    // 탈락자 발생시
    else {
      // 가장 먼저 탈락하는 사람의 번호와 몇 번째 차례인지를 구하여 반환
      answer = [(i % n) + 1, parseInt(i / n) + 1];
    }
  }
  return answer;
}
