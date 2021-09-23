/**
 * https://leetcode.com/problems/merge-intervals/discuss/21222/A-simple-Java-solution
 */

package com.shams.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
  /**
   * The idea is to sort the intervals by their starting points.
   * Then, we take the first interval and compare its end with the next intervals starts.
   * As long as they overlap, we update the end to be the max end of the overlapping intervals.
   * Once we find a non overlapping interval,
   * we can add the previous "extended" interval and start over.
   *
   * Sorting takes O(n log(n)) and merging the intervals takes O(n).
   * So, the resulting algorithm takes O(n log(n)).
   * */
  public static void main(String[] args) {
    int[][] intervals = {{1, 3},  {8, 10}, {15, 18}, {2, 6}};
    // Output : [[1,6], [8,10], [15,18], ]
    int[][] result = merge(intervals);
    System.out.print("[");
    for(int[] res : result) {
      System.out.print( "[" + res[0] + "," + res[1] + "]" );
      System.out.print(",");
    }
    System.out.print("]");
  }

  public static int[][] merge(int[][] intervals) {
    if (intervals.length <= 1) return intervals;
    Arrays.sort(intervals, (e1, e2) -> e1[0] - e2[0]);
    int[] previousInterval = intervals[0];
    List<int[]> result = new ArrayList<>();
    result.add(previousInterval);
    for (int[] interval : intervals) {
      if (interval[0] <= previousInterval[1]) {
        previousInterval[1] = Math.max(previousInterval[1], interval[1]);
      } else {
        previousInterval = interval;
        result.add(previousInterval);
      }
    }
    return result.toArray(new int[result.size() - 1][]);
  }
}
