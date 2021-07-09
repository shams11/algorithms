/**
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/submissions/
 */

package com.shams.slidingwindow;

import java.util.Arrays;

public class MaxPointsFromCards {
  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5, 6, 1};
    int k = 3;
    System.out.println(maxScore(a, k));
  }

  public static int maxScore(int[] cardPoints, int k) {
    int totalScore = Arrays.stream(cardPoints).sum();
    int n = cardPoints.length;
    if (n == k) {
      return totalScore;
    }
    int windowSize = n - k;
    int score = 0;
    for (int i = 0; i < windowSize; i++) {
      score += cardPoints[i];
    }

    int max = totalScore - score;

    for (int i = 0; i < k; i++) {
      score = score - cardPoints[i] + cardPoints[i + windowSize];
      max = Math.max(max, totalScore - score);
    }
    return max;
  }
}
