function solution(cacheSize, cities) {
  let answer = 0;
  let cache = new Set();

  for (let i in cities) {
    // cities 요소를 소문자로 통일
    const city = cities[i].toLowerCase();
    // 만일 cache Set에 해당 city를 가지고 있다면
    if (cache.has(city)) {
      // 실행시간 + 1
      answer++;
      // LRU이므로 해당 city를 삭제 후 다시 추가
      cache.delete(city);
      cache.add(city);
    }
    // 만일 cache Set에 해당 city를 가지고 있지 않다면
    else {
      // 실행시간 + 5
      answer += 5;
      // cache Set에 해당 city 추가
      cache.add(city);
      // 만일 캐시크기가 cache Set의 크기보다 작다면
      if (cacheSize < cache.size) {
        // 최근에 사용이 안된, 가장 오래된 요소 삭제
        cache.delete(cache.values().next().value);
      }
    }
  }
  return answer;
}
