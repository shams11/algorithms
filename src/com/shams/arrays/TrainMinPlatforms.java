/***
 * https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 * */

package com.shams.arrays;

import java.util.Arrays;

public class TrainMinPlatforms {

  public static void main(String[] args) {
    int[] arr = {100, 140, 150, 200, 215};
    int[] dep = {110, 300, 220, 230, 315};
    int n = arr.length;
    System.out.println("Minimum Number of Platforms Required = "
        + findPlatform(arr, dep, n));
  }

  static int findPlatform(int[] arr, int[] dep, int n) {
    Arrays.sort(arr);
    Arrays.sort(dep);

    int platforms = 1, result = 1;
    int i = 1, j = 0;

    while (i < n && j < n) {
      if (arr[i] <= dep[j]) {
        platforms++;
        i++;
      } else if (arr[i] > dep[j]) {
        platforms--;
        j++;
      }
      result = Math.max(result, platforms);
    }
    return result;
  }
}
