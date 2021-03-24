/***
 * https://www.youtube.com/watch?v=TfQPoaRDeMQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=9&ab_channel=AdityaVerma
 * https://www.geeksforgeeks.org/longest-sub-array-sum-k/
 * */

package com.shams.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaxLenSubArrayOfSizeK {

  public static void main(String args[]) {
//    int[] a = {10, 5, 2, 7, 1, 9};
//    int k = 15;
    // Output : 4

    // Output : 5
    int[] a = {-5, 8, -14, 2, 4, 12};
    int k = -5;
    int n = a.length;
    System.out.println("Length = " + lenOfLongestSubArray(a, n, k));
  }

  private static int lenOfLongestSubArray(int[] a, int n, int k) {
    int sum = 0, max = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      sum += a[i];

      if (sum == k) {
        max = i + 1;
      }
      if (!map.containsKey(sum)) {
        map.put(sum, i);
      }
      if (map.containsKey(sum - k)) {
        max = Math.max(max, i - map.get(sum - k));
      }
    }
    return max;
  }
}
