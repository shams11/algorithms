package com.shams.arrays;

import java.util.HashSet;
import java.util.Set;

public class HasPairWithSum {

  public static void main(String[] args) {
    int[] a = {1, 2, 4, 4};
    int[] a1 = {9, 3, 4, 2, 7, 6, 8, 1, 5};
    System.out.println(hasPair(a1, 2));
  }

  private static boolean hasPair(int[] a, int sum) {
    Set<Integer> set = new HashSet<>();
    for (int value : a) {
      if (set.contains(value)) {
        System.out.println("contains pair");
        return true;
      }
      set.add(sum - value);
    }
    return false;
  }
}
