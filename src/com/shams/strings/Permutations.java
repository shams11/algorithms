/**
 * https://www.geeksforgeeks.org/time-complexity-permutations-string/
 * */

package com.shams.strings;

public class Permutations {

  public static void main(String[] args) {
    perm("abc", "");
  }

  static void perm(String str, String prefix) {
    if (str.length() == 0) {
      System.out.println(prefix);
    } else {
      for (int i = 0; i < str.length(); i++) {
        String rem = str.substring(0, i) + str.substring(i + 1);
        perm(rem, prefix + str.charAt(i));
      }
    }
  }
}
