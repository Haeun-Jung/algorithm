var maxProfit = function (prices) {
  // 최대 수익을 계산할 변수
  let profit = 0;
  // 주식을 구매하는 날(최소 가격으로 구매)
  let min = prices[0];

  // 주식을 구매한 날을 제외하고 인덱스 1부터 for문 시작
  for (let i = 1; i < prices.length; i++) {
    // 현재 prices[i] 값과 min에 담긴 값 중 더 적은 값을 변수에 저장
    min = Math.min(min, prices[i]);
    // 현재 prices[i] 값에서 min값을 뺐을 때 가장 큰 값을 변수에 저장
    profit = Math.max(profit, prices[i] - min);
  }

  return profit;
};
