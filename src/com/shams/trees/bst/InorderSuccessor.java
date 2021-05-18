/**
 * https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
 * https://leetcode.com/problems/inorder-successor-in-bst/
 */

package com.shams.trees.bst;

import com.shams.commons.UtilityHelper;

public class InorderSuccessor {

  public static void main(String[] args) {
    UtilityHelper.Node root = new UtilityHelper.Node(20);
    UtilityHelper.insertNodeInBST(root, 8);
    UtilityHelper.insertNodeInBST(root, 22);
    UtilityHelper.insertNodeInBST(root, 4);
    UtilityHelper.insertNodeInBST(root, 12);
    UtilityHelper.insertNodeInBST(root, 10);
    UtilityHelper.insertNodeInBST(root, 14);
    UtilityHelper.Node temp = root.left.right.right;
    UtilityHelper.inorder(root);
    UtilityHelper.Node succ = inorderSuccessor(root, temp);
    if (succ != null) {
      System.out.println("Inorder successor is : " + succ.val);
    } else {
      System.out.println("Inorder successor does not exist");
    }
  }

  private static UtilityHelper.Node inorderSuccessor(
      UtilityHelper.Node root,
      UtilityHelper.Node node) {

    if (root == null || node == null) {
      System.out.println("Invalid input");
      return null;
    }
    if (node.right != null) {
      node = node.right;
      return minValue(node.left);
    }
    UtilityHelper.Node succ = null;
    while (root != null) {
      if (node.val < root.val) {
        succ = root;
        root = root.left;
      } else if (node.val > root.val) {
        root = root.right;
      } else {
        break;
      }
    }
    return succ;
  }

  private static UtilityHelper.Node minValue(UtilityHelper.Node node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }
}
