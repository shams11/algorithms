/***
 * https://leetcode.com/problems/insert-interval/submissions/
 * */

package com.shams.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervals {
  public static void main(String[] args) {
    // Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    // Output: [[1,2],[3,10],[12,16]]
    // Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
    int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
    int[] newInterval = { 4, 8 };
    System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
  }

  public static int[][] insert(int[][] intervals, int[] newInterval) {

    // if(intervals.length == 0) return new int[]{newInterval};

    List<int[]> result = new ArrayList<>();
    for (int[] interval : intervals) {
      if (interval[0] > newInterval[1]) {
        // Non-overlapping
        // ex : in {12, 16}, 12 is greater than 8 in {4,8}
        result.add(newInterval);
        newInterval = interval; // start over again from this interval
      } else if (interval[1] < newInterval[0]) {
        result.add(interval);
      } else {
        // Overlapping
        newInterval[0] = Math.min(interval[0], newInterval[0]);
        newInterval[1] = Math.max(interval[1], newInterval[1]);
      }
    }
    result.add(newInterval);
    return result.toArray(new int[result.size() - 1][]);
  }
}
