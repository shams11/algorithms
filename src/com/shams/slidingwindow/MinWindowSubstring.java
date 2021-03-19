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
    int min = s.length();
    boolean found = false;
    int count = map.size();
    int left = 0, right = s.length() - 1;

    while (j < s.length()) {
      Character endChar = s.charAt(j++);
      if (map.containsKey(endChar)) {
        map.put(endChar, map.get(endChar) - 1);
        if (map.get(endChar) == 0) {
          count--;
        }
      }

      if (count > 0)
        continue;

      while (count == 0) {
        Character startChar = s.charAt(i++);
        if (map.containsKey(startChar)) {
          map.put(startChar, map.get(startChar) + 1);
          if (map.get(startChar) > 0) {
            count++;
          }
        }
      }

      if (j - i < min) {
        left = i;
        right = j;
        min = j - i;
        found = true;
      }
    }
    return !found ? "" : s.substring(left - 1, right);
  }
}
