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

    int min = Integer.MAX_VALUE;
    List<Integer> lastRowInMatrix = new ArrayList<>();
    for (int j = sum / 2; j >= 0; j--) {
      if (t[n][j]) {
        lastRowInMatrix.add(j);
      }
    }

    for (Integer i : lastRowInMatrix) {
      min = Integer.min(min, sum - 2 * i);
    }
    return min;
  }
}
