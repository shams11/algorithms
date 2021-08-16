/**
 * https://leetcode.com/problems/add-strings/
 * */
package com.shams.strings;

public class AddStrings {
  public static void main(String[] args) {
    // Input: num1 = "11", num2 = "123"
    //Output: "134"
    System.out.println(addStrings("11", "123"));
  }

  public static String addStrings(String num1, String num2) {

    int p1 = num1.length() - 1; int p2 = num2.length() - 1;
    StringBuilder res = new StringBuilder();
    int carry = 0;
    while(p1 >= 0 || p2 >= 0) {
      int sum = 0;
      int digit1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
      int digit2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
      sum = carry + digit1 + digit2;
      int num = sum % 10;
      carry = sum / 10;
      res.append(num);
      p1--; p2--;
    }
    if(carry > 0) {
      res.append(carry);
    }
    return res.reverse().toString();
  }
}
