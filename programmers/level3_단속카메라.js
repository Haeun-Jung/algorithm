function solution(routes) {
  let answer = 0;
  // routes 배열을 진출 지점 기준으로 오름차순으로 정렬
  routes.sort((a, b) => a[1] - b[1]);
  // camera 초기값을 -30000보다 낮게 줌
  let camera = -30001;

  for (let i = 0; i < routes.length; i++) {
    // 만일 camera의 위치가 해당 요소의 진입 지점보다 이전에 있다면
    if (camera < routes[i][0]) {
      // camera를 설치해야하므로 answer+1
      answer++;
      // camera의 위치를 현재 위치로 지정
      camera = routes[i][1];
    }
  }
  return answer;
}
