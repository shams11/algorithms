/**
 * https://leetcode.com/problems/largest-number/
 * */
package com.shams.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
  public static void main(String[] args) {
    int[] nums = {3, 30, 34, 5, 9};
    //Output: "9534330"
    System.out.println(largestNumber(nums));
  }

  public static String largestNumber(int[] num) {
    if (num == null || num.length == 0)
      return "";

    // Convert int array to String array, so we can sort later on
    String[] s_num = new String[num.length];
    for (int i = 0; i < num.length; i++)
      s_num[i] = String.valueOf(num[i]);

    // Comparator to decide which string should come first in concatenation
    Comparator<String> comp = (str1, str2) -> {
      String s1 = str1 + str2;
      String s2 = str2 + str1;
      return s1.compareTo(s2); // reverse order here, so we can do append() later
    };

    Arrays.sort(s_num, comp);
    for(String j : s_num)
    System.out.print(j + " ");
    System.out.println();
    // An extreme edge case by lc, say you have only a bunch of 0 in your int array
    if (s_num[0].charAt(0) == '0')
      return "0";

    StringBuilder sb = new StringBuilder();
    for (String s : s_num)
      sb.append(s);

    return sb.toString();

  }
}
