/**
 * https://practice.geeksforgeeks.org/problems/number-to-words0335/1
 */

package com.shams.algos;

public class IntegerToWords {
  public static void main(String[] args) {
    int N = 1234567891;
    //Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
    System.out.println(integerToString(N));
  }

  private static final String[] LESS_THAN_TWENTY = {
      "", " one ", " two ", " three ", " four ",
      " five ", " six ", " seven ", " eight ",
      " nine ", " ten ", " eleven ", " twelve ",
      " thirteen ", " fourteen ", " fifteen ",
      " sixteen ", " seventeen ", " eighteen ",
      " nineteen "};

  private static final String[] TENS = {
      "", "", " twenty ", " thirty ", " forty ",
      " fifty ", " sixty ", " seventy ", " eighty ",
      " ninety "};

  private static final String[] ABOVE_THOUSAND = {"", " thousand", " million", " billion"};

  private static String integerToString(int num) {
    if (num == 0) return "Zero";

    StringBuilder sb = new StringBuilder();
    int index = 0;
    while (num > 0) {
      if(num % 1000 != 0) {
        // if number is below 1000, come here
        StringBuilder tmp = new StringBuilder();
        buildBelowThousand(tmp, num % 1000);
        sb.insert(0, tmp.append(ABOVE_THOUSAND[index++])). append(" ");
      }
      num = num / 1000;
    }
    return sb.toString().trim();
  }

  private static void buildBelowThousand(StringBuilder sb, int num) {
    if (num == 0) return;
    if (num < 20) {
      sb.append(LESS_THAN_TWENTY[num]);
    }
    else if (num < 100) {
      sb.append(TENS[num / 10]);
      buildBelowThousand(sb, num % 10);
    } else {
      sb.append(LESS_THAN_TWENTY[num / 100]).append("hundred");
      buildBelowThousand(sb, num % 100);
    }
  }
}
