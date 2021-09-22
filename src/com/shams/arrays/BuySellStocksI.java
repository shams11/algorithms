/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * */
package com.shams.arrays;

public class BuySellStocksI {
  public static void main(String[] args) {
    //Input: prices = [7,1,5,3,6,4]
    //Output: 5
    //Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    //Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
    int[] a = {7, 1, 5, 3, 6, 4};
    System.out.println(maxProfit(a));
  }

  public static int maxProfit(int[] prices) {
    int min = prices[0];
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < min) {
        min = prices[i];
      } else {
        int curProfit = prices[i] - min;
        maxProfit = Math.max(curProfit, maxProfit);
      }
    }
    return maxProfit;
  }
}
