function solution(a, b) {
  // 요일을 담은 배열 생성
  let arr = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"];
  // 2016년 a월 b일 날짜를 담은 변수 선언
  let day = new Date(`2016-${a}-${b}`);

  // day 변수에서 요일을 지칭하는 숫자를 가져와 해당 요일을 arr배열에서 찾기
  return arr[day.getDay()];
}
