/***
 * https://www.youtube.com/watch?v=U1q16AFcjKs
 * https://leetcode.com/problems/minimum-window-substring/
 * */

package com.shams.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
  public static void main(String[] args) {
//    Input: s = "ADOBECODEBANC", t = "ABC"
//    Output: "BANC"
    String s = "ADOBECODEBANC";
    String t = "ABC";
    System.out.println(minWindow(s, t));
  }

  public static String minWindow(String s, String t) {
    if (s == null || t == null || s.length() == 0 || t.length() == 0) return "";

    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      Character c = t.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    int i = 0;
    int j = 0;
    int min = Integer.MAX_VALUE;
    boolean found = false;
    int count = map.size();
    int left = 0, right = s.length() - 1;

    while (j < s.length()) {
      Character endChar = s.charAt(j);
      if (map.containsKey(endChar)) {
        map.put(endChar, map.get(endChar) - 1);
        if (map.get(endChar) == 0) {
          count--;
        }
      }

      if (count > 0)
        j++;
      else if (count == 0) {
        while (count == 0) {
          Character chartAti = s.charAt(i);
          if (map.containsKey(chartAti)) {
            map.put(chartAti, map.getOrDefault(chartAti, 0) + 1);
            if (map.get(chartAti) > 0) {
              count++;
            }
          }
          i++;
        }
        j++;
        if (j - i + 1 < min) {
          min = j - i + 1;
          left = i;
          right = j;
          found = true;
        }
      }
    }
    return !found ? "" : s.substring(left-1, right);
  }
}
