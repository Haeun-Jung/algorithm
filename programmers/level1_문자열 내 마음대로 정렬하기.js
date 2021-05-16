function solution(strings, n) {
  // n번째 인덱스 문자가 같다면, 문자열을 기준으로 사전순으로 정렬
  // n번째 인덱스 문자가 같지 않다면, n번째 인덱스 문자를 기준으로 사전순으로 정렬
  return strings.sort((s1, s2) =>
    s1[n] === s2[n] ? s1.localeCompare(s2) : s1[n].localeCompare(s2[n])
  );
}

// localeCompare()

// "c"는 "a"의 뒤에 오기 때문에 음수 값을 리턴
// 'a'.localeCompare('c');

// 알파벳 순으로 "against"는 "check"의 앞에 오기 때문에 양수 값을 리턴
// 'check'.localeCompare('against');

// "a"는 "a"와 같기 때문에 0
// 'a'.localeCompare('a');
