/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/submissions/
 * */
package com.shams.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsWithSmallestSums {
  public static void main(String[] args) {
    // Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
    //Output: [[1,2],[1,4],[1,6]]
    //Explanation: The first 3 pairs are returned from the sequence:
    // [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
    int[] nums1 = {1, 7, 11};
    int[] nums2 = {2, 4, 6};
    int k = 3;
    System.out.println(kSmallestPairs(nums1, nums2, k));
  }

  public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    PriorityQueue<int[]> pq = new  PriorityQueue<>(
        (a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
    int n = nums1.length;
    for(int i = 0; i < k && i < n; i++) {
      pq.offer(new int[]{nums1[i], nums2[0], 0});
    }
    List<List<Integer>> result = new ArrayList<>();
    while(k-- > 0 && !pq.isEmpty()) {
      int[] cur = pq.poll();
      List<Integer> list = new ArrayList<>();
      list.add(cur[0]);
      list.add(cur[1]);
      result.add(list);
      if(cur[2] == nums2.length -1) continue;
      pq.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
    }
    return result;
  }
}
