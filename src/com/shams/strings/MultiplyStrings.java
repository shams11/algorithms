/**
 * https://leetcode.com/problems/multiply-strings/
 * https://www.youtube.com/watch?v=hDueaAjITi4&ab_channel=happygirlzt
 * */
package com.shams.strings;

public class MultiplyStrings {
  public static void main(String[] args) {
    String s1 = "10";
    String s2 = "10";
    // Output : 56088
    System.out.println(multiply(s1, s2));
  }
  // For input ""99" and "99"
  // Before -> [0, 0, 0, 0]
  //After -> [0, 0, 8, 1]
  //=================
  //Before -> [0, 0, 8, 1]
  //After -> [0, 8, 9, 1]
  //=================
  //Before -> [0, 8, 9, 1]
  //After -> [0, 17, 0, 1]
  //=================
  //Before -> [0, 17, 0, 1]
  //After -> [9, 8, 0, 1]
  //=================
  private static String multiply(String s1, String s2) {
    int s1Length = s1.length();
    int s2Length = s2.length();
    // result is of length s1Length + s2Length because the answer/result cannot go beyond its length
    int[] result = new int[s1Length + s2Length];
    for (int i = s1Length - 1; i >= 0; --i) {
      for (int j = s2Length - 1; j >= 0; --j) {
        int multiplication = ((s1.charAt(i) - '0') * (s2.charAt(j) - '0'));
        // start from one's position then tens, then hundreds position
        int remainderIndex = i + j + 1;
        int carryIndex = i + j;
        // result[remainderIndex] => because carry needs to be added.
        // carry will be added to n-1th position, so that will be remainder index in the
        // next iteration
        int sum = multiplication + result[remainderIndex];
        result[remainderIndex] = sum % 10;
        result[carryIndex] += sum / 10;
      }
    }
    StringBuilder sb = new StringBuilder();
    for(int res : result) {
      // Going from left to right, remove trailing 0's. ex : {0,1,0,0} => remove 0 at 0th index
      // and return 100
      if(!(sb.length() == 0 && res == 0)) {
        sb.append(res);
      }
    }
    return sb.length() == 0 ? "0" : sb.toString();
  }
}
