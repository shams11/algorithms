package com.shams.arrays;

public class NthFibonacci {
  public static void main(String[] args) {
    System.out.println("Nth fibonacci number is : " + getNthFibonacci(1));
  }

  // Time complexity :  O(n)
  // space complexity : O(1)
  private static int getNthFibonacci(int n) {
    // Fibonacci series
    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233,
    // 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711,
    // 28657, 46368, 75025, 121393, 196418, 317811, ...
    int[] a = {0, 1};
    int next;
    for (int i = 2; i < n; ++i) {
      next = a[1] + a[0];
      a[0] = a[1];
      a[1] = next;
    }
    return n > 1 ? a[1] : a[0];
  }

  // Recursive
  // Time complexity :  O(2^n)
  // space complexity : O(n)
  private static int nthFib(int n) {
    if (n == 1)
      return 0;
    if (n == 2)
      return 1;
    return nthFib(n - 1) + nthFib(n - 2);
  }
}
