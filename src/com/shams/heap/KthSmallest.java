/***
 * https://www.youtube.com/watch?v=4BfL2Hjvh8g&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=3&ab_channel=AdityaVerma
 * */
package com.shams.heap;

import java.util.PriorityQueue;

public class KthSmallest {

  public static void main(String[] args) {
    int[] a = {7, 10, 4, 3, 20, 15};
    int k = 6;
    System.out.println("kth smallest element is : " + kthSmallestElement(a, k));
  }

  private static int kthSmallestElement(int[] a, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> e2 - e1);
    for(int i : a) {
      pq.add(i);
      if(pq.size() > k) {
        pq.poll();
      }
    }
    return pq.poll();
  }
}
