/**
 * https://leetcode.com/problems/container-with-most-water/
 * https://www.youtube.com/watch?v=JMmKtYH5VOE&ab_channel=MichaelMuinosMichaelMuinos
 */

package com.shams.algos;

public class ContainerWithMostWater {
  public static void main(String[] args) {
    int[] a = {2, 3, 4, 5, 18, 17, 6};
    System.out.println(maxArea(a));
  }

  public static int maxArea(int[] height) {
    int max = Integer.MIN_VALUE;
    int i = 0, j = height.length - 1;

    while (i < j) {
      int lh = height[i];
      int rh = height[j];
      int width = j - i;
      int length = Math.min(lh, rh);
      int area = width * length;
      max = Math.max(max, area);

      if (lh < rh) i++;
      else if (rh < lh) j--;
      else {
        i++;
        j--;
      }
    }
    return max;
  }
}
