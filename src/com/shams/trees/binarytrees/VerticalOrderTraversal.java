/**
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 * https://www.youtube.com/watch?v=vGkg_R8klu8&ab_channel=WorkWithGoogler
 * */
package com.shams.trees.binarytrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerticalOrderTraversal {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
//    TreeNode root = new TreeNode(3);
//    root.left = new TreeNode(9);
//    root.right = new TreeNode(20);
//    root.right.left = new TreeNode(15);
//    root.right.right = new TreeNode(7);


    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);

    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(0);
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(1);
    root.right.left.left = new TreeNode(5);
    root.right.right = new TreeNode(7);
    root.right.left.right = new TreeNode(2);

    System.out.println(verticalOrder(root));
    // Output : [[3, 0, 1], [9, 5], [4], [8, 2], [7]]
  }

  static List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    verticalOrderUtil(root, 0);
    columnToNodeMap.forEach((k, v) -> result.add(v));
    return result;
  }

  static Map<Integer, List<Integer>> columnToNodeMap = new HashMap<>();
  private static void verticalOrderUtil(TreeNode root, int col) {
    if (root == null) {
      return;
    }
    if (!columnToNodeMap.containsKey(col)) {
      columnToNodeMap.put(col, new ArrayList<>());
      columnToNodeMap.get(col).add(root.val);
    } else {
      columnToNodeMap.get(col).add(root.val);
    }
    verticalOrderUtil(root.left, col - 1);
    verticalOrderUtil(root.right, col + 1);
  }
}
