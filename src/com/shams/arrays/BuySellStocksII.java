/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */

package com.shams.arrays;

public class BuySellStocksII {
  public static void main(String[] args) {
    // Input: prices = [7,1,5,3,6,4]
    //Output: 7
    //Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
    //Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
    int[] a = {7, 1, 5, 3, 6, 4};
    System.out.println(maxProfit(a));

  }

  public static int maxProfit(int[] prices) {
    int min = prices[0];
    int maxProfit = 0;
    int totalProfit = 0;
    boolean maxProfitChanged = false;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < min) {
        min = prices[i];
      } else {
        int curProfit = prices[i] - min;
        //maxProfit = Math.max(curProfit, maxProfit);
        if (curProfit > maxProfit) {
          maxProfit = curProfit;
          maxProfitChanged = true;
        }
        if (maxProfitChanged) {
          totalProfit += maxProfit;
          maxProfitChanged = false;
          min = prices[i];
          maxProfit = 0;
        }
      }
    }
    return totalProfit;
  }
}
