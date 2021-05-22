/**
 * https://leetcode.com/problems/decode-string/discuss/87534/Simple-Java-Solution-using-Stack
 * https://www.youtube.com/watch?v=0iQqj5egK9k&ab_channel=NickWhiteNickWhiteVerified
 * */
package com.shams.strings;

import java.util.Stack;

public class DecodeString {
  public static void main(String[] args) {
//    Input: s = "abc3[cd]xyz"
//    Output: "abccdcdcdxyz"
    String s = "abc3[cd]xyz";
    System.out.println(decodeString(s));
  }

  public static String decodeString(String s) {
    Stack<String> tempResultStack = new Stack<>();
    Stack<Integer> countStack = new Stack<>();
    String res = "";
    int i = 0;
    while (i < s.length()) {
      if (Character.isDigit(s.charAt(i))) {
        int count = 0;
        while (Character.isDigit(s.charAt(i))) {
          count = count * 10 + s.charAt(i) - '0';
          i++;
        }
        countStack.push(count);
      } else if (s.charAt(i) == ']') {
        StringBuilder temp = new StringBuilder(tempResultStack.pop());
        int curCount = countStack.pop();
        for (int j = 0; j < curCount; j++) {
          temp.append(res);
        }
        res = temp.toString();
        i++;
      } else if (s.charAt(i) == '[') {
        tempResultStack.push(res);
        res = "";
        i++;
      } else {
        res += s.charAt(i);
        i++;
      }
    }
    return res;
  }
}
