/**
 * https://www.youtube.com/watch?v=xFJXtB5vSmM&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=6&ab_channel=AdityaVerma
 * https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
 * 22-Mar-2021:10:23 PM
 */

package com.shams.slidingwindow;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MaxOfAllSubArraysOfSizeK {
  public static void main(String[] args) {
   // int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
    // Output : 3, 3, 5, 5, 6, 7

//    int[] a  = {1, 2, 3, 1, 4, 5, 2, 3, 6};
//    // Output : Output: 3 3 4 5 5 5 6
//    int k = 3;

    int[] a = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
    int k = 4;
    // Output: 10 10 10 15 15 90 90
    System.out.println(maxOfAllSubArrays(a, k));
  }

  private static List<Integer> maxOfAllSubArrays(int[] a, int k) {
    int i = 0, j = 0;
    List<Integer> list = new ArrayList<>();
    List<Integer> result = new ArrayList<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> e2 - e1);
    while (j < a.length) {
      list.add(a[j]);
      if (j - i + 1 < k) {
        j++;
      } else if (j - i + 1 == k) {
        calMax(list, result, pq);
        list.remove(0);
        j++;
        i++;
      }
    }
    return result;
  }

  private static void calMax(List<Integer> list, List<Integer> result,
                             PriorityQueue<Integer> pq) {

    if(pq.isEmpty()) {
      pq.addAll(list);
    } else {
      pq.add(list.get(list.size() -1));
    }
    result.add(pq.peek());
    pq.remove(list.get(0));
  }
}
