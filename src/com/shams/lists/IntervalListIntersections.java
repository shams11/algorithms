/**
 * https://leetcode.com/problems/interval-list-intersections/
 * https://www.youtube.com/watch?v=OIcM-ZQQ6Rs&ab_channel=WorkWithGoogler
 */

package com.shams.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class IntervalListIntersections {
  public static void main(String[] args) {
    int[][] firstList = {{8, 15}};
    int[][] secondList = {{2, 6}, {8, 10}, {12, 20}};
    int[][] result = intervalIntersection(firstList, secondList);
    System.out.print("[");
    for (int[] r : result) {
      System.out.print("[" + r[0] + "," + r[1] + "]");
    }
    System.out.print("]");

    // Output : [[8,10][12,15]]
  }


  public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    int pA = 0;
    int pB = 0;
    List<int[]> result = new ArrayList<>();
    while(pA < firstList.length && pB < secondList.length) {
      int start = Math.max(firstList[pA][0], secondList[pB][0]);
      int end = Math.min(firstList[pA][1], secondList[pB][1]);
      if(start <= end) {
        result.add(new int[]{start, end});
      }
      if(firstList[pA][1] < secondList[pB][1]) {
        ++pA;
      } else {
        ++pB;
      }
    }
    return result.toArray(new int[result.size()][]);
  }


  // First approach
  static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

  public static int[][] intervalIntersection1(int[][] firstList, int[][] secondList) {
    if (firstList == null || firstList.length == 0 || secondList == null || secondList.length == 0) {
      return new int[0][0];
    }
    for (int[] first : firstList) {
      pq.add(first);
    }

    for (int[] second : secondList) {
      pq.add(second);
    }
    int len = firstList.length + secondList.length;
    List<int[]> result = new ArrayList<>();
    int[] a;
    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      if (!pq.isEmpty()) {
        if (pq.peek()[0] > cur[1]) {

        } else if (pq.peek()[0] >= cur[0] && cur[1] <= pq.peek()[1]) {
          a = new int[]{pq.peek()[0], cur[1]};
          result.add(a);
        } else if (cur[0] == pq.peek()[0] && cur[1] > pq.peek()[1]) {
          a = new int[]{cur[0], pq.peek()[1]};
          pq.add(cur);
          result.add(a);
        }
      }
    }
    int[][] res = new int[result.size()][result.size()];
    for (int i = 0; i < result.size(); i++) {
      res[i] = result.get(i);
    }
    return res;
  }
}
