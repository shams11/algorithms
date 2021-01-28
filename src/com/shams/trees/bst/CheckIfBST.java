/**
 * https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
 */

package com.shams.trees.bst;

import com.shams.commons.UtilityHelper;

public class CheckIfBST {

  static UtilityHelper.Node prev;

  public static void main(String[] args) {
    UtilityHelper.Node root = new UtilityHelper.Node(4);
    root.left = new UtilityHelper.Node(2);
    root.right = new UtilityHelper.Node(5);
    root.left.left = new UtilityHelper.Node(1);
    root.left.right = new UtilityHelper.Node(3);
    UtilityHelper.inorder(root);
    System.out.println("is BST : " + isBST(root));
  }

  private static boolean isBST(UtilityHelper.Node root) {
    if(root == null)
      return true;

    if(!isBST(root.left))
      return false;

    if(prev != null && prev.val > root.val) {
      return false;
    }
    prev = root;
    return isBST(root.right);
  }
}
