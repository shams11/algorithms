/**
 * https://leetcode.com/problems/largest-number/
 */

package com.shams.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
  public static void main(String[] args) {
    int[] nums = {3, 30, 34, 5, 9};
    //Output: "9534330"
    System.out.println(largestNumber(nums));
  }

  public static String largestNumber(int[] nums) {
    String[] strArray = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      strArray[i] = String.valueOf(nums[i]);
    }

    Comparator<String> comp = (s1, s2) -> {
      String str1 = s1 + s2;
      String str2 = s2 + s1;
      return str2.compareTo(str1);
    };

    Arrays.sort(strArray, comp);
    // An extreme edge case by lc, say you have only a bunch of 0 in your int array
    if (strArray[0].equals("0")) return "0";
    StringBuilder sb = new StringBuilder();
    for (String s : strArray) {
      sb.append(s);
    }
    return sb.toString();
  }
}
