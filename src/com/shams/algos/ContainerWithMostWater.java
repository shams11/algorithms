/**
 * https://leetcode.com/problems/container-with-most-water/
 * https://www.youtube.com/watch?v=JMmKtYH5VOE&ab_channel=MichaelMuinosMichaelMuinos
 */

package com.shams.algos;

public class ContainerWithMostWater {
  /**Input: height = [1,8,6,2,5,4,8,3,7]
   Output: 49
   Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
   In this case, the max area of water (blue section) the container can contain is 49.
   *
   *  i = 0 width = 8-0 = 8, len = [1], area = 7 max = 7
   *     i = 1 width = 8-1 = 7, len = [7], area = 49 max = 49
   *     j = 7 width = 7-1 = 6, len = [3], area = 18 max = 49
   *     j = 6 width = 6-1 = 5, len = [8], area = 40 max = 40
   * */
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
