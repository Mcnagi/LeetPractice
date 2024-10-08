package problems.other;

public class Q0122BestTimeStockII {
  // 1, 10
  // 1, 3, 2, 10
  public int maxProfit(int[] prices) {
    int result = 0;
    for (int i = 1; i < prices.length; i++)
      if (prices[i] > prices[i - 1]) result += prices[i] - prices[i - 1];

    return result;
  }
}
