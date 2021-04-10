/***
 * https://leetcode.com/problems/divide-chocolate/
 * https://www.youtube.com/watch?v=Ppy9lvyMnuc&ab_channel=MichaelMuinos
 * */

package com.shams.binarysearch;

import java.util.Arrays;

public class DivideChocolate {
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
