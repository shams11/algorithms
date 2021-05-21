package com.shams.trees.binarytrees;

import java.util.ArrayList;
import java.util.List;

public class RightView {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(4);
    System.out.println(rightSideView(root));

    //Input: root = [1,2,3,null,5,null,4]
    //Output: [1,3,4]
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static List<Integer> rightSideView(TreeNode root) {
    if(root == null) {
      return List.of();
    }
    List<Integer> result = new ArrayList<>();
    rightView(root, 0, result);
    return result;
  }
  static int min = Integer.MIN_VALUE;
  private static void rightView(TreeNode root, int curLevel, List<Integer> result) {
    if(root == null) {
      return;
    }
    if(curLevel > min) {
      min = curLevel;
      result.add(root.val);
    }
    rightView(root.right, curLevel+1, result);
    rightView(root.left, curLevel+1, result);
  }
}
