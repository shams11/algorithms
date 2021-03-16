/**
 * https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
 * https://www.youtube.com/watch?v=-GtpxG6l_Mc
 * */
package com.shams.dp;

import java.util.ArrayList;
import java.util.List;

public class MinSubsetSumDiff {
  public static void main(String[] args) {
    int[] a = {1, 2, 7};
    int n = a.length;
    System.out.println(findMinSubsetDiff(a, n));
  }

  private static int findMinSubsetDiff(int[] a, int n) {
    int sum = 0;
    for (int i = 0; i < n; ++i) {
      sum += a[i];
    }
    boolean[][] t = new boolean[n + 1][sum + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < sum + 1; j++) {
        if (i == 0) {
          t[i][j] = false;
        }
        if (j == 0) {
          t[i][j] = true;
        }
      }
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {
        if (a[i - 1] > j) {
          t[i][j] = t[i - 1][j];
        } else {
          t[i][j] = t[i - 1][j] || t[i - 1][j - a[i - 1]];
        }
      }
    }

    // s1 will lie in the first half of the sum's range
    // if 10 is the range, 1-4 is s1 and 6-9 is s2
    // figure out which elemets in the range are contributing to sum from the last row of the matrix t
    int min = Integer.MAX_VALUE;
    List<Integer> lastRowInMatrix = new ArrayList<>();
    for (int j = sum / 2; j >= 0; j--) {
      if (t[n][j]) {
        lastRowInMatrix.add(j);
      }
    }

    // if [1, 2, 7] is the input, then the elements (which are s1) in the last row of the matrix which are
    // contributing to sum. place these s1's in sum - 2 * s1 and take min, that will be the answer
    for (Integer i : lastRowInMatrix) {
      min = Math.min(min, sum - 2 * i);
    }
    return min;
  }
}
