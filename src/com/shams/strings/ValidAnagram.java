/**
 * https://leetcode.com/problems/valid-anagram/submissions/
 */

package com.shams.strings;

public class ValidAnagram {
  public static void main(String[] args) {
    String s = "anagram";
    String t = "nagaram";
    System.out.println(isAnagram(s, t));
  }

  public static boolean isAnagram(String s, String t) {
    int[] alphabets = new int[26];
    for (int i = 0; i < s.length(); i++) {
      alphabets[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < t.length(); i++) {
      alphabets[t.charAt(i) - 'a']--;
    }
    for (int i = 0; i < alphabets.length; i++) {
      if (alphabets[i] != 0) {
        return false;
      }
    }
    return true;
  }
}
