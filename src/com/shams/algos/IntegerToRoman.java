/***
 * https://www.youtube.com/watch?v=yzB4M-UXqgI
 * https://leetcode.com/problems/integer-to-roman/submissions/
 * */

package com.shams.algos;

public class IntegerToRoman {

  public static void main(String[] args) {

    System.out.println(intToRoman(1994));
  }

  public static class Numeral {
    int value;
    String symbol;

    Numeral(int val, String symbol) {
      this.value = val;
      this.symbol = symbol;
    }
  }

  static Numeral[] numerals = {

      new Numeral(1000, "M"),
      new Numeral(900, "CM"),
      new Numeral(500, "D"),
      new Numeral(400, "CD"),
      new Numeral(100, "C"),
      new Numeral(90, "XC"),
      new Numeral(50, "L"),
      new Numeral(40, "XL"),
      new Numeral(10, "X"),
      new Numeral(9, "IX"),
      new Numeral(5, "V"),
      new Numeral(4, "IV"),
      new Numeral(1, "I")
  };

  public static String intToRoman(int num) {
    String output = "";
    for (Numeral numeral : numerals) {
      int numberOfSymbols = num / numeral.value;
      output += numeral.symbol.repeat(numberOfSymbols);
      num = num % numeral.value;
    }
    return output;
  }
}
