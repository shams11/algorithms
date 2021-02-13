/**
 * https://leetcode.com/problems/k-th-symbol-in-grammar/
 * https://www.youtube.com/watch?v=5P84A0YCo_Y&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=10&ab_channel=AdityaVerma
 */

package com.shams.recursion;

public class KthGrrammer {
  public static void main(String[] args) {
    System.out.println(kthGrammar(4, 5));
  }

  public static int kthGrammar(int N, int K) {
    if (N == 1 && K == 1)
      return 0;
    int mid = (int) (Math.pow(2, N - 1) / 2);
    if (K <= mid) {
      return kthGrammar(N - 1, K);
    } else {
      return (kthGrammar(N - 1, (int) (K - mid))) ^ 1; // xor or result
    }
  }
}
