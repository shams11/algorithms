/**
 * https://www.youtube.com/watch?v=L6cffskouPQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=12&ab_channel=AdityaVerma
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
 * */
package com.shams.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {
  public static void main(String[] args) {
    //String s = "pwwkew";
    String s = "aabaab!bb";
    System.out.println(lengthOfLongestSubstring(s));
  }

  public static int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int i = 0, j = 0, max = 0;
    while(j < s.length()) {
      // calculation
      Character charAtj = s.charAt(j);
      if(map.containsKey(charAtj)) {
        map.put(charAtj, map.getOrDefault(charAtj, 0) + 1);
      } else {
        map.put(charAtj, 1);
      }

      // is map size equal to window size?
      // meaning  now map has unique characters
      if(map.size() == j-i+1) {
        max = Math.max(max, j-i+1);
        j++;
      } else if(map.size() < j-i+1) {
        while(map.size() < j-i+1) {
          Character charAti = s.charAt(i);
          map.put(charAti, map.getOrDefault(charAti, 0) - 1);
          if(map.get(charAti) == 0) {
            map.remove(charAti);
          }
          i++;
        }
        j++;
      }
    }
    return max;
  }
}
