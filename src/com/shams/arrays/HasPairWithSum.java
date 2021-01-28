package com.shams.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HasPairWithSum {

  public static void main(String[] args) {
    int[] a = {1, 2, 4, 4};
    int[] a1 = {9, 3, 4, 2, 7, 6, 8, 1, 5};
    hasPair(a1, 17);
  }

  private static void hasPair(int[] a, int sum) {
    Set<Integer> comp = new HashSet<>();
    Arrays.stream(a).forEach(value -> {
      if (comp.contains(value)) {
        System.out.println("contains pair");
        return;
      }
      comp.add(sum - value);
    });
  }
}
