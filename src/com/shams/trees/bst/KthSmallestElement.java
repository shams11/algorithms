/**
 * https://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
 * 27-Jan-2021
 */

package com.shams.trees.bst;

import com.shams.commons.UtilityHelper;

public class KthSmallestElement {
  static int count = 0;

  public static void main(String[] args) {
    UtilityHelper.Node root = new UtilityHelper.Node(5);
    UtilityHelper.insertNodeInBST(root, 4);
    UtilityHelper.insertNodeInBST(root, 7);
    UtilityHelper.insertNodeInBST(root, 3);
    UtilityHelper.insertNodeInBST(root, 2);
    UtilityHelper.insertNodeInBST(root, 1);
    UtilityHelper.insertNodeInBST(root, 6);
    UtilityHelper.insertNodeInBST(root, 8);
    UtilityHelper.insertNodeInBST(root, 9);
    UtilityHelper.inorder(root);
    int k = 10;
    // UtilityHelper.Node node = kthSmallestElement(root, k);
    UtilityHelper.Node node = kthLargestElement(root, k);
    System.out.println(k + "th smallest element is : " + node.val);
  }

//  private static UtilityHelper.Node kthSmallestElement(UtilityHelper.Node root, int k) {
//    if (root == null) {
//      return null;
//    }
//    UtilityHelper.Node left = kthSmallestElement(root.left, k);
//    if (left != null) {
//      return left;
//    }
//    count++;
//    if (count == k) {
//      return root;
//    }
//    return kthSmallestElement(root.right, k);
//  }


  private static UtilityHelper.Node kthSmallestElement(UtilityHelper.Node root, int k) {
    if (root == null) {
      return null;
    }
    UtilityHelper.Node left = kthSmallestElement(root.left, k);
    if (left != null && count == k) {
      return left;
    }
    count++;
    if (count == k) {
      return root;
    }
    UtilityHelper.Node right =  kthSmallestElement(root.right, k);
    if (right != null && count == k) {
      return right;
    }
    return null;
  }

  private static UtilityHelper.Node kthLargestElement(UtilityHelper.Node root, int k) {
    if (root == null) {
      return null;
    }
    UtilityHelper.Node right = kthLargestElement(root.right, k);
    if (right != null && count == k) {
      return right;
    }
    count++;
    if (count == k) {
      return root;
    }
    UtilityHelper.Node left =  kthLargestElement(root.left, k);
    if (left != null && count == k) {
      return left;
    }
    return null;
  }
}
