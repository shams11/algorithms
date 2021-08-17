/**
 * https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
 */

package com.shams.strings;

import java.util.HashMap;
import java.util.Map;

public class NumOfGoodWaysToSplitString {
  public static void main(String[] args) {
    // Input: s = "aacaba"
    //Output: 2
    //Explanation: There are 5 ways to split "aacaba" and 2 of them are good.
    //("a", "acaba") Left string and right string contains 1 and 3 different letters respectively.
    //("aa", "caba") Left string and right string contains 1 and 3 different letters respectively.
    //("aac", "aba") Left string and right string contains 2 and 2 different letters respectively (good split).
    //("aaca", "ba") Left string and right string contains 2 and 2 different letters respectively (good split).
    //("aacab", "a") Left string and right string contains 3 and 1 different letters respectively.
    String s = "aacaba";
    System.out.println(numSplits(s));
  }

  public static int numSplits(String s) {
    if (s.length() == 1) return 1;

    Map<Character, Integer> map1 = new HashMap<>();
    Map<Character, Integer> map2 = new HashMap<>();

    map1.put(s.charAt(0), 1);
    int i = 1;
    while (i < s.length()) {
      char c = s.charAt(i);
      map2.put(c, map2.getOrDefault(c, 0) + 1);
      i++;
    }
    int count = 0;
    i = 1;
    while (i < s.length() && map2.size() > 0) {
      if (map1.size() == map2.size()) ++count;
      char c = s.charAt(i);

      map2.put(c, map2.getOrDefault(c, 0) - 1);
      if (map2.get(c) == 0) map2.remove(c);

      map1.put(c, map1.getOrDefault(c, 0) + 1);
      i++;
    }
    return count;
  }
}
