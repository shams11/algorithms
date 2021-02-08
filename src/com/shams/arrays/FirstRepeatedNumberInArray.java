package com.shams.arrays;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstRepeatedNumberInArray {
  public static void main(String[] args) {

    int[] a = {7, 5, 2, 1, 1};
    int firstRepeatedElement = getFirstRepeatedNumber(a);
    System.out.println(firstRepeatedElement);

  }

  private static int getFirstRepeatedNumber(int[] a) {
    Map<Integer, Integer> map = new LinkedHashMap<>();
    for (int item : a) {
      map.put(item, map.getOrDefault(item, 0) + 1);
    }
    System.out.println(map);
    System.out.println();
    for (int value : a) {
      if (map.get(value) > 1) {
        return value;
      }
    }
    return a[0];
  }
}
