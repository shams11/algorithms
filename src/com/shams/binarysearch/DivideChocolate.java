/***
 * https://leetcode.com/problems/divide-chocolate/
 * https://www.youtube.com/watch?v=Ppy9lvyMnuc&ab_channel=MichaelMuinos
 * */

package com.shams.binarysearch;

import java.util.Arrays;

public class DivideChocolate {
 /**
  * You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the array sweetness.
  *
  * You want to share the chocolate with your K friends so you start cutting the chocolate bar into K+1 pieces
  * using K cuts, each piece consists of some consecutive chunks.
  *
  * Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your friends.
  *
  * Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.
  *
  * Example 1:
  * Input: sweetness = [1,2,3,4,5,6,7,8,9], K = 5
  * Output: 6
  * Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]
  *
  * Example 2:
  * Input: sweetness = [5,6,7,8,9,1,2,3,4], K = 8
  * Output: 1
  * Explanation: There is only one way to cut the bar into 9 pieces.
  *
  * Example 3:
  * Input: sweetness = [1,2,2,1,2,2,1,2,2], K = 2
  * Output: 5
  * Explanation: You can divide the chocolate to [1,2,2], [1,2,2], [1,2,2]
  *
  * Constraints:
  * 0 <= K < sweetness.length <= 10^4
  * 1 <= sweetness[i] <= 10^5
  *
  * */
  public static void main(String[] args) {
//    int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//    int k = 5;
    // Output: 6
    // Explanation : you can divide the chocolate into [1, 2,3] [4, 5] [6] [7] [8] [9]

    int[] a = {1, 2, 2, 1, 2, 2, 1, 2, 2};
    int k = 2;
    //Output :5
    // Explanation : you can divide the chocolate into [1, 2, 2] [1, 2, 2] [1, 2, 2]
    System.out.println(calMaxTotalSweetness(a, k));
  }

  private static int calMaxTotalSweetness(int[] a, int k) {
    int start = 1, end = Arrays.stream(a).sum() / (k + 1);
    int res = -1, mid;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (isSchemeValid(a, k, mid)) {
        res = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return res;
  }

  private static boolean isSchemeValid(int[] a, int k, int mid) {
    int friendCount = 0, sweetnessCount = 0;
    for (int i = 0; i < a.length; i++) {
      sweetnessCount += a[i];
      if (sweetnessCount > mid) {
        friendCount++;
        sweetnessCount = a[i];
      }
      if (friendCount > k + 1) {
        return false;
      }
    }
    return true;
  }
}
