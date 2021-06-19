function solution(n, arr1, arr2) {
  const answer = [];
  for (let i = 0; i < n; i++) {
    let result = "";
    // 지도 한 변 크기(n)에서 해당 값을 2진법으로 변환 값의 길이를 뺀 나머지를 0으로 채운 후
    // 나머지는 2진법으로 변환 한 값으로 더하기
    let b1 = "0".repeat(n - arr1[i].toString(2).length) + arr1[i].toString(2);
    let b2 = "0".repeat(n - arr2[i].toString(2).length) + arr2[i].toString(2);

    for (let j = 0; j < n; j++) {
      // 만일 b1[j]이나 b2[j] 값 둘 중 하나라도 '1'이면 #을 더하고
      // 두개의 값 모두 '1'이 아니라면 여백 더하기
      result += b1[j] === "1" || b2[j] === "1" ? "#" : " ";
    }
    answer.push(result);
  }
  return answer;
}
