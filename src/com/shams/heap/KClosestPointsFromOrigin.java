/**
 * https://www.youtube.com/watch?v=XC4EotTewro&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=9&ab_channel=AdityaVerma
 * https://www.geeksforgeeks.org/find-k-closest-points-to-the-origin/
 * */
package com.shams.heap;

import java.util.PriorityQueue;

public class KClosestPointsFromOrigin {

  static class Pair {
    int dist;
    Point point;

    public Pair(int dist, Point point) {
      this.dist = dist;
      this.point = point;
    }
  }

  static class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) {
//    int[][] points = {
//        {3, 3},
//        {5, -1},
//        {-2, 4}
//    };

    int[][] points = {
        {1, 3},
        {-2, 2}
    };
    int k = 1;
    kClosestPoints(points, k);
  }

  private static void kClosestPoints(int[][] points, int k) {

    // store it in desc order, so that when removed from PQ, points with greater distance will
    // be removed
    PriorityQueue<Pair> pq = new PriorityQueue<>((e1, e2) -> e2.dist - e1.dist);

    for(int[] p : points) {
      int dist = ((p[0] * p[0]) + (p[1] * p[1]));
      Point point = new Point(p[0], p[1]);
      pq.add(new Pair(dist, point));
      if(pq.size() > k) {
        pq.poll();
      }
    }
    while (!pq.isEmpty()) {
      Pair pair = pq.peek();
      System.out.println("[" +  pair.point.x+"," + pair.point.y + "]");
      pq.poll();
    }
  }
}
