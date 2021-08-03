/**
 * https://www.youtube.com/watch?v=0e8VrFwkNdc&list=PLOAph0xkZvSsHbTgufVQ4O8lx6-_OQk2U&index=7&ab_channel=WorkWithGooglerWorkWithGoogler
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * **/
package com.shams.paranthesis;

public class MinRemoveToMakeValidParenthesis {
  public static void main(String[] args) {
    // Input: s = "lee(t(c)o)de)"
    //Output: "lee(t(c)o)de"
    //Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
    String s = "lee(t(c)o)de)";
    System.out.println(minRemoveToMakeValid(s));
  }

  public static String minRemoveToMakeValid(String s) {
    if(s == null || s.equals("")) return "";

    int count = 0;
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(c == '(') {
        count++;
      } else if (c == ')'){
        // don't add additional ')' to sb
        if(count == 0) continue;

        count--;
      }
      sb.append(c);
    }
    System.out.println(sb);

    // if the inout is : "))((", then below code will remove additional ')
    // Expected output is "" for this input
    StringBuilder res = new StringBuilder();
    for(int i = sb.length() -1; i >= 0; i--) {
      char c = sb.charAt(i);
      if(sb.charAt(i) == '(' && count > 0) {
        count--;
        continue;
      }
      res.append(c);
    }
    return res.reverse().toString();
  }
}
