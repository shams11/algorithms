/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/submissions/
 * https://www.youtube.com/watch?v=urk8RiuQ0Rs&ab_channel=WorkWithGoogler
 * */
package com.shams.algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RamdomizedSetO1 {
  /**
   * Initialize your data structure here.
   */
  public static void main(String[] args) {
    list = new ArrayList<>();
    map = new HashMap<>();
    rand = new Random();
  }

  static List<Integer> list;
  static Map<Integer, Integer> map;
  static Random rand;


  /**
   * Inserts a value to the set. Returns true if the set did not already contain the specified element.
   */
  public static boolean insert(int val) {
    if (map.containsKey(val)) {
      return false;
    }
    list.add(val);
    map.put(val, list.size() - 1);
    return true;
  }

  private static void swap(int index1, int index2) {
    int num1 = list.get(index1);
    int num2 = list.get(index2);
    list.set(index1, num2);
    list.set(index2, num1);

    map.put(num1, index2);
    map.put(num2, index1);
  }

  /**
   * Removes a value from the set. Returns true if the set contained the specified element.
   */
  public static boolean remove(int val) {
    if (!map.containsKey(val)) {
      return false;
    }
    int index = map.get(val);
    if (index != list.size() - 1) {
      swap(index, list.size() - 1);
    }
    list.remove(list.size() - 1);
    map.remove(val);
    return true;
  }

  /**
   * Get a random element from the set.
   */
  public static int getRandom() {
    return list.get(rand.nextInt(list.size()));
  }
}
