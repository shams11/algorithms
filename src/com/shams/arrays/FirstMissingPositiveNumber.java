package com.shams.arrays;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositiveNumber {
  public static void main(String[] args) {
    // int[] A = {-1, -3}; // Output 1
    int[] A = {1, 3, 6, 4, 1, 2}; // Output : 5
    System.out.println(findFirstMissingPositiveNumber(A));
  }

  static int findFirstMissingPositiveNumber(int[] A) {
    int N = A.length;
    Set<Integer> set = new HashSet<>();
    for (int a : A) {
      if (a > 0) {
        set.add(a);
      }
    }
    for (int i = 1; i <= N + 1; i++) {
      if (!set.contains(i)) {
        return i;
      }
    }
    return 1;
  }
}
