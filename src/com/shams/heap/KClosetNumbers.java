/**
 * https://www.youtube.com/watch?v=J8yLD-x7fBI&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=6&ab_channel=AdityaVerma
 * https://www.geeksforgeeks.org/find-k-closest-numbers-in-an-unsorted-array/
 */

package com.shams.heap;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosetNumbers {

  static class Pair {
    int absDiff;
    int arrayNumber;

    Pair(int absDiff, int arrayNum) {
      this.absDiff = absDiff;
      this.arrayNumber = arrayNum;
    }
  }

  public static void main(String[] args) {
    int[] a = {-10, -50, 20, 17, 80};
    int x = 20;
    int k = 2;
    System.out.println(kClosestNumbers(a, x, k));
  }

  private static List<Integer> kClosestNumbers(int[] a, int x, int k) {
    PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.absDiff - p1.absDiff);
    for (int i : a) {
      pq.add(new Pair(abs(x - i), i));
      if (pq.size() > k) {
        pq.poll();
      }
    }
    List<Integer> list = new ArrayList<>();
    while (pq.size() > 0) {
      Pair pair = pq.peek();
      list.add(pair.arrayNumber);
      pq.poll();
    }
    return list;
  }
}
