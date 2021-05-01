/***
 * https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 * */
package com.shams.arrays;

import java.util.Arrays;
import java.util.List;

public class TrainMinPlatforms {
  static int findPlatform(int arr[], int dep[], int n){
    // Sort arrival and departure arrays
    Arrays.sort(arr);
    Arrays.sort(dep);

    // plat_needed indicates number of platforms
    // needed at a time
    int plat_needed = 1, result = 1;
    int i = 1, j = 0;

    // Similar to merge in merge sort to process
    // all events in sorted order
    while (i < n && j < n) {
      // If next event in sorted order is arrival,
      // increment count of platforms needed
      if (arr[i] <= dep[j]) {
        plat_needed++;
        i++;
      }

      // Else decrement count of platforms needed
      else if (arr[i] > dep[j]) {
        plat_needed--;
        j++;
      }

      // Update result if needed
      if (plat_needed > result)
        result = plat_needed;
    }

    return result;
  }


  static class Pair {
    int startTime;
    int endTIme;

    Pair(int st, int et) {
      this.startTime = st;
      this.endTIme = et;
    }
  }

  int getMinPlatforms(List<Pair> input) {
    //Stack<>
    for(Pair pair : input) {

    }
    return 0;
  }

  // Driver code
  public static void main(String[] args)
  {
    int arr[] = { 100, 140, 150, 200, 215 };
    int dep[] = { 110, 300, 220, 230, 315 };
    int n = arr.length;
    System.out.println("Minimum Number of Platforms Required = "
        + findPlatform(arr, dep, n));
  }
}
