/**
 * https://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
 * https://www.youtube.com/watch?v=C6r1fDKAW_o&ab_channel=KevinNaughtonJr.
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 27-Jan-2021
 */

package com.shams.trees.bst;

import com.shams.commons.UtilityHelper;

public class KthSmallestElement {

  public static void main(String[] args) {
    UtilityHelper.Node root = new UtilityHelper.Node(5);
    UtilityHelper.insertNodeInBST(root, 3);
    UtilityHelper.insertNodeInBST(root, 6);
    UtilityHelper.insertNodeInBST(root, 2);
    UtilityHelper.insertNodeInBST(root, 4);
    UtilityHelper.insertNodeInBST(root, 1);
    int k = 5;
    System.out.println(k + "th smallest element is : " + kthSmallestEle(root, k));
    System.out.println(k + "th largest element is : " + kthLargestEle(root, k));
  }

  static int count = 0;

  public static int kthSmallestEle(UtilityHelper.Node root, int k) {
    count = k;
    return kthSmallest(root);
  }

  private static int kthSmallest(UtilityHelper.Node root) {
    if (root == null) return 0;
    int left = kthSmallest(root.left);
    if (left != 0) return left;
    count--;
    if (count == 0) {
      return root.val;
    }
    return kthSmallest(root.right);
  }

  private static int kthLargestEle(UtilityHelper.Node root, int k) {
    count = k;
    return kthLargest(root);
  }

  private static int kthLargest(UtilityHelper.Node root) {
    if (root == null) {
      return 0;
    }
    int right = kthLargest(root.right);
    if (right != 0) {
      return right;
    }
    count--;
    if (count == 0) {
      return root.val;
    }
    return kthLargest(root.left);
  }
}
