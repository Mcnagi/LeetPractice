package problems;

public class Q1475FinalPricesDiscount {
  public int[] finalPrices(int[] prices) {
    if (prices.length == 1) return prices;
    int[] indices = new int[prices.length];
    int[] discount = new int[prices.length];
    int[] result = prices.clone();
    discount[prices.length - 1] = 0;
    result[prices.length - 1] = prices[prices.length - 1];
    for (int i = prices.length - 2; i >= 0; i--) {
      int j = i + 1;
      if (prices[i] >= prices[j]) {
        indices[i] = j;
        discount[i] = prices[j];
        result[i] -= discount[i];
      } else if (discount[j] != 0) {
        if (prices[i] >= discount[j]) {
          discount[i] = discount[j];
          result[i] -= discount[i];
          indices[i] = indices[j];
        } else {
          j = indices[j] + 1;
          while (j < prices.length) {
            if (prices[i] >= prices[j]) {
              discount[i] = prices[j];
              indices[i] = j;
              break;
            }
            j++;
          }
          result[i] -= discount[i];
        }
      }
    }
    return result;
  }
}
