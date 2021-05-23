/**
 * https://leetcode.com/problems/delete-nodes-and-return-forest/
 * https://www.youtube.com/watch?v=aaSFzFfOQ0o&ab_channel=WorkWithGooglerWorkWithGoogler
 * */
package com.shams.trees.binarytrees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    int[] to_delete = {3, 5};
    List<TreeNode> ans = delNodes(root, to_delete);
    // parse each node in and and print it
  }

  public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    Set<Integer> set = new HashSet<>();
    List<TreeNode> list = new ArrayList<>();
    for (int i = 0; i < to_delete.length; i++) {
      set.add(to_delete[i]);
    }
    delNodesHelper(root, set, list);
    if (!set.contains(root.val)) {
      list.add(root);
    }
    return list;
  }

  static TreeNode delNodesHelper(TreeNode root, Set<Integer> set, List<TreeNode> list) {
    if (root == null) {
      return null;
    }
    root.left = delNodesHelper(root.left, set, list);
    root.right = delNodesHelper(root.right, set, list);
    if (set.contains(root.val)) {
      if (root.left != null) {
        list.add(root.left);
      }
      if (root.right != null) {
        list.add(root.right);
      }
      return null;
    }
    return root;
  }
}
