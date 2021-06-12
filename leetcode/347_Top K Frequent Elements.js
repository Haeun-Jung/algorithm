function topKFrequent(nums, k) {
  let map = new Map();
  for (let v of nums) {
    // 만일 map이 v key값을 가지고 있지 않다면
    if (!map.has(v)) {
      // 해당 v key값의 value를 1로 지정
      map.set(v, 1);
    } // 만일 map이 v key값을 가지고 있다면
    else {
      // 해당 v key값의 value + 1
      map.set(v, map.get(v) + 1);
    }
  }
  let arr = [];
  for (let [key, value] of map) {
    arr.push([key, value]);
  }
  // value값이 큰 순서대로 정렬
  arr.sort((a, b) => b[1] - a[1]);
  let result = [];
  for (let i = 0; i < k; i++) {
    // result 배열에 key 값을 k개만큼 push
    result.push(arr[i][0]);
  }
  return result;
}
