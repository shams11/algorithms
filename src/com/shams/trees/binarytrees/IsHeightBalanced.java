package com.shams.trees.binarytrees;

import com.shams.commons.UtilityHelper;

public class IsHeightBalanced {
  public static void main(String[] args) {
    UtilityHelper.Node root = new UtilityHelper.Node(1);
    root.left = new UtilityHelper.Node(2);
    root.right = new UtilityHelper.Node(3);
    root.left.left = new UtilityHelper.Node(4);
    root.left.right = new UtilityHelper.Node(5);
    root.left.left.left = new UtilityHelper.Node(8);
    if (isHeightBalanced(root) != -1) {
      System.out.println("Tree is balanced");
      return;
    }
    System.out.println("Tree is not balanced");
  }

  private static int isHeightBalanced(UtilityHelper.Node node) {
    if (node == null) {
      return 0;
    }
    int lHeight = isHeightBalanced(node.left);
    if (lHeight == -1) {
      return -1;
    }
    int rHeight = isHeightBalanced(node.right);
    if (rHeight == -1) {
      return -1;
    }
    if (Math.abs(lHeight - rHeight) > 1) {
      return -1;
    }
    return 1 + Math.max(lHeight, rHeight);
  }
}
