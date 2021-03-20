/***
 * https://www.youtube.com/watch?v=MW4lJ8Y0xXk&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=5&ab_channel=AdityaVerma
 * https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
 * */

package com.shams.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CountAnagrams {
  public static void main(String[] args) {
    String t = "forxxorfxdofr";
    String p = "for";
    System.out.println(countAnagrams(t, p));
  }

  private static int countAnagrams(String t, String p) {
    if (t == null || p == null || t.length() == 0 || p.length() == 0) {
      return 0;
    }
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < p.length(); i++) {
      Character c = p.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int i = 0, j = 0, ans = 0, count = map.size();
    int k = p.length();
    while (j < t.length()) {
      Character endChar = t.charAt(j);
      if (map.containsKey(endChar)) {
        map.put(endChar, map.getOrDefault(endChar, 0) - 1);
        if (map.get(endChar) == 0) {
          count--;
        }
      }
      if (j - i + 1 < k) {
        j++;
      } else if (j - i + 1 == k) {
        if (count == 0) {
          ans++;
        }
        Character startChar = t.charAt(i);
        if (map.containsKey(startChar)) {
          map.put(startChar, map.getOrDefault(startChar, 0) + 1);
          if (map.get(startChar) > 0)
            count++;
        }
        i++;
        j++;
      }
    }

    return ans;
  }
}
