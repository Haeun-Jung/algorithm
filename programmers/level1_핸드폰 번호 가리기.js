function solution(phone_number) {
  let answer = "";

  // phone_number의 인덱스를 돌면서 answer 값에 더하기
  for (let i = 0; i < phone_number.length; i++) {
    // 만일 i 인덱스가 phone_number 값의 뒷 4자리보다 앞이라면 '*' 넣기
    // 만일 i 인덱스가 phone_number 값의 뒷 4자리라면 해당 값 phone_number[i] 넣기
    answer += i < phone_number.length - 4 ? "*" : phone_number[i];
  }
  return answer;
}
