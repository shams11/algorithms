/**
 * https://leetcode.com/problems/binary-tree-paths/
 */

package com.shams.trees.binarytrees;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPaths {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(5);
    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(2);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(4);
    root.right = new TreeNode(1);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(8);
    System.out.println(rootToLeafPaths(root));
  }

  private static List<List<Integer>> rootToLeafPaths(TreeNode root) {
    if (root == null) {
      return List.of();
    }
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    dfs(root, result, list);
    return result;
  }

  private static void dfs(TreeNode root, List<List<Integer>> result, List<Integer> list) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      result.add(list);
    }
    list.add(root.val);
    dfs(root.left, result, new ArrayList<>(list));
    dfs(root.right, result, new ArrayList<>(list));
  }
}
