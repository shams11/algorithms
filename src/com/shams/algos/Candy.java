/**
 * https://leetcode.com/problems/candy/
 * https://www.youtube.com/watch?v=h6_lIwZYHQw&ab_channel=TECHDOSE
 * */
package com.shams.algos;

import java.util.Arrays;

public class Candy {
  public static void main(String[] args) {
    int[] a = {1, 0, 2};
    System.out.println(candy(a));
  }

  public static int candy(int[] ratings) {
    int n = ratings.length;
    if(n == 1) return 1;

    int totalCandies = 0;
    int[] left = new int[n];
    int[] right = new int[n];
    Arrays.fill(left, 1);
    Arrays.fill(right, 1);

    for(int i = 1; i < n; i++) {
      if(ratings[i] > ratings[i-1]) {
        left[i] = left[i-1] + 1;
      }
    }

    for(int i = n-2; i >= 0; i--) {
      if(ratings[i] > ratings[i+1]) {
        right[i] = right[i+1] + 1;
      }
    }
    for(int i = 0; i < n; i++) {
      totalCandies += Math.max(left[i], right[i]);
    }
    return totalCandies;
  }
}
