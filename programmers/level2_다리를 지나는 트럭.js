function solution(bridge_length, weight, truck_weights) {
  // 시간 소요를 나타낼 변수
  let answer = 0;
  // 다리에 올라간 트럭을 저장할 배열
  let bridge = [];
  // 다리가 견디고 있는 현재 무게를 저장할 변수
  let bridge_weight = 0;

  // 모든 트럭이 다리를 건널 때까지
  while (truck_weights.length) {
    // 1초 소요
    answer++;
    // 만일 현재 다리에 존재하는 트럭 수 bridge.length 값과
    // 다리에 올라갈 수 있는 트럭 수 bridge_length 값이 같다면
    if (bridge.length === bridge_length) {
      // 다리의 현재 무게 bridge_weight 값에
      // 현재 다리에 존재하는 트럭 bridge 배열에서 가장 먼저 다리를 올라간 트럭 무게를 빼기
      bridge_weight -= bridge.shift();
    }
    // 만일 다리의 현재 무게 bridge_weight 값과 트럭의 무게(제일 앞에 있는 값) truck_weights[0]을 합친 값이
    // 다리가 견딜 수 있는 무게 weight 값보다 크다면
    if (bridge_weight + truck_weights[0] > weight) {
      // bridge 배열에 0 push(더 이상 다리에 트럭이 지나갈 수 없음)
      bridge.push(0);
      // 다음 순회로 넘어감
      continue;
    }

    // bridge 배열에 트럭의 무게(제일 앞에 있는 값) truck_weights[0]을 push
    bridge.push(truck_weights[0]);
    // 다리의 현재 무게 bridge_weight에 트럭의 무게(제일 앞에 있는 값) truck_weights[0]을 더하기
    bridge_weight += truck_weights.shift();
  }

  // 모든 트럭이 다리를 지나야 하기 때문에
  // 다리에 올라갈 수 있는 트럭 수 bridge_length 값을 소요시간 answer 값에 더하기
  answer += bridge_length;
  return answer;
}
