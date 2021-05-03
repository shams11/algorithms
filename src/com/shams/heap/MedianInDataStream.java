/**
 * https://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
 * https://www.youtube.com/watch?v=1LkOrc-Le-Y&ab_channel=TECHDOSE
 */

package com.shams.heap;

import java.util.PriorityQueue;

public class MedianInDataStream {
  public static void main(String[] args) {
    int[] a = {5, 3, 4 ,2, 6};
    printMedian(a);
  }

  private static void printMedian(int[] a) {
    for (int i : a) {
      float median = getMedian(i);
      System.out.println(median);
    }
  }

  static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((e1, e2) -> e2 - e1);
  static PriorityQueue<Integer> minHeap = new PriorityQueue<>((e1, e2) -> e1 - e2);

  private static float getMedian(int n) {
    if ((maxHeap.isEmpty() && minHeap.isEmpty())) {
      maxHeap.add(n);
      return maxHeap.peek();
    } else if (maxHeap.size() == minHeap.size()) {
      if (n > minHeap.peek()) {
        maxHeap.add(minHeap.poll());
        minHeap.add(n);
      } else {
        maxHeap.add(n);
      }
      return maxHeap.peek();
    } else {
      if (n > maxHeap.peek()) {
        minHeap.add(n);
      } else {
        minHeap.add(maxHeap.poll());
        maxHeap.add(n);
      }
      return (float)(minHeap.peek() + maxHeap.peek()) / 2;
    }
  }
}
