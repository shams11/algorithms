/**
 * https://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
 * 27-Jan-2021
 */

package com.shams.trees.bst;

import com.shams.commons.UtilityHelper;

public class KthSmallestElement {
  static int count = 0;

  public static void main(String[] args) {
    UtilityHelper.Node root = new UtilityHelper.Node(20);
    UtilityHelper.insertNodeInBST(root, 8);
    UtilityHelper.insertNodeInBST(root, 22);
    UtilityHelper.insertNodeInBST(root, 4);
    UtilityHelper.insertNodeInBST(root, 12);
    UtilityHelper.insertNodeInBST(root, 10);
    UtilityHelper.insertNodeInBST(root, 14);
    UtilityHelper.inorder(root);
    int k = 7;
    UtilityHelper.Node node = kthSmallestElement(root, k);
    System.out.println("kth largest element is : " + node.val);
  }

  private static UtilityHelper.Node kthSmallestElement(UtilityHelper.Node root, int k) {
    if (root == null) {
      return null;
    }
    UtilityHelper.Node left = kthSmallestElement(root.left, k);
    if (left != null) {
      return left;
    }
    count++;
    if (count == k) {
      return root;
    }
    return kthSmallestElement(root.right, k);
  }
}
