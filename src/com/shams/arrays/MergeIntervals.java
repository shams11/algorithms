/**
 * https://leetcode.com/problems/merge-intervals/discuss/21222/A-simple-Java-solution
 */

package com.shams.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
  public static void main(String[] args) {
    int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    int[][] result = merge(intervals);
    System.out.print("[");
    for(int[] res : result) {
      System.out.print( "[" + res[0] + "," + res[1] + "]" );
      System.out.print(", ");
    }
    System.out.print("]");
  }

  public static int[][] merge(int[][] intervals) {
    if (intervals.length <= 1) return intervals;
    Arrays.sort(intervals, (e1, e2) -> e1[0] - e2[0]);
    int[] newInterval = intervals[0];
    List<int[]> result = new ArrayList<>();
    result.add(newInterval);
    for (int[] interval : intervals) {
      if (interval[0] <= newInterval[1]) {
        newInterval[1] = Math.max(newInterval[1], interval[1]);
      } else {
        newInterval = interval;
        result.add(newInterval);
      }
    }
    return result.toArray(new int[result.size() - 1][]);
  }
}
