function solution(skill, skill_trees) {
  let cnt = 0;

  for (let i = 0; i < skill_trees.length; i++) {
    let idx = 0;
    let isTrue = true;

    for (let j = 0; j < skill_trees[i].length; j++) {
      // 만일 skill에 해당 값 skill_trees[i][j]이 있다면
      if (skill.includes(skill_trees[i][j])) {
        // 선행 스킬 순서를 파악하기 위한 조건문
        if (skill[idx] === skill_trees[i][j]) {
          // 순서를 만족한다면 다음 스킬 파악하기
          idx++;
        } // 선행 스킬 순서와 맞지 않다면
        else {
          // for문 빠져나가기
          isTrue = false;
          break;
        }
      }
    }
    // 만일 스킬트리가 적합하다면 갯수 + 1
    if (isTrue) {
      cnt++;
    }
  }
  return cnt;
}
