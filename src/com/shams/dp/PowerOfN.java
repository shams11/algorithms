/**
 *https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
*/
package com.shams.dp;

public class PowerOfN {
  public static void main(String[] args) {
    System.out.println(pow(2,3));
  }

  private static int pow(int x, int y) {
    if(y == 0)
      return 1;
    int temp = pow(x, y);
    if (y %2 == 0)
      return temp * temp;
    else
      return x * temp * temp;
  }
}
