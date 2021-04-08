/***
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
 * https://www.youtube.com/watch?v=r3oiTXIINOU&ab_channel=NideeshTerapalli
 * */
package com.shams.arrays;

import java.util.HashMap;
import java.util.Map;

public class FindKDiffPairs {
  public static void main(String[] args) {
    int[] a = {3, 1, 4, 1, 5};
    int k = 2;
    //Output: 2
    //Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
    //Although we have two 1s in the input, we should only return the number of unique pairs.
    System.out.println(findPairs(a, k));
  }

  public static int findPairs(int[] nums, int k) {
    if (k < 0) {
      return 0;
    }
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
      if (k == 0 && map.get(e.getKey()) > 1) {
        count++;
      } else if (k > 0 && map.containsKey(e.getKey() + k)) {
        count++;
      }
    }
    return count;
  }
}
