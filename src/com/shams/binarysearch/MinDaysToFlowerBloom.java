/**
 * https://www.youtube.com/watch?v=BUZ0PLt1FAA&list=PLtQWXpf5JNGLGkKSGYW6KA0Q71t__6CgQ&index=6&ab_channel=MichaelMuinos
 * https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 */

package com.shams.binarysearch;

public class MinDaysToFlowerBloom {
  public static void main(String[] args) {
    // [1,10,3,10,2]
    //  m = 3
    // k = 1
    // Output : 3

    // [1,10,3,10,2]
    //int m = 3, k = 2;
    // Output = -1

    // [7,7,7,7,12,7,7]
    //  m = 2, k = 3
    // Output : 12
    int[] a = {7, 7, 7, 7, 12, 7, 7};
    int m = 2, k = 3;
    System.out.println(minDays(a, m, k));

  }

  public static int minDays(int[] bloomDay, int m, int k) {
    int n = bloomDay.length;
    int res = -1;
    // if((m * k)  > n) {
    //     return -1;
    // }
    int start = 1, end = Integer.MIN_VALUE, mid;
    for (int i = 0; i < n; i++) {
      end = Math.max(end, bloomDay[i]);
    }

    while (start <= end) {
      mid = start + (end - start) / 2;
      if (isValidScheme(bloomDay, n, k, m, mid)) {
        res = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return res;
  }

  //    int[] a = {7, 7, 7, 7, 12, 7, 7};
  //    int m = 2, k = 3;
  // mid = 6, is not a valid scheme, then start = mid + 1 = 7
  // mid = (7 + 12) / 2 = 9, then start = 10
  // mid = (10 + 12) / 2 = 11, then start = 12
  // mid = (12 + 12) / 2 = 12, then isValidScheme returns true, 12 is the answer
  static boolean isValidScheme(int[] bloomDay, int n, int k, int totalBouquets, int maxDay) {
    int curBloomFlowerCount = 0;
    int curBouquetCount = 0;
    for (int i = 0; i < n; i++) {
      if (bloomDay[i] <= maxDay) {
        curBloomFlowerCount++;
      } else {
        curBloomFlowerCount = 0;
      }
      if (curBloomFlowerCount == k) {
        curBouquetCount++;
        curBloomFlowerCount = 0;
      }
      if (curBouquetCount == totalBouquets) {
        return true;
      }
    }
    return false;
  }
}
