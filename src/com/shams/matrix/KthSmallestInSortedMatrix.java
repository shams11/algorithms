/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */

package com.shams.matrix;

import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {

  public static void main(String[] args) {
    //Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
    //Output: 13
    //Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
    int[][] a = {
        {1, 5, 9},
        {10, 11, 13},
        {12, 13, 15}
    };
    int k = 8;
    System.out.println(kthSmallest(a, k));
  }

  static class Node {
    int x;
    int y;
    int val;

    Node(int x, int y, int value) {
      this.x = x;
      this.y = y;
      this.val = value;
    }
  }

  public static int kthSmallest(int[][] matrix, int k) {
    int m = matrix.length; // # of rows
    int n = matrix[0].length; // # of columns
    PriorityQueue<Node> pq = new PriorityQueue<>((e1, e2) -> e1.val - e2.val);
    for (int i = 0; i < n; i++) {
      pq.add(new Node(0, i, matrix[0][i]));
    }

    for (int i = 0; i < k - 1; i++) {
      Node cur = pq.poll();
      if (cur.x == m - 1) continue;
      pq.add(new Node(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
    }
    return pq.poll().val;
  }
}
