/**
 * https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
 * https://www.youtube.com/watch?v=8uvWmiawJ8Q&ab_channel=AbrarSher
 */

package com.shams.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RodCutting {
  public static void main(String[] args) {
    int[] cuts = {3, 5, 1, 4};
    int N = 7;
  //   Output: 16

//    int N = 9;
//    int[] cuts = {5,6,1,4,2};
   // Output: 22
    System.out.println(minCost(cuts, N));
  }

  public static int minCost(int[] cuts, int n) {


    int[] c = new int[cuts.length + 2];
    int[][] t = new int[c.length][c.length];
    for (int i = 0; i < cuts.length; i++) {
      c[i + 1] = cuts[i];
    }
    c[c.length - 1] = n;
    Arrays.sort(c);
    for(int i = 0; i < c.length; i++) {
      for(int j = i-1; j >= 0 ; j--) {
        for(int k = i-1; k > j; k--) {
          t[j][i] =  Math.min(t[j][i] == 0 ? Integer.MAX_VALUE : t[j][i] , (t[j][k] + t[k][i]) + (c[i] - c[j]));
        }
      }
    }
    return t[0][c.length-1];
  }
}
