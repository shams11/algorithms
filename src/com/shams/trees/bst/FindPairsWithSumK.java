/***
 * Asked in walmart 1 Round on 1 Jul 2021 3PM
 * https://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/
 * */

package com.shams.trees.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindPairsWithSumK {
  static class Node {
    int val;
    Node left;
    Node right;

    Node(int value) {
      this.val = value;
    }
  }

  public static void main(String[] args) {
    Node root = new Node(100);
    root.left = new Node(50);
    root.left.left = new Node(30);
    root.left.right = new Node(80);
    root.left.left.left = new Node(20);

    root.right = new Node(150);
    root.right.left = new Node(120);
    root.right.left.left = new Node(110);
    root.right.right = new Node(170);
    root.right.right.left = new Node(160);
    root.right.right.right = new Node(180);
    root.right.right.right.left = new Node(170);
    int k = 200;
    System.out.println(getPairsWithSumK(root, k));
  }

  private static List<List<Integer>> getPairsWithSumK(Node root, int k) {
    if (root == null) {
      return null;
    }
    Node cur1 = root;
    Node cur2 = root;
    int val1 = 0, val2 = 0;
    boolean found1 = false, found2 = false;
    Stack<Node> s1 = new Stack<>();
    Stack<Node> s2 = new Stack<>();
    List<List<Integer>> result = new ArrayList<>();
    while (true) {

      // Normal inorder iterative traversal
      while (!found1) {
        if (cur1 != null) {
          s1.push(cur1);
          cur1 = cur1.left;
        } else {
          if (s1.isEmpty()) {
            found1 = true;
          } else {
            cur1 = s1.pop();
            val1 = cur1.val;
            cur1 = cur1.right;
            found1 = true;
          }
        }
      }

      // Reverse inorder iterative traversal
      while (!found2) {
        if (cur2 != null) {
          s2.push(cur2);
          cur2 = cur2.right;
        } else {
          if (s2.isEmpty()) {
            found2 = true;
          } else {
            cur2 = s2.pop();
            val2 = cur2.val;
            cur2 = cur2.left;
            found2 = true;
          }
        }
      }

      if (val1 + val2 == k) {
        List<Integer> list = new ArrayList<>();
        list.add(val1);
        list.add(val2);
        result.add(list);
        found1 = false;
        found2 = false;
      } else if (val1 + val2 < k) {
        found1 = false;
      } else if (val1 + val2 > k) {
        found2 = false;
      }

      if (val1 >= val2) {
        return result;
      }
    }
  }
}
