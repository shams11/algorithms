/**
 * https://leetcode.com/problems/minimum-cost-to-connect-sticks/submissions/
 * */
package com.shams.heap;

import java.util.PriorityQueue;

public class MinSticks {
  public static void main(String[] args) {
    // Input: sticks = [2,4,3]
    //Output: 14
    //Explanation: You start with sticks = [2,4,3].
    //1. Combine sticks 2 and 3 for a cost of 2 + 3 = 5. Now you have sticks = [5,4].
    //2. Combine sticks 5 and 4 for a cost of 5 + 4 = 9. Now you have sticks = [9].
    //There is only one stick left, so you are done. The total cost is 5 + 9 = 14.

    int[] sticks = {2, 4, 3};
    System.out.println(connectSticks(sticks));
  }

  public static int connectSticks(int[] sticks) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> e1 - e2);
    for(int stick : sticks) {
      pq.add(stick);
    }

    int minCost = 0;
    int totalCost = 0;

    while(!pq.isEmpty()) {
      if(pq.size() == 1) return totalCost;

      int stick1 = pq.poll();
      int stick2 = pq.poll();
      totalCost += stick1 + stick2;
      pq.add(stick1 + stick2);
    }
    return totalCost;
  }
}
