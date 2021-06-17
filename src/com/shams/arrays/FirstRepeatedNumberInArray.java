package com.shams.arrays;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedNumberInArray {
  public static void main(String[] args) {

    int[] a = {7, 5, 2, 7, 1, 1};
    int firstRepeatedElement = getFirstRepeatedNumber(a);
    System.out.println(firstRepeatedElement);

  }

  private static int getFirstRepeatedNumber(int[] a) {
    Set<Integer> set = new HashSet<>();
    for (int i : a) {
      if(set.contains(i)) return i;
      set.add(i);
    }
    return -1;
  }
}
